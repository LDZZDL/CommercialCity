package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ShopSaleDateServiceInterface {
	
	/**
	 * 获取今日销售金额
	 * @param request
	 * @param response
	 */
	void getTodaySaleMoney(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取今日销售数量
	 * @param request
	 * @param response
	 */
	void getTodaySale(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取今日热销产品
	 * @param request
	 * @param response
	 */
	void getTodayHotProduct(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取产品销量信息
	 * @param request
	 * @param response
	 */
	void getProductSale(HttpServletRequest request, HttpServletResponse response);
}
