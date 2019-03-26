package com.fjsf.web.dao;

import java.util.List;

import com.fjsf.web.bean.OrderMasterBean;

public interface OrderMasterDAO {
	
	/**
	 * 订单状态:
	 * 1.待付款
	 * 2.待发货
	 * 3.待收货
	 * 4.待评价
	 * 5.已完成
	 */
	
	
	/**
	 * 生成订单主表
	 * @param customerId 用户编号
	 * @param deliveryAddressId 收货地址编号
	 */
	long addOrderMaster(Integer customerId, Integer deliveryAddressId);
	/**
	 * 删除订单
	 * @param orderId 订单编号
	 */
	void deleteOrderMaster(Integer orderId);
	/**
	 * 根据订单状态获取订单信息
	 * @param customerId 用户编号
	 * @param orderMasterStatus 订单状态
	 * @param pageNo 当前页数
	 * @param pageSize 页面大小
	 * @return
	 */
	List<OrderMasterBean> getOrderMasterWithConditon(Integer customerId, String orderMasterStatus, Integer pageNo, Integer pageSize);
	/**
	 * 根据用户编号获取所有订单信息
	 * @param customerId 用户编号
	 * @param pageNo 当前页数
	 * @param pageSize 页面大小
	 * @return
	 */
	List<OrderMasterBean> getOrderMasterByCustomerId(Integer customerId, Integer pageNo, Integer pageSize);
	/**
	 * 获取指定条件的指定主表的数量
	 * @param customerId 用户编号
	 * @param orderMasterStatus 订单状态
	 * @return
	 */
	long countOrderMasterWithConditon(Integer customerId, String orderMasterStatus);
	/**
	 * 获取指定条件主表的数量
	 * @param customerId 用户编号
	 * @return
	 */
	long countOrderMasterByCustomerId(Integer customerId);
	/**
	 * 通过订单编号修改订单状态
	 * @param orderMasterStatus 订单状态
	 * @param orderId 订单编号
	 */
	void changeorderMasterStatusByOrderId(String orderMasterStatus, Integer orderId);
	/**
	 * 获取指定商家的指定订单主表信息
	 * @param shopId 商店编号
	 * @param orderMasterStatus 订单状态
	 * @return
	 */
	long countOrderMasterByShopId(Integer shopId, String orderMasterStatus);
	/**
	 * 
	 * @param shopId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<OrderMasterBean> getOrderMasterMessageByShopId(Integer shopId, String orderMasterStatus,
			Integer pageNo, Integer pageSize);
	/**
	 * 判断订单是否完结
	 * @param orderId 订单编号
	 * @return
	 */
	boolean judgeOrderEnd(Integer orderId);
	/**
	 * 获取今日销售额
	 * @param shopId 商店编号
	 * @return
	 */
	Double getTodaySaleMoney(Integer shopId);
	/**
	 * 获取今日销售订单数量
	 * @param shopId 商店编号
	 * @return
	 */
	long getTodayOrderQuantity(Integer shopId);
	/**
	 * 获取今日销售的产品数量
	 * @param shopId 商店编号
	 * @return
	 */
	long getTodayProductQuantity(Integer shopId);
	
}
