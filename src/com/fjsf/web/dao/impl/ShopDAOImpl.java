package com.fjsf.web.dao.impl;

import com.fjsf.web.bean.ShopBean;
import com.fjsf.web.dao.ShopDAO;

public class ShopDAOImpl extends BaseDAO<ShopBean> implements ShopDAO{

	@Override
	public long countShopName(String shopName) {
		String sql = "SELECT count(*) FROM shop WHERE shopName = ?";
		return getSingleVal(sql, shopName);
	}

	@Override
	public long register(ShopBean shopBean) {
		String sql = "INSERT INTO shop(shopperId, shopName, introduction, openDate, displayPicture, goodRate) "
				+ "VALUES(?,?,?,?,?,?)";
		return insert(sql, shopBean.getShopperId(), shopBean.getShopName(), shopBean.getIntroduction(),
					shopBean.getOpenDate(), shopBean.getDisplayPicture(), shopBean.getGoodRate());
	}

	@Override
	public Integer getShopIdByShopperId(int shopperId) {
		String sql = "SELECT shopId FROM shop WHERE shopperId = ?";
		return getSingleVal(sql, shopperId);
	}

	@Override
	public ShopBean getShopByShopId(Integer shopId) {
		String sql = "SELECT shopId, shopperId, shopName, introduction, openDate, "
				+ "displayPicture, goodRate FROM shop WHERE shopId = ?";
		return query(sql, shopId);
	}
	
	//======================黄宁=============================//
	@Override
	public ShopBean getShopMessageByShopperId(Integer shopperId) {
		String sql = "SELECT shopId, shopperId, shopName, introduction, openDate, "
				+ "displayPicture, goodRate FROM shop WHERE shopperId = ?";
		return query(sql, shopperId);
	}

	@Override
	public void changeShopNameByShopId( String newShopName,Integer shopId) {
		String sql="UPDATE shop SET shopName = ? WHERE shopId = ?";
		update(sql, newShopName,shopId);
		
	}

	@Override
	public void changeShopIntruducionByShopId( String newShopIntruduction,Integer shopId) {
		String sql="UPDATE shop SET introduction = ? WHERE shopId = ?";
		update(sql, newShopIntruduction,shopId);
		
	}

	@Override
	public void changeDisplayPictureByShopId( String newDisplayPicture,Integer shopId) {
		String sql="UPDATE shop SET displayPicture = ? WHERE shopId = ?";
		update(sql, newDisplayPicture,shopId);
		
	}
	@Override
	public long countShopName(String shopName,Integer shopId) {
		String sql = "SELECT count(*) FROM shop WHERE shopName = ? AND shopId != ? ";
		return getSingleVal(sql, shopName,shopId);
	}
	//======================黄宁============================//

	@Override
	public Integer getShopperIdByShopId(Integer shopId) {
		String sql = "SELECT shopperId FROM shop WHERE shopId = ?";
		return getSingleVal(sql, shopId);
	}

}
