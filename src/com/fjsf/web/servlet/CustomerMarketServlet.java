package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.CustomerMarketServiceImpl;
import com.fjsf.web.service.inter.CustomerMarketServiceInterface;

/**
 * Servlet implementation class CustomerMarketServlet
 */
public class CustomerMarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private CustomerMarketServiceInterface customerMarketService = new CustomerMarketServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("All")){
			customerMarketService.getMarketMessage(request, response);
		}
		if(action.equals("Detail")){
			customerMarketService.getDetailProductMessage(request, response);
		}
		if(action.equals("Search")){
			customerMarketService.getSearchProductMessage(request, response);
		}
		if(action.equals("ShoppingCart")){
			customerMarketService.addShoppingCart(request, response);
		}
		if(action.equals("Pay")){
			customerMarketService.customerPay(request, response);
		}
		if(action.equals("CreateOrder")){
			customerMarketService.createOrder(request, response);
		}
		if(action.equals("ConfirmOrder")){
			customerMarketService.confirmOrder(request, response);
		}
		if(action.equals("ConfirmOrderGet")){
			customerMarketService.getConfirmOrderMessage(request, response);
		}
		if(action.equals("GR")){
			customerMarketService.getProductComment(request, response);
		}
	}

}
