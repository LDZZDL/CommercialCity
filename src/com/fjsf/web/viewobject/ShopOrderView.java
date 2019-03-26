package com.fjsf.web.viewobject;

import java.util.List;

import com.fjsf.web.bean.DeliveryAddressBean;
import com.fjsf.web.bean.OrderMasterBean;
import com.fjsf.web.bean.ProductBean;

public class ShopOrderView {
	
	//订单主表信息
	private OrderMasterBean orderMasterBean;
	//订单产品信息
	private List<ProductBean> listProductBean;
	//订单数量信息
	private List<Integer> listQuantity;
	//收货地址信息
	private DeliveryAddressBean deliveryAddressBean;

	public OrderMasterBean getOrderMasterBean() {
		return orderMasterBean;
	}

	public void setOrderMasterBean(OrderMasterBean orderMasterBean) {
		this.orderMasterBean = orderMasterBean;
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

	public DeliveryAddressBean getDeliveryAddressBean() {
		return deliveryAddressBean;
	}

	public void setDeliveryAddressBean(DeliveryAddressBean deliveryAddressBean) {
		this.deliveryAddressBean = deliveryAddressBean;
	}

	public ShopOrderView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopOrderView(OrderMasterBean orderMasterBean, List<ProductBean> listProductBean, List<Integer> listQuantity,
			DeliveryAddressBean deliveryAddressBean) {
		super();
		this.orderMasterBean = orderMasterBean;
		this.listProductBean = listProductBean;
		this.listQuantity = listQuantity;
		this.deliveryAddressBean = deliveryAddressBean;
	}

	@Override
	public String toString() {
		return "ShopOrderView [orderMasterBean=" + orderMasterBean + ", listProductBean=" + listProductBean
				+ ", listQuantity=" + listQuantity + ", deliveryAddressBean=" + deliveryAddressBean + "]";
	}
}
