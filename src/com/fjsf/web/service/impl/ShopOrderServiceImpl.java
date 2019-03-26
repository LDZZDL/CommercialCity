package com.fjsf.web.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjsf.web.bean.OrderDetailBean;
import com.fjsf.web.bean.OrderMasterBean;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.dao.DeliveryAddressDAO;
import com.fjsf.web.dao.OrderDetailDAO;
import com.fjsf.web.dao.OrderMasterDAO;
import com.fjsf.web.dao.ProductDAO;
import com.fjsf.web.dao.impl.DeliveryAddressDAOImpl;
import com.fjsf.web.dao.impl.OrderDetailDAOImpl;
import com.fjsf.web.dao.impl.OrderMasterDAOImpl;
import com.fjsf.web.dao.impl.ProductDAOImpl;
import com.fjsf.web.service.inter.ShopOrderServiceInterface;
import com.fjsf.web.viewobject.Page;
import com.fjsf.web.viewobject.ShopOrderView;

public class ShopOrderServiceImpl implements ShopOrderServiceInterface{
	
	private OrderMasterDAO orderMasterDAO = new OrderMasterDAOImpl();
	private DeliveryAddressDAO deliveryAddressDAO = new DeliveryAddressDAOImpl();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
	private ProductDAO productDAO = new ProductDAOImpl();
	
	private Integer getShopId(HttpServletRequest request){
		Integer shopId = (Integer) request.getSession().getAttribute("LoginShopId");
		if(shopId == null){
			shopId = 1;
		}
		return shopId;
	}
	
	private Integer getShopperId(HttpServletRequest request){
		Integer shopperId = (Integer) request.getSession().getAttribute("LoginShopperId");
		return shopperId;
	}
	
	private String getorderMasterStatus(String action){
		String orderMasterStatus = new String();
		if(action.equals("WaitSend")){
			orderMasterStatus = "待发货";
		}
		if(action.equals("WaitConfirm")){
			orderMasterStatus = "待收货";
		}
		if(action.equals("WaitRate")){
			orderMasterStatus = "待评价";
		}
		if(action.equals("End")){
			orderMasterStatus = "订单完成";
		}
		return orderMasterStatus;
	}
	
	private Page getShopOrderPage(HttpServletRequest request, String orderMasterStatus){
		Page page = new Page();
		orderMasterStatus = getorderMasterStatus(orderMasterStatus);
		Integer shopId = getShopId(request);
		page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		page.setPageSize(8);
		Integer totalNumber = (int) orderMasterDAO.countOrderMasterByShopId(shopId, orderMasterStatus);
		page.setTotalNumber(totalNumber);
		if(totalNumber == 0){
			page.setTotalPageNo(0);
		}else{
			page.setTotalPageNo((page.getTotalNumber()-1)/page.getPageSize()+1);
			if(page.getPageNo() > page.getTotalPageNo()){
				page.setPageNo(page.getTotalPageNo());
			}
		}
		return page;
	}
	
	@Override
	public void showShopOrderMessage(HttpServletRequest request, HttpServletResponse response) {
		Integer shopId = getShopId(request);
		String orderMasterStatus = getorderMasterStatus(request.getParameter("goal"));
		Page page = getShopOrderPage(request, request.getParameter("goal"));
		List<ShopOrderView> listShopOrderView = new ArrayList<>();
		List<OrderMasterBean> listOrderMaster = orderMasterDAO.getOrderMasterMessageByShopId(shopId, 
				orderMasterStatus, page.getPageNo(), page.getPageSize());
		for(OrderMasterBean orderMasterBean: listOrderMaster){
			ShopOrderView shopOrderView = new ShopOrderView();
			shopOrderView.setOrderMasterBean(orderMasterBean);
			shopOrderView.setDeliveryAddressBean(deliveryAddressDAO.
					getDeliveryAddressByDeliveryAddressId(orderMasterBean.getDeliveryAddressId()));
			List<OrderDetailBean> listOrderDetail = orderDetailDAO.
					getOrderDetailByOrderId(orderMasterBean.getOrderId());
			List<Integer> listQuantity = new ArrayList<>();
			List<ProductBean> listProduct = new ArrayList<>();
			for(OrderDetailBean orderDetailBean:listOrderDetail){
				listQuantity.add(orderDetailBean.getQuantity());
				listProduct.add(productDAO.getProductDetailMessage(orderDetailBean.getProductId()));
			}
			shopOrderView.setListProductBean(listProduct);
			shopOrderView.setListQuantity(listQuantity);
			listShopOrderView.add(shopOrderView);
		}
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("order", listShopOrderView);
		String message = new String();
		try {
			message = mapper.writeValueAsString(map);
			//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
		} catch (JsonProcessingException e) {}
		try {
			response.getWriter().println(message);
		} catch (IOException e) {}
	}

	
	@Override
	public void shopConfirmOrder(HttpServletRequest request, HttpServletResponse response) {
		Integer shopId = getShopId(request);
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
		orderMasterDAO.changeorderMasterStatusByOrderId("待收货", orderId);
		
		Page page = getShopOrderPage(request, "WaitSend");
		ObjectMapper mapper = new ObjectMapper();
		
		String message = new String();
		try {
			message = mapper.writeValueAsString(page);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(page));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
