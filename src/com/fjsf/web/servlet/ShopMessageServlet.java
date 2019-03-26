package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.ShopMessageServiceImpl;
import com.fjsf.web.service.inter.ShopMessageServiceInterface;

/**
 * Servlet implementation class ShopMessageServlet
 */
public class ShopMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopMessageServiceInterface shopMessageService = new ShopMessageServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * url:/CommercialCity/shopMessage?action=ShowCustomerMessage
		 * 返回JSON格式的数据:
		 */
		String action = request.getParameter("action");
		System.out.println("一级地址"+action);
		if(action.equals("showShopMessage")){
			shopMessageService.showShopAssociatedMessage(request, response);
		}
		if(action.equals("checkShopMessage")){
			shopMessageService.checkShopAssociateMessage(request, response);
		}
		if(action.equals("ChangeshopMessage")){
			shopMessageService.changeShopAssociatedMessage(request, response);
		}
		if(action.equals("sendCodeMail")){
			shopMessageService.sendCode(request, response);
		}
		if(action.equals("sendCodeNewMail")){
			shopMessageService.sendNewCode(request, response);
		}
	}

}
