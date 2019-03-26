package com.fjsf.web.dao.impl;

import com.fjsf.web.bean.CustomerBean;
import com.fjsf.web.dao.CustomerDAO;

public class CustomerDAOImpl extends BaseDAO<CustomerBean> implements CustomerDAO{

	@Override
	public void customerRegist(CustomerBean customer) {
		String sql="INSERT INTO customer(customerAccount,customerPassword,customerMail,"
				+ "customerSex,creditCardId,customerName,displayPicture)"
				+" VALUES(?,?,?,?,?,?,?)";
		update(sql,customer.getCustomerAccount(),customer.getCustomerPassword(),customer.getCustomerMail(),
				customer.getCustomerSex(),customer.getCreditCardId(),customer.getCustomerName(),customer.getDisplayPicture());
	}

	@Override
	public long countCustomerAccount(String customerAccount) {
		long count = 0;
		String sql = "SELECT count(*) FROM customer WHERE customerAccount = ?";
		count = getSingleVal(sql, customerAccount);
		return count;
	}

	@Override
	public long countCustomerMail(String customerMail) {
		long count = 0;
		String sql = "SELECT count(*) FROM customer WHERE customerMail = ?";
		count = getSingleVal(sql, customerMail);
		return count;
	}

	@Override
	public long countCustomerName(String customerName) {
		long count = 0;
		String sql = "SELECT count(*) FROM customer WHERE customerName = ?";
		count = getSingleVal(sql, customerName);
		return count;
	}

	@Override
	public long countCreditCardId(Integer creditCardId) {
		long count = 0;
		String sql = "SELECT count(*) FROM customer WHERE creditCardId = ?";
		count = getSingleVal(sql, creditCardId);
		return count;
	}

	@Override
	public boolean loginCustomer(String customerAccount, String customerPassword) {
		long count = 0;
		String sql = "SELECT count(*) FROM customer WHERE customerAccount = ? AND customerPassword = ?";
		count = getSingleVal(sql, customerAccount, customerPassword);
		if(count == 0)
			return false;
		else 
			return true;
	}

	@Override
	public void changeCustomerPasswordByCustomerAccount(String customerAccount, String newPassword) {
		String sql = "UPDATE customer SET customerPassword = ? WHERE customerAccount = ?";
		update(sql, newPassword, customerAccount);
		
	}

	@Override
	public String getMailByCustomerAccount(String customerAccount) {
		String sql = "SELECT customerMail FROM customer WHERE customerAccount = ?";
		return getSingleVal(sql, customerAccount);
	}

	@Override
	public CustomerBean getCustomerMessageByAccount(String account) {
		String sql="SELECT customerId, creditCardId, customerName, customerSex, "
				+ "customerAccount, customerPassword, customerMail, displayPicture "
				+ "FROM customer WHERE customerAccount = ?";
		return query(sql, account);
	}

	@Override
	public Integer getCustomerIdByAccount(String account) {
		String sql = "SELECT customerId FROM customer WHERE customerAccount = ?";
		return getSingleVal(sql, account);
	}

	@Override
	public CustomerBean getCustomerMessageByCustomerId(Integer customerId) {
		String sql="SELECT customerId, creditCardId, customerName, customerSex, "
				+ "customerAccount, customerPassword, customerMail, displayPicture "
				+ "FROM customer WHERE customerId = ?";
		return query(sql, customerId);
	}

	@Override
	public void changeCustomerNameByCustomerId(Integer customerId, String newCustomerName) {
		String sql = "update customer set customerName = ? WHERE customerId = ?";
		update(sql, newCustomerName, customerId);
	}

	@Override
	public long countCustomerName(String customerName, Integer customerId) {
		String sql = "SELECT count(*) FROM customer WHERE customerName = ? AND customerId != ?";
		return getSingleVal(sql, customerName, customerId);
	}

	@Override
	public void changeCustomerSexByCustomerId(String newCustomerSex, Integer customerId) {
		String sql = "update customer set customerSex = ? WHERE customerId = ?";
		update(sql, newCustomerSex, customerId);
	}

	@Override
	public long countCustomerMail(String customerMail, Integer customerId) {
		String sql = "SELECT count(*) FROM customer WHERE customerMail = ? AND customerId != ?";
		return getSingleVal(sql, customerMail, customerId);
	}

	@Override
	public void changeCustomerMailByCustomerId(String newCustomerMail, Integer customerId) {
		String sql = "update customer set customerMail = ? WHERE customerId = ?";
		update(sql, newCustomerMail, customerId);
	}

	@Override
	public long countCreditCard(Integer creditCardId, Integer customerId) {
		String sql = "SELECT count(*) FROM customer WHERE creditCardId = ? AND customerId != ?";
		return getSingleVal(sql, creditCardId, customerId);
	}

	@Override
	public void changeCustomerCreditCardByCustomerId(Integer newCreditCardId, Integer customerId) {
		String sql = "update customer set creditCardId = ? WHERE customerId = ?";
		update(sql, newCreditCardId, customerId);
	}

	@Override
	public String getMailByCustomerId(Integer customerId) {
		String sql = "SELECT customerMail FROM customer WHERE customerId = ?";
		return getSingleVal(sql, customerId);
	}

	@Override
	public void changeCustomerPasswordByCustomerId(String newCustomerPassword, Integer customerId) {
		String sql = "UPDATE customer SET customerPassword = ? WHERE customerId = ?";
		update(sql, newCustomerPassword, customerId);
	}

	@Override
	public void changeDisplayPictureByCustomerId(String newDisplayPicture, Integer customerId) {
		String sql = "UPDATE customer SET displayPicture = ? WHERE customerId = ?";
		update(sql, newDisplayPicture, customerId);
	}

	@Override
	public Integer getCreditCardIdByCustomerId(Integer customerId) {
		String sql = "SELECT creditCardId FROM customer WHERE customerId = ?";
		return getSingleVal(sql, customerId);
	}

}
