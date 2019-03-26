package com.fjsf.web.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author lin
 */
public interface ShopperServiceInterface {
	/**
	 * 验证商家登录信息的正确性
	 * @param request 包含登录信息
	 * @return false:登录信息错误 true:登录信息正确
	 */
	public boolean loginShopper(HttpServletRequest request);
	/**
	 * 验证商家注册信息正确性
	 * @param str 需要验证的信息
	 * @param type 需要验证信息的类型
	 * @return true:信息正确 false:信息错误
	 */
	public String valiadShopper(HttpServletRequest request);
	/**
	 * 向指定邮箱发送验证码
	 * @param mail 邮箱地址
	 * @return 验证码
	 */
	public String sendIdCode(String mail);
	/**
	 * 注册账号
	 * @param request 包含账号信息的请求
	 */
	public void shopperRegister(HttpServletRequest request);
	/**
	 * 获取账号account的数量
	 * @param account
	 * @return
	 */
	public boolean countShopperAccount(String account);
	/**
	 * 通过商家账号找到绑定邮箱
	 * @param account
	 * @return
	 */
	public String getMailByAccount(String account);
	/**
	 * 通过商家账号修改商家密码
	 * @param oldPassword
	 * @param newPassword
	 */
	public void changePasswordByAccount(String account, String newPassword);
	/**
	 * 商家登录前检查
	 * @param request 包含检查信息
	 */
	public void checkShopperRegister(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 验证店铺名字是否重复
	 * @param shopName 店铺名字
	 * @return 重复返回false 不重复返回true
	 */
	public boolean valiadShopName(String shopName);
	/**
	 * 注册店家
	 * @param request 包含店家信息
	 */
	public void shopRegister(HttpServletRequest request);
	/**
	 * 登录前保存信息
	 * @param request
	 * @param response
	 */
	public void saveLoginMessage(HttpServletRequest request, HttpServletResponse response);
}
