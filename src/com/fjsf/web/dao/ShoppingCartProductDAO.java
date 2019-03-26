package com.fjsf.web.dao;

import java.util.List;

import com.fjsf.web.bean.ShoppingCartProductBean;




public interface ShoppingCartProductDAO {
	/**
	 * 加入购物车
	 * @param productId 产品编号
	 * @param customerId 顾客编号
	 */
	void addShoppingCart(Integer productId, Integer customerId, Integer quantity);
	/**
	 * 计算购物车商品中产品编号为productId 顾客编号为customerId的数量
	 * @param productId 产品编号
	 * @param customerId 顾客编号
	 * @return 数量
	 */
	long countShoppingCartProduct(Integer productId, Integer customerId);
	/**
	 * 通过用户编号获取购物车商品
	 * @param customerId 用户编号
	 * @return
	 */
	List<ShoppingCartProductBean> getShoppingCartProductByCustomerId(Integer customerId);
	/**
	 * 获取购物车指定商品的数量信息
	 * @param customerId 用户编号
	 * @param productId 产品编号
	 * @return 数量
	 */
	Integer getQuantityByCustomerIdAndProductId(Integer customerId, Integer productId);
	/**
	 * 通过商店编号获取购物车商品
	 * @param shopId 商店编号
	 * @return
	 */
	List<ShoppingCartProductBean> getShoppingCartProductByShopId(Integer shopId);
	/**
	 * 通过商品编号和用户编号删除购物车商品
	 * @param customerId用户编号
	 * @param productId 商品编号
	 */
	void deleteShoppingCartProductByCustomerIdAndProductId(Integer customerId, Integer productId);
	/**
	 * 修改指定购物车商品的数量
	 * @param customerId 用户编号
	 * @param productId 商品编号
	 */
	void changeShoppingCartProductQuantity(Integer customerId, Integer productId, Integer quantity);
}
