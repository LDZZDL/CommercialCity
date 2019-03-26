package com.fjsf.web.dao.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import com.fjsf.web.bean.CreditCardBean;
import com.fjsf.web.dao.CreditCardDAO;
import com.fjsf.web.dao.CustomerDAO;
import com.fjsf.web.utils.BigDecimalUtils;

public class CreditCardDAOImpl extends BaseDAO<CreditCardBean> implements CreditCardDAO{

	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Override
	public Integer getCreditIdByAccountAndPassword(String account, String password) {
		String sql = "SELECT creditCardId FROM creditCard "
				+ "WHERE creditAccount = ? AND creditPassword = ?";
		return getSingleVal(sql, account, password);
	}

	@Override
	public Integer getCreditIdByAccount(String account) {
		String sql = "SELECT creditCardId FROM creditCard "
				+ "WHERE creditAccount = ?";
		return getSingleVal(sql, account);
	}

	@Override
	public CreditCardBean getCreditCardByCreditCardId(Integer creditCardId) {
		String sql = "SELECT creditCardId, creditAccount, creditPassword, money "
				+ "FROM creditcard WHERE creditCardId = ?";
		return query(sql, creditCardId);
	}

	
	@Override
	public void customerPayMoney(Double money, Integer creditCardId) {
		Double creditCardMoney = getMoneyByCreditCardId(creditCardId);
		//creditCardMoney -= money;
		//=====================//
		creditCardMoney = BigDecimalUtils.getResultSub(creditCardMoney, money);
		//=====================//
		String sql = "UPDATE creditCard set money = ? WHERE creditCardId = ?";
		update(sql, creditCardMoney, creditCardId);
	}

	@Override
	public void shopReceiveMoney(Double money, Integer creditCardId) {
		Double creditCardMoney = getMoneyByCreditCardId(creditCardId);
		//creditCardMoney += money;
		//=============================//
		creditCardMoney = BigDecimalUtils.getResultAdd(creditCardMoney, money);
		//=============================//
		String sql = "UPDATE creditCard set money = ? WHERE creditCardId = ?";
		update(sql, creditCardMoney, creditCardId);
	}

	@Override
	public Double getMoneyByCreditCardId(Integer creditCardId) {
		String sql = "SELECT money FROM creditCard WHERE creditCardId = ?";
		return getSingleVal(sql, creditCardId);
	}

	
	
	@Override
	public boolean checkCreditMoney(Double money, Integer customerId) {
		Integer creditCardId =  customerDAO.getCreditCardIdByCustomerId(customerId);
		String sql = "SELECT count(*) FROM creditCard WHERE money >= ? AND creditCardId = ?";
		long count = getSingleVal(sql, money, creditCardId);
		if(count > 0) return true;
		return false;
	}

	@Override
	public List<CreditCardBean> getAll() {
		String sql = "SELECT creditCardId,creditAccount,creditPassword,money FROM creditcard";
		return queryForList(sql);
	}

	@Override
	public void customerReceiveMoney(Double money, Integer creditCardId) {
		Double creditCardMoney = getMoneyByCreditCardId(creditCardId);
		//creditCardMoney += money;
		//==============================//
		creditCardMoney = BigDecimalUtils.getResultAdd(creditCardMoney, money);
		//==============================//
		String sql = "UPDATE creditCard set money = ? WHERE creditCardId = ?";
		update(sql, creditCardMoney, creditCardId);
	}

	@Override
	public void shopPayMoney(Double money, Integer creditCardId) {
		Double creditCardMoney = getMoneyByCreditCardId(creditCardId);
		//creditCardMoney -= money;
		//=============================//
		creditCardMoney = BigDecimalUtils.getResultSub(creditCardMoney, money);
		//=============================//
		String sql = "UPDATE creditCard set money = ? WHERE creditCardId = ?";
		update(sql, creditCardMoney, creditCardId);
	}

}
