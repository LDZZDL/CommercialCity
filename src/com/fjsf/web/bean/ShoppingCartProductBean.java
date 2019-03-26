package com.fjsf.web.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ShoppingCartProductBean {
	
	// 用户编号
	private Integer customerId;
	// 产品编号
	private Integer productId;
	// 数量
	private Integer quantity;
	// 时间
	@JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒",timezone="GMT+8")
	Date time;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public ShoppingCartProductBean(Integer customerId, Integer productId, Integer quantity, Date time) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.time = time;
	}

	public ShoppingCartProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ShoppingCartProductBean [customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", time=" + time + "]";
	}
}
