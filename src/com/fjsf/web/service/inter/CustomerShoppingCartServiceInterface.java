package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerShoppingCartServiceInterface {
	
	/**
	 * 获取购物车信息
	 * @param request
	 * @param response
	 */
	void getShoppingCartProduct(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除购物车中商品
	 * @param request
	 * @param httpServletResponse
	 */
	void deleteShoppingCartProduct(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改购物车中的商品数量
	 * @param request
	 * @param response
	 */
	void changeShoppingCartProductQuantity(HttpServletRequest request, HttpServletResponse response);
}
