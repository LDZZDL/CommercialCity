package com.fjsf.web.bean;

public class CustomerBean {

	//买家编号
	private int customerId;
	
	//信用卡编号
	private int creditCardId;
	
	//客户名
	private String customerName;
	
	//性别
	private String customerSex;
	
	//账号
	private String customerAccount;
	
	//密码
	private String customerPassword;
	
	//邮箱
	private String customerMail;
	
	//头像
	private String displayPicture;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	public String getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerMail() {
		return customerMail;
	}

	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}

	public String getDisplayPicture() {
		return displayPicture;
	}

	public void setDisplayPicture(String displayPicture) {
		this.displayPicture = displayPicture;
	}

	public CustomerBean(int customerId, int creditCardId, String customerName, String customerSex,
			String customerAccount, String customerPassword, String customerMail, String displayPicture) {
		super();
		this.customerId = customerId;
		this.creditCardId = creditCardId;
		this.customerName = customerName;
		this.customerSex = customerSex;
		this.customerAccount = customerAccount;
		this.customerPassword = customerPassword;
		this.customerMail = customerMail;
		this.displayPicture = displayPicture;
	}

	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", creditCardId=" + creditCardId + ", customerName="
				+ customerName + ", customerSex=" + customerSex + ", customerAccount=" + customerAccount
				+ ", customerPassword=" + customerPassword + ", customerMail=" + customerMail + ", displayPicture="
				+ displayPicture + "]";
	}
	
}
