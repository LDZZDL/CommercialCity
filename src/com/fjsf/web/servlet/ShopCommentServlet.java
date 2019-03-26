package com.fjsf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjsf.web.service.impl.ShopCommentServiceImpl;
import com.fjsf.web.service.inter.ShopCommentServiceInterface;

/**
 * Servlet implementation class ShopCommentServlet
 */
public class ShopCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShopCommentServiceInterface shopCommentService = new ShopCommentServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * url:/CommercialCity/shopComment?action=SSCM
	 * data:{
	 * 		pageNo:
	 * }
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("SSCM")){
			shopCommentService.showShopCommentMessage(request, response);
		}
	}

}
