package com.fjsf.web.dao;

import java.util.List;

import com.fjsf.web.bean.OrderDetailBean;

public interface OrderDetailDAO {
	
	/**
	 * 生成订单明细
	 * @param orderId 订单主表编号
	 * @param productId 产品编号
	 * @param quantity 产品数量
	 */
	void addOrderDetail(long orderId, Integer productId, Integer quantity);
	/**
	 * 根据订单编号删除订单明细
	 * @param orderId 订单编号
	 */
	void deleteOrderDetail(Integer orderId);
	
	/**
	 * 根据订单编号获取订单明细信息
	 * @param orderId 订单编号
	 * @return
	 */
	List<OrderDetailBean> getOrderDetailByOrderId(Integer orderId);
	/**
	 * 获取未评价的订单明细
	 * @param orderId 订单编号
	 * @return
	 */
	List<OrderDetailBean> getOrderDetailByOrderIdUnCommented(Integer orderId);
}
