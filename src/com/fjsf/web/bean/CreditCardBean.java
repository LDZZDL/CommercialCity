package com.fjsf.web.bean;

import java.text.DecimalFormat;

public class CreditCardBean {
	
	//信用卡编号
	private int creditCardId;
	//信用卡账号
	private String creditAccount;
	//信用卡密码
	private String creditPassword;
	//账号金额
	private Double money;
	
	public int getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}
	public String getCreditAccount() {
		return creditAccount;
	}
	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}
	public String getCreditPassword() {
		return creditPassword;
	}
	public void setCreditPassword(String creditPassword) {
		this.creditPassword = creditPassword;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public CreditCardBean(int creditCardId, String creditAccount, String creditPassword, Double money) {
		super();
		this.creditCardId = creditCardId;
		this.creditAccount = creditAccount;
		this.creditPassword = creditPassword;
		this.money = money;
	}
	public CreditCardBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
