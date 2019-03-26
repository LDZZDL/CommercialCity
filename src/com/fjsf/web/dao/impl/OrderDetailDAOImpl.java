package com.fjsf.web.dao.impl;

import java.util.List;

import com.fjsf.web.bean.OrderDetailBean;
import com.fjsf.web.dao.OrderDetailDAO;

public class OrderDetailDAOImpl extends BaseDAO<OrderDetailBean> implements OrderDetailDAO{

	@Override
	public void addOrderDetail(long orderId, Integer productId, Integer quantity) {
		String sql = "INSERT INTO orderDetail(orderId,productId,quantity) VALUES(?,?,?)";
		insert(sql, orderId, productId, quantity);
	}

	@Override
	public void deleteOrderDetail(Integer orderId) {
		String sql = "DELETE FROM orderDetail WHERE orderId = ?";
		update(sql, orderId);
	}

	@Override
	public List<OrderDetailBean> getOrderDetailByOrderId(Integer orderId) {
		String sql = "SELECT orderId,productId,quantity FROM orderDetail WHERE orderId = ?";
		return queryForList(sql, orderId);
	}

	@Override
	public List<OrderDetailBean> getOrderDetailByOrderIdUnCommented(Integer orderId) {
		String sql = "SELECT orderDetail.orderId,orderDetail.productId,quantity FROM orderDetail "
				+ " WHERE orderDetail.orderId = ? AND orderDetail.productId NOT IN "
				+ " (SELECT productId FROM comment WHERE orderId = ?)";
		return queryForList(sql, orderId, orderId);
	}
	
	
}
