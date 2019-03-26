package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.CustomerServiceImpl;
import com.fjsf.web.service.inter.CustomerServiceInterface;


public class CustomerFindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CustomerServiceInterface customerService=new CustomerServiceImpl();
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("check1")){
			String type = request.getParameter("type");
			String customerAccount = request.getParameter(type);
			boolean flag =customerService.countCustomerAccount(customerAccount);
			if(flag==true){
				request.getSession().setAttribute("changeAccount", customerAccount);
				String message = "{\"status\":\"true\",\"message\":\"账号信息正确\"}";
				System.out.println(message);
				response.getWriter().println(message);
			}else{
				String message = "{\"status\":\"false\",\"message\":\"账号信息错误\"}";
				System.out.println(message);
				response.getWriter().println(message);
			}
			return;
	}
		if(action.equals("check2")){
			String changeAccount = (String) request.getSession().getAttribute("changeAccount");
			String customerMail = customerService.getMailByAccount(changeAccount);
			String code = customerService.sendIdCode(customerMail);
			System.out.print("验证码="+code);
			response.getWriter().println(code);
			return;
		}
		if(action.equals("submit")){
			String customerAccount = (String) request.getSession().getAttribute("changeAccount");
			String newPassword = request.getParameter("password");
			customerService.changePasswordByCustomerAccount(customerAccount, newPassword);
			response.sendRedirect("/CommercialCity/Customer/CustomerLogin.jsp");
		}
}
}	
