package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerOrderServiceInterface {
	
	/**
	 * 根据用户编号和条件获取订单信息
	 * @param request
	 * @param response
	 */
	void getCustomerOrderByCustomerIdWithCondition(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除未付款订单
	 * @param request
	 * @param response
	 */
	void deleteOrder(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 确认订单
	 * @param request
	 * @param response
	 */
	void confirmOrder(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 用户评价商品
	 * @param request
	 * @param response
	 */
	void customerRateProduct(HttpServletRequest request, HttpServletResponse response);
}
