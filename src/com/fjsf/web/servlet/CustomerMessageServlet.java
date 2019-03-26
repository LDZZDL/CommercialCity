package com.fjsf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.CustomerMessageServiceImpl;
import com.fjsf.web.service.impl.CustomerServiceImpl;
import com.fjsf.web.service.inter.CustomerMessageServiceInterface;
import com.fjsf.web.service.inter.CustomerServiceInterface;
/*url = customerMessage*/
public class CustomerMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerMessageServiceInterface customerMessageService = new CustomerMessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("ShowCustomerMessage")){
			customerMessageService.showCustomerAssociatedMessage(request, response);
		}
		if(action.equals("CheckCustomerMessage")){
			customerMessageService.checkCustomerAssociatedMessage(request, response);
		}
		if(action.equals("ChangeCustomerMessage")){
			customerMessageService.changeCustomerAssociatedMessage(request, response);
		}
		if(action.equals("SendCode")){
			System.out.println("sendCode");
			customerMessageService.sendCode(request, response);
		}
		if(action.equals("SendCodeNewMail")){
			customerMessageService.sendCodeToNewMail(request, response);
		}
	}

}
