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
import com.fjsf.web.bean.CommentBean;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.dao.CommentDAO;
import com.fjsf.web.dao.ProductDAO;
import com.fjsf.web.dao.impl.CommentDAOImpl;
import com.fjsf.web.dao.impl.ProductDAOImpl;
import com.fjsf.web.service.inter.ShopCommentServiceInterface;
import com.fjsf.web.viewobject.Page;

public class ShopCommentServiceImpl implements ShopCommentServiceInterface{

	private CommentDAO commentDAO = new CommentDAOImpl();
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
	
	Page getCommentShopViewPage(HttpServletRequest request){
		Integer shopId = getShopId(request);
		Page page = new Page();
		page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		page.setPageSize(8);
		Integer totalNumber = (int) commentDAO.countCommentMessageByShopId(shopId);
		page.setTotalNumber(totalNumber);
		if(totalNumber == 0){
			page.setTotalPageNo(0);
		}else{
			page.setTotalPageNo((page.getTotalNumber()-1)/page.getPageSize()+1);
		}
		return page;
	}
	
	@Override
	public void showShopCommentMessage(HttpServletRequest request, HttpServletResponse response) {
		Integer shopId = getShopId(request);
		Page page = getCommentShopViewPage(request);
		System.out.println(page);
		List<CommentBean> listComment = commentDAO.getCommentMessageByShopId(shopId, 
				page.getPageNo(), page.getPageSize());
		List<ProductBean> listProduct = new ArrayList<>();
		for(CommentBean commentBean:listComment){
			ProductBean productBean = productDAO.getProductDetailMessage(commentBean.getProductId());
			listProduct.add(productBean);
		}
		Map<String, Object> map = new HashMap<>();
		
		map.put("Page", page);
		map.put("Comment",listComment);
		map.put("Product", listProduct);
		
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
