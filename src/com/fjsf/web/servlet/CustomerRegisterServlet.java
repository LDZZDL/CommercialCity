package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.CustomerServiceImpl;

public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	private CustomerServiceImpl customerService = new CustomerServiceImpl();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("check")){
			String type = request.getParameter("type");
			String value = request.getParameter(type);
			String message = customerService.valiadCustomer(request);
			response.getWriter().println(message);
			return ;
		}
		if(action.equals("idCode")){
			String mail = request.getParameter("mail");
			String code = customerService.sendIdCode(mail);
			System.out.println("验证码="+code);
			response.getWriter().print(code);
			return;
		}
		if(action.equals("submit")){
			customerService.customerRegister(request);
			response.sendRedirect("/CommercialCity/Customer/CustomerLogin.jsp");
		}
	}

}
