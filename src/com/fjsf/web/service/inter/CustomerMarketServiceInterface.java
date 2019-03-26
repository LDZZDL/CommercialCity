package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerMarketServiceInterface {
	
	/**
	 * 获取首页的相关信息
	 * @param request
	 * @param response
	 */
	void getMarketMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取商品的详细信息
	 * @param request
	 * @param response
	 */
	void getDetailProductMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取搜索的商品信息
	 * @param request
	 * @param response
	 */
	void getSearchProductMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 加入购物车
	 * @param request
	 * @param response
	 */
	void addShoppingCart(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 检验信用卡密码
	 * @param request
	 * @param response
	 */
	boolean checkCustomerCreditCardPassword(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 支付前的校验
	 * @param request
	 * @param response
	 */
	boolean checkCustomerPay(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 生成订单
	 * @param request
	 * @param response
	 */
	void createOrder(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 确认订单
	 * @param request
	 * @param response
	 */
	void confirmOrder(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 用户支付
	 * @param request
	 * @param response
	 */
	void customerPay(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取确认订单页面的信息
	 * @param request
	 * @param response
	 */
	void getConfirmOrderMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取产品评论
	 * @param request
	 * @param response
	 */
	void getProductComment(HttpServletRequest request, HttpServletResponse response);
}
