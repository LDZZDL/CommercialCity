package com.fjsf.web.viewobject;

public class OVC {
	
	// 商家编号,自动生成
	private int shopperId;
	// 账号,仅仅支持字母和数字(7-14)
	private String account;
	// 密码,仅仅支持字母和数字(7-14)
	private String password;
	// 邮箱,支持qq邮箱和163邮箱
	private String mail;
	// 身份证,18位
	private String idCard;
	// 信用卡编号,10位
	private Integer creditCardId;
	// 网名,10个汉字和20字符以内
	private String onlineName;
	// 存储头像的路径
	private String shopperDisplayPicture;

	public int getShopperId() {
		return shopperId;
	}

	public void setShopperId(int shopperId) {
		this.shopperId = shopperId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(Integer creditCardId) {
		this.creditCardId = creditCardId;
	}

	public String getOnlineName() {
		return onlineName;
	}

	public void setOnlineName(String onlineName) {
		this.onlineName = onlineName;
	}

	public String getShopperDisplayPicture() {
		return shopperDisplayPicture;
	}

	public void setShopperDisplayPicture(String shopperDisplayPicture) {
		this.shopperDisplayPicture = shopperDisplayPicture;
	}

	@Override
	public String toString() {
		return "OVC [shopperId=" + shopperId + ", account=" + account + ", password=" + password + ", mail=" + mail
				+ ", idCard=" + idCard + ", creditCardId=" + creditCardId + ", onlineName=" + onlineName
				+ ", shopperDisplayPicture=" + shopperDisplayPicture + "]";
	}

	public OVC(int shopperId, String account, String password, String mail, String idCard, Integer creditCardId,
			String onlineName, String shopperDisplayPicture) {
		super();
		this.shopperId = shopperId;
		this.account = account;
		this.password = password;
		this.mail = mail;
		this.idCard = idCard;
		this.creditCardId = creditCardId;
		this.onlineName = onlineName;
		this.shopperDisplayPicture = shopperDisplayPicture;
	}

	public OVC() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
