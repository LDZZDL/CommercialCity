package com.fjsf.web.dao.impl;

import java.util.Date;
import java.util.List;

import com.fjsf.web.bean.ShoppingCartProductBean;
import com.fjsf.web.dao.ShoppingCartProductDAO;

public class ShoppingCartProductDAOImpl extends BaseDAO<ShoppingCartProductBean> implements ShoppingCartProductDAO{

	@Override
	public void addShoppingCart(Integer productId, Integer customerId, Integer quantity) {
		long count = countShoppingCartProduct(productId, customerId);
		if(count == 0){
			String sql = "INSERT INTO shoppingCartProduct(customerId,productId,quantity,time) "
					+ " VALUES(?,?,?,?)";
			insert(sql, customerId, productId, quantity, new Date());
		}else{
			Integer changeQuantity = getQuantityByCustomerIdAndProductId(customerId, productId) + quantity;
			String sql = "UPDATE shoppingCartProduct SET quantity = ?,time = ? WHERE customerId = ?  AND productId = ? ";
			update(sql, changeQuantity, new Date(), customerId, productId);
		}
	}

	@Override
	public long countShoppingCartProduct(Integer productId, Integer customerId) {
		String sql = "SELECT count(*) FROM ShoppingCartProduct WHERE "
				+ "productId = ? AND customerId = ?";
		return getSingleVal(sql, productId, customerId);
	}

	@Override
	public List<ShoppingCartProductBean> getShoppingCartProductByCustomerId(Integer customerId) {
		String sql = "SELECT customerId,productId,quantity,time FROM ShoppingCartProduct "
				+ "WHERE customerId = ?";
		return queryForList(sql, customerId);
	}

	@Override
	public Integer getQuantityByCustomerIdAndProductId(Integer customerId, Integer productId) {
		String sql = "SELECT quantity FROM ShoppingCartProduct WHERE customerId = ?  AND productId = ? ";
		return getSingleVal(sql, customerId, productId);
	}

	@Override
	public List<ShoppingCartProductBean> getShoppingCartProductByShopId(Integer shopId) {
		String sql = "SELECT customerId,shoppingCartProduct.productId,quantity,time FROM ShoppingCartProduct "
				+ " INNER JOIN product ON(product.productId=shoppingCartProduct.productId) "
				+ " WHERE shopId = ? ORDER BY time DESC";
		return queryForList(sql, shopId);
	}

	@Override
	public void deleteShoppingCartProductByCustomerIdAndProductId(Integer customerId, Integer productId) {
		String sql = "DELETE FROM ShoppingCartProduct WHERE customerId = ? AND productId = ?";
		update(sql, customerId, productId);
	}

	@Override
	public void changeShoppingCartProductQuantity(Integer customerId, Integer productId, Integer quantity) {
		//Integer changeQuantity = getQuantityByCustomerIdAndProductId(customerId, productId) + quantity;
		String sql = "UPDATE shoppingCartProduct SET quantity = ?,time = ? WHERE customerId = ?  AND productId = ? ";
		//update(sql, changeQuantity, new Date(), customerId, productId);
		update(sql, quantity, new Date(), customerId, productId);
	}

}
