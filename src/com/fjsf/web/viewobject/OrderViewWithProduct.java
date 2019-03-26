package com.fjsf.web.viewobject;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjsf.web.bean.OrderDetailBean;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.bean.ShopBean;

public class OrderViewWithProduct {
	// 订单编号
	private Integer orderId;
	// 用户编号
	private Integer customerId;
	// 收货地址编号
	private Integer deliveryAddressId;
	// 下单时间
	@JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分")
	private Date orderMasterTime;
	// 订单状态
	private String orderMasterStatus;
	// 订单明细
	List<OrderDetailBean> listOrderDetailBean;
	// 产品信息
	List<ProductBean> listProductBean;
	// 商店信息
	ShopBean shopBean;

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

	public List<OrderDetailBean> getListOrderDetailBean() {
		return listOrderDetailBean;
	}

	public void setListOrderDetailBean(List<OrderDetailBean> listOrderDetailBean) {
		this.listOrderDetailBean = listOrderDetailBean;
	}

	public List<ProductBean> getListProductBean() {
		return listProductBean;
	}

	public void setListProductBean(List<ProductBean> listProductBean) {
		this.listProductBean = listProductBean;
	}

	public ShopBean getShopBean() {
		return shopBean;
	}

	public void setShopBean(ShopBean shopBean) {
		this.shopBean = shopBean;
	}

	public OrderViewWithProduct(Integer orderId, Integer customerId, Integer deliveryAddressId, Date orderMasterTime,
			String orderMasterStatus, List<OrderDetailBean> listOrderDetailBean, List<ProductBean> listProductBean,
			ShopBean shopBean) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.deliveryAddressId = deliveryAddressId;
		this.orderMasterTime = orderMasterTime;
		this.orderMasterStatus = orderMasterStatus;
		this.listOrderDetailBean = listOrderDetailBean;
		this.listProductBean = listProductBean;
		this.shopBean = shopBean;
	}

	public OrderViewWithProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderViewWithProduct [orderId=" + orderId + ", customerId=" + customerId + ", deliveryAddressId="
				+ deliveryAddressId + ", orderMasterTime=" + orderMasterTime + ", orderMasterStatus="
				+ orderMasterStatus + ", listOrderDetailBean=" + listOrderDetailBean + ", listProductBean="
				+ listProductBean + ", shopBean=" + shopBean + "]";
	}
	
}
