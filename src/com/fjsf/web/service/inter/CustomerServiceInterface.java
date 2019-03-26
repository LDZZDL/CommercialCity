package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerServiceInterface {

	/**
	 * 取消登录
	 * @param request
	 * @param response
	 */
	void cancelLogin(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 用户登录信息保存
	 * @param request
	 */
	void loginSaveMessage(HttpServletRequest request);
	/**
	 * 验证买家登录信息的正确性
	 * @param request包含登录信息
	 * @return  false:登录信息错误 true:登录信息正确
	 */
	public boolean LoginCustomer(HttpServletRequest request);
	
	/**
	 * 验证买家注册信息正确性
	 * @param str 需要验证的信息
	 * @param type 需要验证信息的类型
	 * @return true:信息正确 false:信息错误
	 */
	public String valiadCustomer(HttpServletRequest request);
	
	/**
	 * 向指定邮箱发送验证码
	 * @param customerMail 邮箱地址
	 * @return 验证码
	 */
	public String sendIdCode(String customerMail);
	
	/**
	 * 注册账号
	 * @param request 包含账号信息的请求
	 */
	public void customerRegister(HttpServletRequest request);
	
	/**
	 * 获取账号customerAccount的数量
	 * @param customerAccount
	 * @return
	 */
	public boolean countCustomerAccount(String customerAccount);
	/**
	 * 通过买家账号修改买家密码
	 * @param oldPassword
	 * @param newPassword
	 */
	public void changePasswordByCustomerAccount(String customerAccount, String newPassword);
	/**
	 * 通过用户账号找到绑定邮箱
	 * @param account
	 * @return
	 */
	public String getMailByAccount(String account);
}
