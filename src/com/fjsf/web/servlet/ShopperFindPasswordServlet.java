package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.ShopperServiceImpl;
import com.fjsf.web.service.inter.ShopperServiceInterface;

/**
 * Servlet implementation class ShopperFindPasswordServlet
 */
public class ShopperFindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ShopperServiceInterface shopperService = new ShopperServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("check1")){
			String type = request.getParameter("type");
			String account = request.getParameter(type);
			boolean flag = shopperService.countShopperAccount(account);
			if(flag == true){
				request.getSession().setAttribute("changeAccount", account);
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
			String account = (String) request.getSession().getAttribute("changeAccount");
			String mail = shopperService.getMailByAccount(account);
			String code = shopperService.sendIdCode(mail);
			System.out.print("code = "+code);
			response.getWriter().println(code);
			return;
		}
		if(action.equals("submit")){
			String account = (String) request.getSession().getAttribute("changeAccount");
			String newPassword = request.getParameter("password");
			shopperService.changePasswordByAccount(account, newPassword);
		}
		
	}

}
