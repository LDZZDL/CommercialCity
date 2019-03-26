package com.fjsf.web.dao.impl;

import java.util.List;

import com.fjsf.web.bean.DeliveryAddressBean;
import com.fjsf.web.dao.DeliveryAddressDAO;

public class DeliveryAddressDAOImpl extends BaseDAO<DeliveryAddressBean> implements DeliveryAddressDAO{

	@Override
	public List<DeliveryAddressBean> getDeliveryAddressByCustomerId(Integer customerId) {
		String sql = "SELECT deliveryAddressId,customerId,receiverName,"
				+ "receiverTelephone,receiverAddressFirst,receiverAddressSecond,"
				+ "receiverAddressThird,receiverAddressDetail FROM deliveryAddress WHERE "
				+ "customerId = ?";
		return queryForList(sql, customerId);
	}

	@Override
	public void addDeliveryAddress(DeliveryAddressBean deliveryAddressBean) {
		String sql = "INSERT INTO deliveryAddress(customerId, receiverName,"
				+ "receiverTelephone,receiverAddressFirst,receiverAddressSecond,"
				+ "receiverAddressThird,receiverAddressDetail) VALUES(?,?,?,?,?,?,?)";
		insert(sql, deliveryAddressBean.getCustomerId(),
					deliveryAddressBean.getReceiverName(),
					deliveryAddressBean.getReceiverTelephone(),
					deliveryAddressBean.getReceiverAddressFirst(),
					deliveryAddressBean.getReceiverAddressSecond(),
					deliveryAddressBean.getReceiverAddressThird(),
					deliveryAddressBean.getReceiverAddressDetail());
	}

	@Override
	public void changeDeliveryAddressByDeliveryAddressId(DeliveryAddressBean deliveryAddressBean) {
		String sql = "UPDATE deliveryaddress SET receiverName = ?,receiverTelephone = ?,"
				+ "receiverAddressFirst = ?,receiverAddressSecond = ?,receiverAddressThird = ?,"
				+ "receiverAddressDetail = ? WHERE deliveryAddressId = ?";
		update(sql, deliveryAddressBean.getReceiverName(), deliveryAddressBean.getReceiverTelephone(),
					deliveryAddressBean.getReceiverAddressFirst(), deliveryAddressBean.getReceiverAddressSecond(), 
					deliveryAddressBean.getReceiverAddressThird(), deliveryAddressBean.getReceiverAddressDetail(),
					deliveryAddressBean.getDeliveryAddressId());
	}

	@Override
	public void deleteDeliveryAddressByDeliveryAddressId(Integer deliveryAddressId) {
		String sql = "DELETE FROM deliveryAddress WHERE deliveryAddressId = ?";
		update(sql, deliveryAddressId);
	}

	@Override
	public DeliveryAddressBean getDeliveryAddressByDeliveryAddressId(Integer deliveryAddressId) {
		String sql = "SELECT deliveryAddressId,customerId,receiverName,"
				+ "receiverTelephone,receiverAddressFirst,receiverAddressSecond,"
				+ "receiverAddressThird,receiverAddressDetail FROM deliveryAddress WHERE "
				+ "deliveryAddressId = ?";
		return query(sql, deliveryAddressId);
	}
	
}
