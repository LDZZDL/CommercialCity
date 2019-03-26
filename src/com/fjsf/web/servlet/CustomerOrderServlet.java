package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.CustomerOrderServiceImpl;
import com.fjsf.web.service.inter.CustomerOrderServiceInterface;

/**
 * Servlet implementation class CustomerOrderServlet
 */
public class CustomerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerOrderServiceInterface customerOrderService = new CustomerOrderServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("WaitPay")){
			customerOrderService.getCustomerOrderByCustomerIdWithCondition(request, response);
		}
		if(action.equals("WaitSend")){
			customerOrderService.getCustomerOrderByCustomerIdWithCondition(request, response);
		}
		if(action.equals("WaitConfirm")){
			customerOrderService.getCustomerOrderByCustomerIdWithCondition(request, response);
		}
		if(action.equals("WaitRate")){
			customerOrderService.getCustomerOrderByCustomerIdWithCondition(request, response);
		}
		if(action.equals("End")){
			customerOrderService.getCustomerOrderByCustomerIdWithCondition(request, response);
		}
		if(action.equals("DO")){
			customerOrderService.deleteOrder(request, response);
		}
		if(action.equals("CO")){
			customerOrderService.confirmOrder(request, response);
		}
		if(action.equals("Rate")){
			customerOrderService.customerRateProduct(request, response);
		}
	}

}
