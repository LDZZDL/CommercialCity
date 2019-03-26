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
import com.fjsf.web.bean.BrowserHistoryBean;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.dao.BrowserHistoryDAO;
import com.fjsf.web.dao.ProductDAO;
import com.fjsf.web.dao.impl.BrowserHistoryDAOImpl;
import com.fjsf.web.dao.impl.ProductDAOImpl;
import com.fjsf.web.service.inter.CustomerBrowserHistoryServiceInterface;
import com.fjsf.web.viewobject.Page;

public class CustomerBrowserHistoryServiceImpl implements CustomerBrowserHistoryServiceInterface{

	private BrowserHistoryDAO browserHistoryDAO = new BrowserHistoryDAOImpl(); 
	private ProductDAO productDAO = new ProductDAOImpl();
	
	private Integer getCustomerId(HttpServletRequest request){
		Integer customerId = (Integer) request.getSession().getAttribute("CustomerLoginCustomerId");
		return customerId;
	}
	
	private Page getPageMessage(HttpServletRequest request){
		Integer customerId = getCustomerId(request);
		Page page = new Page();
		page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		page.setPageSize(8);
		Integer totalNumber = (int) browserHistoryDAO.countBrowserHistory(customerId);
		page.setTotalNumber(totalNumber);
		Integer totalPageNo = 0;
		if(totalNumber == 0){
			totalPageNo = 0;
		}else{
			totalPageNo = (page.getTotalNumber()-1)/page.getPageSize()+1;
		}
		page.setTotalPageNo(totalPageNo);
		return page;
	}
	
	@Override
	public void showBrowserHistory(HttpServletRequest request, HttpServletResponse response) {
		Integer customerId = getCustomerId(request);
		Page page = getPageMessage(request);
		System.out.println(page);
		List<BrowserHistoryBean> listBrowserHistory = browserHistoryDAO.getBrowserHistoryByCustomerId(customerId, 
				page.getPageNo(), page.getPageSize());
		List<ProductBean> listproduct = new ArrayList<>();
		for(BrowserHistoryBean browserHistoryBean:listBrowserHistory){
			ProductBean productBean = productDAO.getProductDetailMessage(
					browserHistoryBean.getProductId());
			listproduct.add(productBean);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("BrowserHistory", listBrowserHistory);
		map.put("Product", listproduct);
		map.put("page", page);
		ObjectMapper mapper = new ObjectMapper();
		String message = new String();
		try {
			message = mapper.writeValueAsString(map);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
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
