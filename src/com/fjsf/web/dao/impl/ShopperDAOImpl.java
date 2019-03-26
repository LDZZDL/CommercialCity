package com.fjsf.web.dao.impl;

import com.fjsf.web.bean.ShopperBean;
import com.fjsf.web.dao.Dao;
import com.fjsf.web.dao.ShopperDAO;

public class ShopperDAOImpl extends BaseDAO<ShopperBean> implements ShopperDAO{

	@Override
	public void register(ShopperBean shopper) {
		String sql = "INSERT INTO shopper(account,password,mail"
				+ ",idCard,creditCardId,onlineName,displayPicture) "
				+ "VALUES(?,?,?,?,?,?,?)";
		update(sql, shopper.getAccount(),shopper.getPassword(),shopper.getMail()
				,shopper.getIdCard(),shopper.getCreditCardId(),shopper.getOnlineName()
				,shopper.getDisplayPicture());
	}

	@Override
	public long countAccount(String account) {
		long count = 0;
		String sql = "SELECT count(*) FROM shopper WHERE account = ?";
		count = getSingleVal(sql, account);
		return count;
	}

	@Override
	public long countMail(String mail) {
		long count = 0;
		String sql = "SELECT count(*) FROM shopper WHERE mail = ?";
		count = getSingleVal(sql, mail);
		return count;
	}

	@Override
	public long countIdCard(String idCard) {
		long count = 0;
		String sql = "SELECT count(*) FROM shopper WHERE idCard = ?";
		count = getSingleVal(sql, idCard);
		return count;
	}

	@Override
	public long countOnlineName(String onlineName) {
		long count = 0;
		String sql = "SELECT count(*) FROM shopper WHERE onlineName = ?";
		count = getSingleVal(sql, onlineName);
		return count;
	}

	@Override
	public long countCrditCard(Integer creditCardId) {
		long count = 0;
		String sql = "SELECT count(*) FROM shopper WHERE creditCardId = ?";
		count = getSingleVal(sql, creditCardId);
		return count;
	}
	
	@Override
	public boolean loginShopper(String account, String password) {
		long count = 0;
		String sql = "SELECT count(*) FROM shopper WHERE account = ? AND password = ?";
		count = getSingleVal(sql, account, password);
		if(count == 0)
			return false;
		return true;
	}

	@Override
	public String getMailByAccount(String account) {
		String sql = "SELECT mail FROM shopper WHERE account = ?";
		return getSingleVal(sql, account);
	}

	@Override
	public void changePasswordByAccount(String account, String newPassword) {
		String sql = "UPDATE shopper SET password = ? WHERE account = ?";
		update(sql, newPassword, account);
	}

	@Override
	public Integer getShopperIdByAccount(String account) {
		String sql = "SELECT shopperId FROM shopper WHERE account = ?";
		return getSingleVal(sql, account);
	}

	@Override
	public ShopperBean getShopperByShopperId(Integer shopperId) {
		String sql = "SELECT shopperId, creditCardId, account, password, mail, idCard,"
				+ "onlineName, displayPicture FROM shopper WHERE shopperId = ?";
		return query(sql, shopperId);
	}
	
	//===================================黄宁==================================//
	@Override
	public String getMailByShopperId(Integer shopperId) {
		String sql="SELECT mail FROM shopper WHERE shopperId = ?";
		return getSingleVal(sql, shopperId);
	}

	@Override
	public void changeShopperNameByShopperId( String newShopperName,Integer shopperId) {
		String sql="UPDATE shopper SET onlineName = ? WHERE shopperId = ?";
		update(sql, newShopperName,shopperId);
		
	}

	@Override
	public void changeShopperPasswordByShopperId( String newShopperPassword,Integer shopperId) {
		String sql="UPDATE shopper SET password = ? WHERE shopperId = ?";
		update(sql, newShopperPassword,shopperId);
		
	}

	@Override
	public void changeMailByShopperId( String newMail,Integer shopperId) {
		String sql="UPDATE shopper SET mail = ? WHERE shopperId = ?";
		update(sql, newMail,shopperId);
		
	}

	@Override
	public void changeDisplayPictureByShopperId( String newDisplayPicture,Integer shopperId) {
		String sql="UPDATE shopper SET displayPicture = ? WHERE shopperId = ?";
		update(sql, newDisplayPicture,shopperId);
		
	}

	@Override
	public void changeCreditCardIdByShopperId( Integer creditCardId,Integer shopperId) {
		String sql="UPDATE shopper SET creditCardId = ? WHERE shopperId = ?";
		update(sql,creditCardId,shopperId);
		
	}
	@Override
	public long countOnlineName(String onlineName,Integer shopperId) {
		long count = 0;
		String sql = "SELECT count(*) FROM shopper WHERE onlineName = ? AND shopperId != ?";
		count = getSingleVal(sql, onlineName,shopperId);
		return count;
	}
	//===================================黄宁==================================//
	@Override
	public Integer getCreditCardIdByShopperId(Integer shopperId) {
		String sql = "SELECT creditCardId FROM shopper WHERE shopperId = ?";
		return getSingleVal(sql, shopperId);
	}
	
	
	
	
}
