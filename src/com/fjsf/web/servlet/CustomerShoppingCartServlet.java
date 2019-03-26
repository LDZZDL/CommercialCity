package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.CustomerShoppingCartServiceImpl;
import com.fjsf.web.service.inter.CustomerShoppingCartServiceInterface;

/**
 * Servlet implementation class CustomerShoppingCartServlet
 */
public class CustomerShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerShoppingCartServiceInterface customerShoppingCartService = new CustomerShoppingCartServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("SM")){
			customerShoppingCartService.getShoppingCartProduct(request, response);
		}
		if(action.equals("DP")){
			customerShoppingCartService.deleteShoppingCartProduct(request, response);
		}
		if(action.equals("CQ")){
			customerShoppingCartService.changeShoppingCartProductQuantity(request, response);
		}
		
	}

}
