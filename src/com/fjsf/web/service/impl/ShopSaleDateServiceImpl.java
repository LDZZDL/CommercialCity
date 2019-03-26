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
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.dao.OrderMasterDAO;
import com.fjsf.web.dao.ProductDAO;
import com.fjsf.web.dao.impl.OrderMasterDAOImpl;
import com.fjsf.web.dao.impl.ProductDAOImpl;
import com.fjsf.web.service.inter.ShopSaleDateServiceInterface;
import com.fjsf.web.viewobject.Page;

public class ShopSaleDateServiceImpl implements ShopSaleDateServiceInterface{

	private OrderMasterDAO orderMasterDAO = new OrderMasterDAOImpl();
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
	
	@Override
	public void getTodaySaleMoney(HttpServletRequest request, HttpServletResponse response) {
		Integer shopId = getShopId(request);
		
	}

	@Override
	public void getTodaySale(HttpServletRequest request, HttpServletResponse response) {
		Integer shOpId = getShopId(request);
		
	}

	@Override
	public void getTodayHotProduct(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	private Integer getDay(String day){
		if(day.equals("最近一天")){
			return 1;
		}
		if(day.equals("最近三天")){
			return 3;
		}
		if(day.equals("最近一周")){
			return 7;
		}
		if(day.equals("最近一个月")){
			return 30;
		}
		return null;
	}
	
	private Page getOrderSalePage(HttpServletRequest request){
		Integer shopId = getShopId(request);
		Page page = new Page();
		page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		page.setPageSize(5);
		Integer totalNumber = (int) productDAO.countProductBySale(shopId, 
				request.getParameter("orderType"), 
				getDay(request.getParameter("day")));
		page.setTotalNumber(totalNumber);
		if(page.getTotalNumber() == 0){
			page.setTotalPageNo(0);
			page.setPageNo(0);
		}else{
			page.setTotalPageNo((page.getTotalNumber()-1)/page.getPageSize() + 1);
			if(page.getPageNo() > page.getTotalPageNo()){
				page.setPageNo(page.getTotalPageNo());
			}
		}
		return page;
	}
	
	@Override
	public void getProductSale(HttpServletRequest request, HttpServletResponse response) {
		Integer shopId = getShopId(request);
		Page page = getOrderSalePage(request);
		List<ProductBean> listProduct = productDAO.getProductBySale(shopId, 
				request.getParameter("orderType"), 
				getDay(request.getParameter("day")), 
				page.getPageNo(), 
				page.getPageSize());
		List<Integer> listQuantity = new ArrayList<>();
		for(ProductBean productBean: listProduct){
			Integer quantity = (int) productDAO.getProductQuantityByProductId(productBean.getProductId(), 
					request.getParameter("orderType"), 
					getDay(request.getParameter("day")));
			listQuantity.add(quantity);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("product", listProduct);
		map.put("quantity", listQuantity);
		map.put("page", page);
		//=========================================================//
		
		map.put("todayorderquantity", orderMasterDAO.getTodayOrderQuantity(shopId));
		map.put("todayproductquantity", orderMasterDAO.getTodayProductQuantity(shopId));
		map.put("todaysalemoney", orderMasterDAO.getTodaySaleMoney(shopId));
		
		//========================================================//
		ObjectMapper objectMapper = new ObjectMapper();
		String message = new String();
		try {
			message = objectMapper.writeValueAsString(map);
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
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
