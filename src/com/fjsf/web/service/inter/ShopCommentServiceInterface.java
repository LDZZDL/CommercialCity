package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ShopCommentServiceInterface {
	
	/**
	 * 显示商家产品的评论信息
	 * @param request
	 * @param response
	 */
	void showShopCommentMessage(HttpServletRequest request, HttpServletResponse response);
}
