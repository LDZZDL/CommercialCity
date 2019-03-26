package com.fjsf.web.service.impl;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjsf.web.bean.OrderDetailBean;
import com.fjsf.web.bean.OrderMasterBean;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.bean.ShopBean;
import com.fjsf.web.dao.CommentDAO;
import com.fjsf.web.dao.CreditCardDAO;
import com.fjsf.web.dao.CustomerDAO;
import com.fjsf.web.dao.DeliveryAddressDAO;
import com.fjsf.web.dao.OrderDetailDAO;
import com.fjsf.web.dao.OrderMasterDAO;
import com.fjsf.web.dao.ProductDAO;
import com.fjsf.web.dao.ShopDAO;
import com.fjsf.web.dao.ShopperDAO;
import com.fjsf.web.dao.impl.CommentDAOImpl;
import com.fjsf.web.dao.impl.CreditCardDAOImpl;
import com.fjsf.web.dao.impl.CustomerDAOImpl;
import com.fjsf.web.dao.impl.DeliveryAddressDAOImpl;
import com.fjsf.web.dao.impl.OrderDetailDAOImpl;
import com.fjsf.web.dao.impl.OrderMasterDAOImpl;
import com.fjsf.web.dao.impl.ProductDAOImpl;
import com.fjsf.web.dao.impl.ShopDAOImpl;
import com.fjsf.web.dao.impl.ShopperDAOImpl;
import com.fjsf.web.service.inter.CustomerOrderServiceInterface;
import com.fjsf.web.utils.BigDecimalUtils;
import com.fjsf.web.viewobject.CommentView;
import com.fjsf.web.viewobject.CustomerOrderView;
import com.fjsf.web.viewobject.Page;


public class CustomerOrderServiceImpl implements CustomerOrderServiceInterface{

	private OrderMasterDAO orderMasterDAO = new OrderMasterDAOImpl();
	private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
	private DeliveryAddressDAO deliveryAddressDAO = new DeliveryAddressDAOImpl();
	private ProductDAO productDAO = new ProductDAOImpl();
	private ShopDAO shopDAO = new ShopDAOImpl();
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	private ShopperDAO shopperDAO = new ShopperDAOImpl();
	private CreditCardDAO creditCardDAO = new CreditCardDAOImpl();
	private CommentDAO commentDAO = new CommentDAOImpl();
	
	private Integer getCustomerId(HttpServletRequest request){
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		return customerId;
	}
	
	//private String getAction(HttpServletRequest request){
	private String getAction(String action){
		String orderMasterStatus = new String();
		if(action.equals("WaitPay")){
			orderMasterStatus = "待付款";
		}
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
	
	private Page getPage(HttpServletRequest request){
		Integer customerId = getCustomerId(request);
		Page page = new Page();
		page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		String orderMasterStatus = getAction(request.getParameter("action"));
		Integer totalNumber = (int) orderMasterDAO.countOrderMasterWithConditon(customerId, orderMasterStatus);
		page.setTotalNumber(totalNumber);
		if(totalNumber == 0){
			page.setTotalPageNo(0);
		}else{
			page.setTotalPageNo((page.getTotalNumber()-1)/page.getPageSize() + 1);
			if(page.getPageNo() > page.getTotalPageNo()){
				page.setPageNo(page.getTotalPageNo());
			}
		}
		return page;
	}
	
	@Override
	public void getCustomerOrderByCustomerIdWithCondition(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = getCustomerId(request);
		Page page = getPage(request);
		String orderMasterStatus = getAction(request.getParameter("action"));
		System.out.println("orderMasterStatus"+orderMasterStatus);
		List<OrderMasterBean> listOrderMaster = orderMasterDAO.getOrderMasterWithConditon
				(customerId, orderMasterStatus, page.getPageNo(), page.getPageSize());
		if(orderMasterStatus.equals("End")){
			System.out.println("listOrderMaster"+listOrderMaster);
		}
		List<CustomerOrderView> listCustomerOrderView = new ArrayList<>();
		for(OrderMasterBean orderMasterBean:listOrderMaster){
			CustomerOrderView customerOrderView = new CustomerOrderView();
			customerOrderView.setDeliveryAddressBean(deliveryAddressDAO.
					getDeliveryAddressByDeliveryAddressId(orderMasterBean.getDeliveryAddressId()));
			customerOrderView.setOrderId(orderMasterBean.getOrderId());
			customerOrderView.setOrderMasterStatus(orderMasterBean.getOrderMasterStatus());
			customerOrderView.setOrderMasterTime(orderMasterBean.getOrderMasterTime());
			List<OrderDetailBean> listOrderDetailBean = new ArrayList<>();
			if(orderMasterStatus.equals("订单完成")){
				listOrderDetailBean = orderDetailDAO.getOrderDetailByOrderId(orderMasterBean.getOrderId());
				System.out.println("listOrderDetailBean="+listOrderDetailBean);
			}else{
				listOrderDetailBean = orderDetailDAO.getOrderDetailByOrderIdUnCommented(orderMasterBean.getOrderId());
			}
			List<ProductBean> listProductBean = new ArrayList<>();
			List<Integer> listQuantity = new ArrayList<>();
			Integer shopId = 1;
			for(OrderDetailBean orderDetailBean:listOrderDetailBean){
				ProductBean productBean = productDAO.getProductDetailMessage(orderDetailBean.getProductId());
				listProductBean.add(productBean);
				listQuantity.add(orderDetailBean.getQuantity());
				shopId = productBean.getShopId();
			}
			customerOrderView.setListProductBean(listProductBean);
			customerOrderView.setListQuantity(listQuantity);
			customerOrderView.setShopBean(shopDAO.getShopByShopId(shopId));
			listCustomerOrderView.add(customerOrderView);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("order", listCustomerOrderView);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String message = objectMapper.writeValueAsString(map);
			response.getWriter().println(message);
			System.out.println(message);
		} catch (Exception e) {}
	}

	private Page updatePage(HttpServletRequest request, String orderMasterStatus){
		Integer customerId = getCustomerId(request);
		Page page = new Page();
		page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		Integer totalNumber = (int) orderMasterDAO.countOrderMasterWithConditon(customerId, orderMasterStatus);
		page.setTotalNumber(totalNumber);
		if(totalNumber == 0){
			page.setTotalPageNo(0);
		}else{
			page.setTotalPageNo((page.getTotalNumber()-1)/page.getPageSize() + 1);
			if(page.getPageNo() > page.getTotalPageNo()){
				page.setPageNo(page.getTotalPageNo());
			}
		}
		return page;
	}
	
	@Override
	public void deleteOrder(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = getCustomerId(request);
		Integer customerCreditCardId = customerDAO.getCreditCardIdByCustomerId(customerId);
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
		List<OrderDetailBean> listOrderDetail = orderDetailDAO.getOrderDetailByOrderId(orderId);
		Integer shopId = productDAO.getShopIdByProductId(listOrderDetail.get(0).getProductId());
		Integer shopperId = shopDAO.getShopperIdByShopId(shopId);
		Integer shopCreditCardId = shopperDAO.getCreditCardIdByShopperId(shopperId);
		for(OrderDetailBean orderDetailBean: listOrderDetail){
			ProductBean productBean = productDAO.getProductDetailMessage(orderDetailBean.getProductId());
			productDAO.addProductStockByProductId(orderDetailBean.getQuantity(), orderDetailBean.getProductId());
			creditCardDAO.customerReceiveMoney( 
					BigDecimalUtils.getResultMul(productBean.getProductSale(), orderDetailBean.getQuantity()),
					customerCreditCardId);
			creditCardDAO.shopPayMoney( 
					BigDecimalUtils.getResultMul(productBean.getProductSale(), orderDetailBean.getQuantity()),
					shopCreditCardId);
		}
		orderMasterDAO.changeorderMasterStatusByOrderId("订单取消", orderId);
		ObjectMapper mapper = new ObjectMapper();
		Page page = updatePage(request, "待付款");
		try {
			String message = mapper.writeValueAsString(page);
			response.getWriter().println(message);
		} catch (Exception e) {}
	}

	@Override
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = getCustomerId(request);
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
		orderMasterDAO.changeorderMasterStatusByOrderId("待评价", orderId);
		ObjectMapper mapper = new ObjectMapper();
		Page page = updatePage(request, "待发货");
		try {
			String message = mapper.writeValueAsString(page);
			response.getWriter().println(message);
		} catch (Exception e) {}
	}

	@Override
	public void customerRateProduct(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = getCustomerId(request);
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		String content = request.getParameter("content");
		if(content.trim().equals("")){
			content = "系统默认好评";
		}
		Integer rate = Integer.parseInt(request.getParameter("rate"));
		commentDAO.addCommentDAO(customerId, productId, orderId, content, rate, new Date());
		Boolean flag = orderMasterDAO.judgeOrderEnd(orderId);
		if(flag == true){
			orderMasterDAO.changeorderMasterStatusByOrderId("订单完成", orderId);
		}
	}
}
