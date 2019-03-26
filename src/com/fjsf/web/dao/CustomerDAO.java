package com.fjsf.web.dao;

import com.fjsf.web.bean.CustomerBean;

/**
 * 定义数据库中买家信息表的操作接口
 * @author Administrator
 *
 */
public interface CustomerDAO {
   /**
    * 注册买家
    * 包含买家信息
    */
	void customerRegist(CustomerBean customer);
	
	/**
	 * 判断customer数据库中是否有账号等于customerAccount的买家
	 * @param customerAccount 
	 * @return customer(卖家)数据库中与customerAccount账号相同的买家数量
	 */
	long countCustomerAccount(String customerAccount);
	
	/**
	 * 判断customer数据库中是否有邮箱等于customerMail的买家
	 * @param customerMail
	 * @return customer数据库中与customerMail邮箱账号相同的买家数量
	 */
	long countCustomerMail(String customerMail);
	/**
	 * 判断customer数据库中是否有邮箱等于customerMail但是用户编号不等于customerId
	 * @param customerMail 判断条件的邮箱
	 * @param customerId 判断条件的用户编号
	 * @return 相同数量
	 */
	long countCustomerMail(String customerMail, Integer customerId);
	
	/**
	 * 判断customer数据库中是否有名称等于customerName的买家
	 * @param customerName
	 * @return customer数据库中与customerName名称相同的买家数量
	 */
	long countCustomerName(String CustomerName);
	/**
	 * 判断customer数据库中是否有名称等于customerName但是商家编号不等于customerId
	 * @param customerName 用户名称
	 * @param customerId 用户编号
	 * @return 相同数量
	 */
	long countCustomerName(String customerName, Integer customerId);
	
	/**
	 * 判断数据库中是否有等于creditCardId
	 */
	long countCreditCardId(Integer creditCardId);
	/**
	 * 判断数据中是否有信用卡编号等于creditCardId但是用户编号不等于customerId
	 * @param creditCardId 条件信用卡编号
	 * @param CustomerId  条件用户编号
	 * @return 相同数量
	 */
	long countCreditCard(Integer creditCardId, Integer customerId);
	
	/**
	 * 判断登录商家信息正确性
	 * @return false:登录信息错误 true:登录信息正确
	 */
	boolean loginCustomer(String customerAccount, String customerPassword);
	
	/**
	 * 通过账号修改密码
	 * @param customerAccount 账号
	 * @param newPassword 密码
	 */
	void changeCustomerPasswordByCustomerAccount(String customerAccount, String newPassword);
	/**
	 * 通过用户编号修改用户密码
	 * @param newCustomerPassword 用户密码
	 * @param customerId 用户编号
	 */
	void changeCustomerPasswordByCustomerId(String newCustomerPassword, Integer customerId);
	/**
	 * 通过用户的账号获取用户的编号
	 * @param account 用户账号
	 * @return 用户编号
	 */
	Integer getCustomerIdByAccount(String account);
	/**
	 * 通过用户账号获取绑定邮箱
	 * @param customerAccount 用户账号
	 * @return 用户绑定邮箱
	 */
	String getMailByCustomerAccount(String customerAccount);
	/**
	 * 通过用户编号获取绑定邮箱
	 * @param customerId 用户编号
	 * @return 绑定邮箱
	 */
	String getMailByCustomerId(Integer customerId);
	/**
	 * 通过用户账号获取用户信息
	 * @param account 账号
	 * @return 用户信息
	 */
	CustomerBean getCustomerMessageByAccount(String account);
	/**
	 * 通过用户编号获取用户信息
	 * @param customerId 用户编号
	 * @return 用户信息
	 */
	CustomerBean getCustomerMessageByCustomerId(Integer customerId);
	/**
	 * 通过用户编号修改用户名称
	 * @param customerId 用户编号  
	 * @param newCustomerName 用户名称
	 */
	void changeCustomerNameByCustomerId(Integer customerId, String newCustomerName);
	/**
	 * 通过用户编号修改用户性别
	 * @param customerId 用户编号
	 * @param newCustomerSex 用户性别
	 */
	void changeCustomerSexByCustomerId(String newCustomerSex, Integer customerId);
	/**
	 * 通过用户编号修改用户邮箱
	 * @param newCustomerMail 用户邮箱
	 * @param customerId 用户编号
	 */
	void changeCustomerMailByCustomerId(String newCustomerMail, Integer customerId);
	/**
	 * 通过用户编号修改信用卡
	 * @param newCreditCardId 信用卡编号
	 * @param customerId 用户编号
	 */
	void changeCustomerCreditCardByCustomerId(Integer newCreditCardId, Integer customerId);
	/**
	 * 通过用户编号修改头像
	 * @param newDisplayPicture 新的头像
	 * @param customerId 用户编号
	 */
	void changeDisplayPictureByCustomerId(String newDisplayPicture, Integer customerId);
	/**
	 * 通过用户编号获取信用卡编号
	 * @param customerId 用户编号
	 * @return
	 */
	Integer getCreditCardIdByCustomerId(Integer customerId);
}
