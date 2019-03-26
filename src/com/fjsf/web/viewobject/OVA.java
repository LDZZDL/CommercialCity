package com.fjsf.web.viewobject;

public class OVA {
	Integer deliveryAddressNumber;

	public Integer getDeliveryAddressNumber() {
		return deliveryAddressNumber;
	}

	public void setDeliveryAddressNumber(Integer deliveryAddressNumber) {
		this.deliveryAddressNumber = deliveryAddressNumber;
	}

	public OVA(Integer deliveryAddressNumber) {
		super();
		this.deliveryAddressNumber = deliveryAddressNumber;
	}

	public OVA() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OVA [deliveryAddressNumber=" + deliveryAddressNumber + "]";
	}
	
}
