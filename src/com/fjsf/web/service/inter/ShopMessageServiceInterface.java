package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ShopMessageServiceInterface {
	
	
	void getListsForCustomerMessage(HttpServletRequest request, HttpServletResponse response);
	//==========================黄宁============================================//
	/**
	 * 显示登录商家的相关数据
	 * @param request
	 * @param response
	 */
	public void showShopAssociatedMessage(HttpServletRequest request,HttpServletResponse response);
	/**
	 * 检验登录商家的修改信息
	 * @param request
	 * @param response
	 */
	public void checkShopAssociateMessage(HttpServletRequest request,HttpServletResponse response);

	/**
	 * 修改登录商家的相关数据
	 * @param request
	 * @param response
	 */
	public void changeShopAssociatedMessage(HttpServletRequest request,HttpServletResponse response);

	/**
	 * 向商家初始邮箱发送验证码
	 * @param request
	 * @param response
	 * @return
	 */
	public String sendCode(HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 向商家修改后新邮箱发送密码
	 */
	public String sendNewCode(HttpServletRequest request,HttpServletResponse response);
	//==========================黄宁============================================//
}
