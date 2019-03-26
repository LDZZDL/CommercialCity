package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerMessageServiceInterface {
	
	/**
	 * 显示登录用户的相关数据
	 * @param request 
	 * @param response 
	 */
	public void showCustomerAssociatedMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 检验登录用户的修改信息
	 * @param request
	 * @param httpServletResponse
	 */
	public void checkCustomerAssociatedMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 修改登录用户的相关数据
	 * @param request
	 * @param response
	 */
	public void changeCustomerAssociatedMessage(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 向需要修改密码的用户发送验证码
	 * @param request
	 * @param response
	 * @return 
	 */
	public String sendCode(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 发送验证码到新邮箱
	 * @param request
	 * @param response
	 * @return
	 */
	public String sendCodeToNewMail(HttpServletRequest request, HttpServletResponse response); 
}
