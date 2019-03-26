package com.fjsf.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.bean.ShoppingCartProductBean;
import com.fjsf.web.dao.ProductDAO;
import com.fjsf.web.dao.ShopDAO;
import com.fjsf.web.dao.ShoppingCartProductDAO;
import com.fjsf.web.dao.impl.ProductDAOImpl;
import com.fjsf.web.dao.impl.ShopDAOImpl;
import com.fjsf.web.dao.impl.ShoppingCartProductDAOImpl;
import com.fjsf.web.service.inter.CustomerShoppingCartServiceInterface;
import com.fjsf.web.viewobject.Page;
import com.fjsf.web.viewobject.ShoppingCartProductView;

public class CustomerShoppingCartServiceImpl implements CustomerShoppingCartServiceInterface{

	private ShoppingCartProductDAO shoppingCartProductDAO = new ShoppingCartProductDAOImpl();
	private ProductDAO productDAO = new ProductDAOImpl();
	private ShopDAO shopDAO = new ShopDAOImpl();
	
	private Integer getCustomerId(HttpServletRequest request){
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		//====================//
		/*
		if(customerId == null){
			customerId = 1;
		}
		//===================//
		 */
		return customerId;
	}
	
	@Override
	public void getShoppingCartProduct(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = getCustomerId(request);
		List<ShoppingCartProductView> listShoppingCartProductView = new ArrayList<>();
		
		Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
		Page page = new Page();
		page.setPageNo(pageNo);
		List<ProductBean> listProductBeanOnlyShopId = productDAO.getShoppingCartProductAssociateShopId(customerId);
		List<Integer> listShopId = new ArrayList<>();
		for(ProductBean productBean:listProductBeanOnlyShopId){
			listShopId.add(productBean.getShopId());
		}
		page.setTotalNumber(listShopId.size());
		if(page.getTotalNumber() == 0){
			page.setTotalPageNo(0);
		}else{
			page.setTotalPageNo((page.getTotalNumber()-1)/page.getPageSize()+1);
		}
		for(int i = (page.getPageNo() -1) * page.getPageSize(); 
				i < page.getPageNo() * page.getPageSize() + page.getPageSize(); i++){
			if(i < page.getTotalNumber()){
				ShoppingCartProductView shoppingCartProductView = new ShoppingCartProductView();
				shoppingCartProductView.setShopBean(shopDAO.getShopByShopId(listShopId.get(i)));
				shoppingCartProductView.setListProductBean(
						productDAO.getShoppingCartProductMessageByShopId(listShopId.get(i)));
				List<ShoppingCartProductBean> listShoppingCartProductBeans = 
						shoppingCartProductDAO.getShoppingCartProductByShopId(listShopId.get(i));
				List<Integer> listQuantity = new ArrayList<>();
				for(ShoppingCartProductBean shoppingCartProductBean:listShoppingCartProductBeans){
					listQuantity.add(shoppingCartProductBean.getQuantity());
				}
				shoppingCartProductView.setListQuantity(listQuantity);
				listShoppingCartProductView.add(shoppingCartProductView);
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("product", listShoppingCartProductView);
		try {
			String message = objectMapper.writeValueAsString(map);
			response.getWriter().println(message);
		} catch (Exception e) {}
	}

	@Override
	public void deleteShoppingCartProduct(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = getCustomerId(request);
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		shoppingCartProductDAO.deleteShoppingCartProductByCustomerIdAndProductId(customerId, productId);
		
		Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
		Page page = new Page();
		page.setPageNo(pageNo);
		List<ProductBean> listProductBeanOnlyShopId = productDAO.getShoppingCartProductAssociateShopId(customerId);
		List<Integer> listShopId = new ArrayList<>();
		for(ProductBean productBean:listProductBeanOnlyShopId){
			listShopId.add(productBean.getShopId());
		}
		page.setTotalNumber(listShopId.size());
		if(page.getTotalNumber() == 0){
			page.setTotalPageNo(0);
		}else{
			page.setTotalPageNo((page.getTotalNumber()-1)/page.getPageSize()+1);
			if(page.getTotalPageNo() < page.getPageNo()){
				page.setPageNo(page.getTotalPageNo());
			}
		}
		System.out.println(page);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String message = mapper.writeValueAsString(page);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(page));
			response.getWriter().println(message);
		} catch (Exception e) {}
	}

	@Override
	public void changeShoppingCartProductQuantity(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = getCustomerId(request);
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		shoppingCartProductDAO.changeShoppingCartProductQuantity(customerId, productId, quantity);
	}

}
