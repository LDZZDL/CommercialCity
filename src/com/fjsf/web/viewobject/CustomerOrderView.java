package com.fjsf.web.viewobject;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjsf.web.bean.DeliveryAddressBean;
import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.bean.ShopBean;

public class CustomerOrderView {
	
	// 订单编号
	private Integer orderId;
	// 下单时间
	@JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分")
	private Date orderMasterTime;
	// 订单状态
	private String orderMasterStatus;
	// 产品信息
	private List<ProductBean> listProductBean;
	// 产品数量
	private List<Integer> listQuantity;
	// 商店信息
	private ShopBean shopBean;
	// 收货地址
	private DeliveryAddressBean deliveryAddressBean;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public List<ProductBean> getListProductBean() {
		return listProductBean;
	}

	public void setListProductBean(List<ProductBean> listProductBean) {
		this.listProductBean = listProductBean;
	}

	public List<Integer> getListQuantity() {
		return listQuantity;
	}

	public void setListQuantity(List<Integer> listQuantity) {
		this.listQuantity = listQuantity;
	}

	public ShopBean getShopBean() {
		return shopBean;
	}

	public void setShopBean(ShopBean shopBean) {
		this.shopBean = shopBean;
	}

	public DeliveryAddressBean getDeliveryAddressBean() {
		return deliveryAddressBean;
	}

	public void setDeliveryAddressBean(DeliveryAddressBean deliveryAddressBean) {
		this.deliveryAddressBean = deliveryAddressBean;
	}

	public CustomerOrderView(Integer orderId, Date orderMasterTime, String orderMasterStatus,
			List<ProductBean> listProductBean, List<Integer> listQuantity, ShopBean shopBean,
			DeliveryAddressBean deliveryAddressBean) {
		super();
		this.orderId = orderId;
		this.orderMasterTime = orderMasterTime;
		this.orderMasterStatus = orderMasterStatus;
		this.listProductBean = listProductBean;
		this.listQuantity = listQuantity;
		this.shopBean = shopBean;
		this.deliveryAddressBean = deliveryAddressBean;
	}

	public CustomerOrderView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerOrderView [orderId=" + orderId + ", orderMasterTime=" + orderMasterTime + ", orderMasterStatus="
				+ orderMasterStatus + ", listProductBean=" + listProductBean + ", listQuantity=" + listQuantity
				+ ", shopBean=" + shopBean + ", deliveryAddressBean=" + deliveryAddressBean + "]";
	}
}
