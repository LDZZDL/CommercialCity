package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.handlers.handler_base;

public interface ShopProductManageServiceInterface {
	
	/**
	 * 获取商店的商品信息
	 * @param request
	 * @param response
	 */
	void getListsForProduct(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 按照商品编号删除商品信息
	 * @param request
	 * @param response
	 */
	void deleteProductByProductId(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 按照商品编号获取商品详细信息
	 * @param request
	 * @param response
	 */
	void getDetailProductMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 按照商品编号修改商品信息(非头像)
	 * @param request
	 * @param response
	 */
	void changeProductMessageForm(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 按照商品编号修改商品图片
	 * @param request
	 * @param response
	 */
	void changeProductPicture(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 增加商品
	 * @param request
	 * @param response
	 */
	void addProduct(HttpServletRequest request, HttpServletResponse response);
}	
