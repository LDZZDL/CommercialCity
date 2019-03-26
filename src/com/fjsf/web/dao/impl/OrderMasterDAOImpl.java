package com.fjsf.web.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fjsf.web.bean.OrderMasterBean;
import com.fjsf.web.dao.OrderMasterDAO;
import com.mchange.v2.c3p0.QueryConnectionTester;

public class OrderMasterDAOImpl extends BaseDAO<OrderMasterBean> implements OrderMasterDAO{

	@Override
	public long addOrderMaster(Integer customerId, Integer deliveryAddressId) {
		Date date = new Date();
		String sql = "INSERT INTO orderMaster(customerId,deliveryAddressId,orderMasterTime,orderMasterStatus) "
				+ "VALUES(?,?,?,?)";
		return insert(sql, customerId, deliveryAddressId, date, "待付款");
	}

	@Override
	public void deleteOrderMaster(Integer orderId) {
		String sql = "DELETE FROM orderMaster WHERE orderId = ?";
		update(sql, orderId);
	}

	private String getOrdermasterLimit(Integer pageNo, Integer pageSize){
		
		return "LIMIT " + (pageNo-1)*pageSize + "," + pageSize;
	}
	
	@Override
	public List<OrderMasterBean> getOrderMasterWithConditon(Integer customerId, String orderMasterStatus, Integer pageNo, Integer pageSize) {
		String sql = "SELECT orderId,customerId,deliveryAddressId,orderMasterTime,orderMasterStatus "
				+ "FROM orderMaster WHERE customerId = ? AND orderMasterStatus = ? ORDER BY orderMasterTime DESC " 
				+ getOrdermasterLimit(pageNo, pageSize);
		return queryForList(sql, customerId, orderMasterStatus);
	}

	@Override
	public List<OrderMasterBean> getOrderMasterByCustomerId(Integer customerId, Integer pageNo, Integer pageSize) {
		String sql = "SELECT orderId,customerId,deliveryAddressId,orderMasterTime,orderMasterStatus "
				+ " FROM orderMaster WHERE customerId = ? ORDER BY orderMasterTime DESC "
				+ getOrdermasterLimit(pageNo, pageSize);
		return queryForList(sql, customerId);
	}

	@Override
	public long countOrderMasterWithConditon(Integer customerId, String orderMasterStatus) {
		String sql = "SELECT count(*) FROM orderMaster WHERE customerId = ? AND orderMasterStatus = ?";
		return getSingleVal(sql, customerId, orderMasterStatus);
	}

	@Override
	public long countOrderMasterByCustomerId(Integer customerId) {
		String sql = "SELECT count(*) FROM orderMaster WHERE customerId = ?";
		return getSingleVal(sql, customerId);
	}

	@Override
	public void changeorderMasterStatusByOrderId(String orderMasterStatus,Integer orderId) {
		String sql = "UPDATE orderMaster SET orderMasterStatus = ?,orderMasterTime = ? WHERE orderId = ?";
		update(sql, orderMasterStatus, new Date(), orderId);
	}

	@Override
	public long countOrderMasterByShopId(Integer shopId, String orderMasterStatus) {
		String sql = "SELECT count(distinct orderMaster.orderId) FROM orderMaster INNER JOIN OrderDetail "
				+ " ON(orderMaster.orderId = orderDetail.orderId) INNER JOIN product "
				+ " ON(orderDetail.productId = product.productId) INNER JOIN shop "
				+ " ON(product.shopId = shop.shopId) WHERE shop.shopId = ? AND orderMasterStatus = ? ";
		return getSingleVal(sql, shopId, orderMasterStatus);
	}

	@Override
	public List<OrderMasterBean> getOrderMasterMessageByShopId(Integer shopId, String orderMasterStatus, Integer pageNo,
			Integer pageSize) {
		String sql = "SELECT distinct orderMaster.orderId,customerId,deliveryAddressId,orderMasterTime,orderMasterStatus "
				+ " FROM orderMaster INNER JOIN OrderDetail "
				+ " ON(orderMaster.orderId = orderDetail.orderId) INNER JOIN product "
				+ " ON(orderDetail.productId = product.productId) INNER JOIN shop "
				+ " ON(product.shopId = shop.shopId) WHERE shop.shopId = ? AND orderMasterStatus = ? " 
				+ " GROUP BY orderMaster.orderId"
				+ " ORDER BY orderMasterTime DESC " + getOrdermasterLimit(pageNo, pageSize);
		System.out.println(sql);
		return queryForList(sql, shopId, orderMasterStatus);
	}

	@Override
	public boolean judgeOrderEnd(Integer orderId) {
		String sql = "SELECT count(*) from orderMaster INNER JOIN comment ON(orderMaster.orderId = comment.orderId) "
				+ " where orderMaster.orderId = ?";
		long countComment = getSingleVal(sql, orderId);
		System.out.println("已经评论的商品" + countComment);
		sql = "SELECT count(*) from orderMaster INNER JOIN orderDetail ON(orderMaster.orderId = orderdetail.orderId) "
				+ " where orderMaster.orderId = ?";
		long countProduct = getSingleVal(sql, orderId);
		System.out.println("订单数量:" + countProduct);
		if(countComment != countProduct) return false;
		return true;
	}

	@Override
	public Double getTodaySaleMoney(Integer shopId) {
		String sql = "SELECT sum(productSale * quantity) FROM orderMaster INNER JOIN orderDetail "
				+ " ON(orderMaster.orderId = orderDetail.orderId) "
				+ " INNER JOIN product ON(orderDetail.productId = product.productId) "
				+ " INNER JOIN shop ON(product.shopId = shop.shopId) "
				+ " WHERE shop.shopId = ? AND orderMasterStatus != '待付款' "
				+ " AND (orderMasterStatus != '待发货' "
				+ " AND orderMasterStatus != '待付款' "
				+ " AND orderMasterStatus != '订单取消' )"
				+ " AND datediff(now(),orderMasterTime) <= 1";
		Double dmoney = getSingleVal(sql, shopId);
		return Double.parseDouble(String.format("%.2f", dmoney));
	}

	@Override
	public long getTodayOrderQuantity(Integer shopId) {
		String sql = "SELECT count(distinct orderMaster.orderId) FROM orderMaster INNER JOIN orderDetail "
				+ " ON(orderMaster.orderId = orderDetail.orderId) "
				+ " INNER JOIN product ON(orderDetail.productId = product.productId) "
				+ " INNER JOIN shop ON(product.shopId = shop.shopId) "
				+ " WHERE datediff(now(),orderMasterTime) <= 1 "
				+ " AND (orderMasterStatus != '待发货' "
				+ " AND orderMasterStatus != '待付款' "
				+ " AND orderMasterStatus != '订单取消' )"
				+ " AND shop.shopId = ?";
		return getSingleVal(sql, shopId);
	}

	@Override
	public long getTodayProductQuantity(Integer shopId) {
		String sql = "SELECT sum(quantity) FROM orderMaster "
				+ " INNER JOIN orderDetail ON(OrderMaster.orderId = orderDetail.orderId) "
				+ " INNER JOIN product ON(orderDetail.productId = product.productId)"
				+ " INNER JOIN shop ON(product.shopId = shop.shopId) "
				+ " WHERE datediff(now(),orderMasterTime) <= 1 "
				+ " AND (orderMasterStatus != '待发货' "
				+ " AND orderMasterStatus != '待付款' "
				+ " AND orderMasterStatus != '订单取消' )"
				+ " AND shop.shopId = ? ";
		System.out.println(sql);
		BigDecimal bigDecimal = getSingleVal(sql, shopId);
		return bigDecimal.longValue();
	}

}
