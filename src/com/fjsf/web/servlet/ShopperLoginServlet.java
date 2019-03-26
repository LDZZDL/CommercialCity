package com.fjsf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.ShopperServiceImpl;
import com.fjsf.web.service.inter.ShopperServiceInterface;

/**
 * Servlet implementation class ShopperLoginServlet
 */
public class ShopperLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ShopperServiceInterface shopperService = new ShopperServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag = shopperService.loginShopper(request);
		if(flag == true){
			request.getSession().setAttribute("LoginShopAccount", request.getParameter("account"));
			String message = "{\"status\":\"true\",\"message\":\"登录信息正确\"}";
			response.getWriter().println(message);
		}else{
			String message = "{\"status\":\"false\",\"message\":\"登录信息错误\"}";
			response.getWriter().println(message);
		}
	}

}
