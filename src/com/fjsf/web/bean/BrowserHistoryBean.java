package com.fjsf.web.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BrowserHistoryBean {
	
	//顾客编号
	Integer customerId;
	//产品编号
	Integer productId;
	//浏览时间
	@JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分",timezone="GMT+8")
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public BrowserHistoryBean(Integer customerId, Integer productId, Date time) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.time = time;
	}

	public BrowserHistoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BrowserHistoryBean [customerId=" + customerId + ", productId=" + productId + ", time=" + time + "]";
	}
	
	
}
