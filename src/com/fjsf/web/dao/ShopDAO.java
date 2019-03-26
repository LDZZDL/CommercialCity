package com.fjsf.web.dao;

import com.fjsf.web.bean.ShopBean;

public interface ShopDAO {
	/**
	 * 获取数据库shop中shopName = 输入shopName的数量
	 * @param shopName 店铺名字
	 * @return
	 */
	long countShopName(String shopName);
	/**
	 * 注册商家
	 * @param shopBean 包含商家信息
	 */
	long register(ShopBean shopBean);
	/**
	 * 通过商家编号获取商店编号
	 * @param shopperId 商家编号
	 * @return 商店编号
	 */
	Integer getShopIdByShopperId(int shopperId);
	/**
	 * 通过商店编号获取商店信息
	 * @param shopId 商店编号
	 * @return 商店信息
	 */
	ShopBean getShopByShopId(Integer shopId);
	//===================黄宁===========================//
	/**
	 * 通过商家编号获得商店信息
	 * @param shopperId 商店编号
	 * @return 商店信息
	 */
	ShopBean getShopMessageByShopperId(Integer shopperId);	
	/**
	 * 通过店铺编号修改店铺名
	 * @param shopId 店铺编号
	 * @param newShopName 店铺名
	 */
	void changeShopNameByShopId(String newShopName,Integer shopId);
	/**
	 * 通过店铺编号修改店铺介绍
	 * @param shopId 店铺编号
	 * @param newShopIntruducion 店铺介绍
	 */
	void changeShopIntruducionByShopId(String newShopIntruduction,Integer shopId);
	/**
	 * 通过店铺号修改店铺头像
	 * @param shopId店铺编号
	 * @param newDisplayPicture店铺头像
	 */
	void changeDisplayPictureByShopId(String newDisplayPicture,Integer shopId);
	/**
	 * 获取数据库shop中shopName = 输入shopName的数量
	 * @param shopName 店铺名字
	 * @return
	 */
	long countShopName(String shopName,Integer shopId);
	//===================黄宁===========================//
	/**
	 * 通过商店编号获取商家编号
	 * @param shopperId 商家编号
	 * @return
	 */
	Integer getShopperIdByShopId(Integer shopId);
	
}
