package com.fjsf.web.viewobject;

import java.util.List;

import com.fjsf.web.bean.OrderDetailBean;

public class OrderView {
	
	/*
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
	*/
	// 订单明细
	List<OrderDetailBean> listOrderDetailBean;

	public List<OrderDetailBean> getListOrderDetailBean() {
		return listOrderDetailBean;
	}

	public void setListOrderDetailBean(List<OrderDetailBean> listOrderDetailBean) {
		this.listOrderDetailBean = listOrderDetailBean;
	}

	public OrderView(List<OrderDetailBean> listOrderDetailBean) {
		super();
		this.listOrderDetailBean = listOrderDetailBean;
	}

	public OrderView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderView [listOrderDetailBean=" + listOrderDetailBean + "]\n";
	}
	
}	
