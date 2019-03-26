package com.fjsf.web.dao;

import java.util.List;

import com.fjsf.web.bean.CreditCardBean;

public interface CreditCardDAO {
	
	/**
	 * 通过信用卡账号和密码，返回信用卡编号
	 * @param account 信用卡账号
	 * @param password 信用卡密码
	 * @return	信用卡编号
	 */
	Integer getCreditIdByAccountAndPassword(String account, String password);
	/**
	 * 通过信用卡账号获取信用卡编号
	 * @param account 信用卡账号 
	 * @return 信用卡编号
	 */
	Integer getCreditIdByAccount(String account);
	/**
	 * 通过信用卡编号获取信用卡信息
	 * @param creditAccount
	 * @return
	 */
	CreditCardBean getCreditCardByCreditCardId(Integer creditCardId);
	/**
	 * 通过信用卡编号获取信用卡账号余额
	 * @param creditCardId 信用卡账号
	 * @return
	 */
	Double getMoneyByCreditCardId(Integer creditCardId);
	/**
	 * 用户付款
	 * @param money 支付金额
	 */
	void customerPayMoney(Double money, Integer creditCardId);
	/**
	 * 用户收款
	 * @param money 钱数
	 * @param creditCardId 信用卡编号
	 */
	void customerReceiveMoney(Double money, Integer creditCardId);
	/**
	 * 商家收钱
	 * @param money 收款金额
	 */
	void shopReceiveMoney(Double money, Integer creditCardId);
	/**
	 * 商家退款
	 * @param money 钱数
	 * @param creditCardId 信用卡编号
	 */
	void shopPayMoney(Double money, Integer creditCardId);
	/**
	 * 检验用户账户余额
	 * @param money 账目
	 * @param customerId 用户编号
	 * @return
	 */
	boolean checkCreditMoney(Double money, Integer customerId);
	/**
	 * 获取所有的信用卡信息
	 * @return
	 */
	List<CreditCardBean> getAll();
	
}
