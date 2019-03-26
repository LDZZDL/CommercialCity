package com.fjsf.web.bean;

import java.util.Date;

public class CommentBean {
	
	// 用户编号
	private Integer customerId;
	// 产品编号
	private Integer productId;
	//订单编号
	private Integer orderId;
	// 评论内容(100 字以内)
	private String commentContent;
	// 星级
	private Integer goodRate;
	// 评论时间
	private Date commentTime;

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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Integer getGoodRate() {
		return goodRate;
	}

	public void setGoodRate(Integer goodRate) {
		this.goodRate = goodRate;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public CommentBean(Integer customerId, Integer productId, Integer orderId, String commentContent, Integer goodRate,
			Date commentTime) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.orderId = orderId;
		this.commentContent = commentContent;
		this.goodRate = goodRate;
		this.commentTime = commentTime;
	}

	public CommentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommentBean [customerId=" + customerId + ", productId=" + productId + ", orderId=" + orderId
				+ ", commentContent=" + commentContent + ", goodRate=" + goodRate + ", commentTime=" + commentTime
				+ "]";
	}
}
