package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.ShopOrderServiceImpl;
import com.fjsf.web.service.inter.ShopOrderServiceInterface;

/**
 * Servlet implementation class ShopOrderServlet
 */
public class ShopOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShopOrderServiceInterface shopOrderService = new ShopOrderServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("SSO")){
			shopOrderService.showShopOrderMessage(request, response);
		}
		if(action.equals("SCO")){
			shopOrderService.shopConfirmOrder(request, response);
		}
	}

}
