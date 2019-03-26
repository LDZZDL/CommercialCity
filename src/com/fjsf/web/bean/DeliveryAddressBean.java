package com.fjsf.web.bean;

public class DeliveryAddressBean {
	
	// 收件人姓名
	private String receiverName;
	// 收件人电话
	private String receiverTelephone;
	// 收件人一级地址
	private String receiverAddressFirst;
	//收件人二级地址
	private String receiverAddressSecond;
	//收件人三级地址
	private String receiverAddressThird;
	//收件人详细地址
	private String receiverAddressDetail;
	// 收货地址编号
	private Integer deliveryAddressId;
	// 用户编号
	private Integer customerId;

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverTelephone() {
		return receiverTelephone;
	}

	public void setReceiverTelephone(String receiverTelephone) {
		this.receiverTelephone = receiverTelephone;
	}

	public String getReceiverAddressFirst() {
		return receiverAddressFirst;
	}

	public void setReceiverAddressFirst(String receiverAddressFirst) {
		this.receiverAddressFirst = receiverAddressFirst;
	}

	public String getReceiverAddressSecond() {
		return receiverAddressSecond;
	}

	public void setReceiverAddressSecond(String receiverAddressSecond) {
		this.receiverAddressSecond = receiverAddressSecond;
	}

	public String getReceiverAddressThird() {
		return receiverAddressThird;
	}

	public void setReceiverAddressThird(String receiverAddressThird) {
		this.receiverAddressThird = receiverAddressThird;
	}

	public String getReceiverAddressDetail() {
		return receiverAddressDetail;
	}

	public void setReceiverAddressDetail(String receiverAddressDetail) {
		this.receiverAddressDetail = receiverAddressDetail;
	}

	public Integer getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(Integer deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public DeliveryAddressBean(String receiverName, String receiverTelephone, String receiverAddressFirst,
			String receiverAddressSecond, String receiverAddressThird, String receiverAddressDetail,
			Integer deliveryAddressId, Integer customerId) {
		super();
		this.receiverName = receiverName;
		this.receiverTelephone = receiverTelephone;
		this.receiverAddressFirst = receiverAddressFirst;
		this.receiverAddressSecond = receiverAddressSecond;
		this.receiverAddressThird = receiverAddressThird;
		this.receiverAddressDetail = receiverAddressDetail;
		this.deliveryAddressId = deliveryAddressId;
		this.customerId = customerId;
	}

	public DeliveryAddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DeliveryAddressBean [receiverName=" + receiverName + ", receiverTelephone=" + receiverTelephone
				+ ", receiverAddressFirst=" + receiverAddressFirst + ", receiverAddressSecond=" + receiverAddressSecond
				+ ", receiverAddressThird=" + receiverAddressThird + ", receiverAddressDetail=" + receiverAddressDetail
				+ ", deliveryAddressId=" + deliveryAddressId + ", customerId=" + customerId + "]";
	}
	
}
