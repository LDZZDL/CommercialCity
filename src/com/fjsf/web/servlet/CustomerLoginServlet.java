package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.CustomerServiceImpl;
import com.fjsf.web.service.inter.CustomerServiceInterface;

/**
 * Servlet implementation class CustomerLoginServlet
 */
//@WebServlet("/CustomerLogin")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerServiceInterface customerService = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null){
			if(action.equals("cancel")) {
				customerService.cancelLogin(request, response);
				return;
			}
		}
		boolean flag = customerService.LoginCustomer(request);
		if(flag == true){
			String message = "{\"status\":\"true\",\"message\":\"登录信息正确\"}";
			customerService.loginSaveMessage(request);
			response.getWriter().println(message);
		}else{
			String message = "{\"status\":\"false\",\"message\":\"登录信息错误\"}";
			response.getWriter().println(message);
		}
		
		
	}

}
