package com.fjsf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fjsf.web.service.impl.ShopperServiceImpl;

/**
 * Servlet implementation class ShoperLoginServlet
 */
public class ShopperRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopperServiceImpl shopperService = new ShopperServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("check")){
			String message = shopperService.valiadShopper(request);
			response.getWriter().println(message);
			return ;
		}
		if(action.equals("idCode")){
			String type = request.getParameter("type");
			String mail = request.getParameter(type);
			String code = shopperService.sendIdCode(mail);
			System.out.println("验证码为:"+code);
			response.getWriter().print(code);
			return ;
		}
		if(action.equals("submit")){
			shopperService.shopperRegister(request);
			//注册成功跳转的页面
			response.sendRedirect("/CommercialCity/Shop/ShopperLogin.jsp");
			return ;
		}
		if(action.equals("ShopRegister")){
			String shopRegister = request.getParameter("actionRegister");
			if (shopRegister.equals("check")) {
				String shopName = request.getParameter("shopName");
				boolean flag = shopperService.valiadShopName(shopName);
				if (flag == false) {
					String message = "{\"status\":\"false\",\"message\":\"店铺名称重复\"}";
					response.getWriter().println(message);
				} else {
					String message = "{\"status\":\"true\",\"message\":\"店铺名称不重复\"}";
					response.getWriter().println(message);
				}
			}
			if (shopRegister.equals("submit")) {
				shopperService.shopRegister(request);
				//response.sendRedirect("/CommercialCity/Shop/ShopManage.jsp");
				response.sendRedirect("/CommercialCity/Shop/message/ShopperMessage.jsp");
			}
		}
	}

}
