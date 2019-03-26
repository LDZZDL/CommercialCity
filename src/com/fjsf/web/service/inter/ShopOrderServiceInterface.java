package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ShopOrderServiceInterface {
	
	/**
	 * 显示商店的订单信息
	 * @param request
	 * @param response
	 */
	void showShopOrderMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 商家确认订单
	 * @param request
	 * @param response
	 */
	void shopConfirmOrder(HttpServletRequest request, HttpServletResponse response);
}
