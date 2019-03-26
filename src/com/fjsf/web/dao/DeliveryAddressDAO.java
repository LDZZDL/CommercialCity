package com.fjsf.web.dao;

import java.util.List;

import com.fjsf.web.bean.DeliveryAddressBean;

public interface DeliveryAddressDAO {
	/**
	 * 通过用户编号获取用户的收货地址
	 * @param customerId 用户编号
	 * @return 收货地址的集合
	 */
	List<DeliveryAddressBean> getDeliveryAddressByCustomerId(Integer customerId);
	/**
	 * 新增收货地址
	 * @param deliveryAddressBean 收货地址
	 */
	void addDeliveryAddress(DeliveryAddressBean deliveryAddressBean);
	/**
	 * 通过收货地址编号修改收货地址
	 * @param deliveryAddressBean 收货地址
	 */
	void changeDeliveryAddressByDeliveryAddressId(DeliveryAddressBean deliveryAddressBean);
	/**
	 * 通过收货地址编号删除收货地址
	 * @param deliveryAddressId 收货地址
	 */
	void deleteDeliveryAddressByDeliveryAddressId(Integer deliveryAddressId);
	/**
	 * 通过收货地址编号获取收货地址信息
	 * @param deliveryAddressId 收货地址编号
	 * @return
	 */
	DeliveryAddressBean getDeliveryAddressByDeliveryAddressId(Integer deliveryAddressId);
}
