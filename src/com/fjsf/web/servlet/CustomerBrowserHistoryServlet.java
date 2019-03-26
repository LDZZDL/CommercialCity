package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.CustomerBrowserHistoryServiceImpl;
import com.fjsf.web.service.inter.CustomerBrowserHistoryServiceInterface;

/**
 * Servlet implementation class CustomerBrowserHistoryServlet
 */
public class CustomerBrowserHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerBrowserHistoryServiceInterface customerBrowserHistoryService = new CustomerBrowserHistoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * url:/CommercialCity/customerBrowserHistory?action=SBH
	 * data:{
	 * 		pageNo:
	 * }
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("лл╬ф" + action);
		if(action.equals("SBH")){
			customerBrowserHistoryService.showBrowserHistory(request, response);
		}
	}

}
