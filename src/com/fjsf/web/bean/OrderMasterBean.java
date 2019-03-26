package com.fjsf.web.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderMasterBean {
	
	//订单编号
	private Integer orderId;
	//用户编号
	private Integer customerId;
	//收货地址编号
	private Integer deliveryAddressId;
	//下单时间
	@JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒",timezone="GMT+8")
	private Date orderMasterTime;
	//订单状态
	private String orderMasterStatus;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(Integer deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public Date getOrderMasterTime() {
		return orderMasterTime;
	}

	public void setOrderMasterTime(Date orderMasterTime) {
		this.orderMasterTime = orderMasterTime;
	}

	public String getOrderMasterStatus() {
		return orderMasterStatus;
	}

	public void setOrderMasterStatus(String orderMasterStatus) {
		this.orderMasterStatus = orderMasterStatus;
	}

	public OrderMasterBean(Integer orderId, Integer customerId, Integer deliveryAddressId, Date orderMasterTime,
			String orderMasterStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.deliveryAddressId = deliveryAddressId;
		this.orderMasterTime = orderMasterTime;
		this.orderMasterStatus = orderMasterStatus;
	}

	public OrderMasterBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderMasterBean [orderId=" + orderId + ", customerId=" + customerId + ", deliveryAddressId="
				+ deliveryAddressId + ", orderMasterTime=" + orderMasterTime + ", orderMasterStatus="
				+ orderMasterStatus + "]";
	}

}
