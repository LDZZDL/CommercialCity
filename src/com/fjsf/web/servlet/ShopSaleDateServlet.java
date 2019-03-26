package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.ShopSaleDateServiceImpl;
import com.fjsf.web.service.inter.ShopSaleDateServiceInterface;

/**
 * Servlet implementation class ShopSaleDateServlet
 */
public class ShopSaleDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShopSaleDateServiceInterface shopSaleDateService = new ShopSaleDateServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/*
	 	//今日限售金额
		url:/CommercialCity/shopSaleDate?action=TM
		data:{
			
		}
		
		//今日限售量
		url:/CommercialCity/shopSaleDate?action=TS
		data:{
			
		}
		
		//最热产品
		url:/CommercialCity/shopSaleDate?action=THP
		data:{
			
		}
		
		//产品销量统计
		url:/CommercialCity/shopSaleDate?action=PS
		data:{
			orderType:排序类型(SVD,SVA)
			pageNo:
			day: 最近三天 最近一周 最近一个月 日期
		}
		
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("TM")){
			shopSaleDateService.getTodaySaleMoney(request, response);
		}
		if(action.equals("TS")){
			shopSaleDateService.getProductSale(request, response);
		}
		if(action.equals("THP")){
			shopSaleDateService.getTodayHotProduct(request, response);
		}
		if(action.equals("PS")){
			shopSaleDateService.getProductSale(request, response);
		}
	}

}
