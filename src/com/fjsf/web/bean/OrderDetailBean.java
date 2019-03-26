package com.fjsf.web.bean;

public class OrderDetailBean {
	
	//订单编号
	private Integer orderId;
	//产品编号
	private Integer productId;
	//数量
	private Integer quantity;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderDetailBean(Integer orderId, Integer productId, Integer quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public OrderDetailBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderDetailBean [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
}
