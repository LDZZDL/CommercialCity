package com.fjsf.web.dao;

import com.fjsf.web.bean.ShopperBean;
/**
 * 定义数据库中商家信息表的操作接口
 * @author lin
 */
public interface ShopperDAO {
	
	/**
	 * 注册卖家
	 * @param shopepr包含卖家信息
	 */
	void register(ShopperBean shopper);
	/**
	 * 判断shopper数据库中是否有账号等于account的商家
	 * @param account 
	 * @return shopper(商家)数据库中与account账号相同的商家数量
	 */
	long countAccount(String account);
	/**
	 * 判断shopper数据库中是否有邮箱等于mail的商家
	 * @param mail
	 * @return shopper(商家)数据库中与mail邮箱账号相同的商家数量
	 */
	long countMail(String mail);
	/**
	 * 判断shopper数据库中是否有身份证号等于idCard的商家
	 * @param idCard
	 * @return shopper(商家)数据库中与idCard身份证相同的商家数量
	 */
	long countIdCard(String idCard);
	/**
	 * 判断shopper数据库中是否有名称等于onlineName的商家
	 * @param onlineName
	 * @return shopper(商家)数据库中与onlineName名称相同的商家数量
	 */
	long countOnlineName(String onlineName);
	/**
	 * 判断shopper数据库中是否有名称等于creditCardId的商家
	 * @param creditCard 
	 * @return shopper(商家)数据库中 与creditCard相同的商家数量
	 */
	long countCrditCard(Integer creditCardId);
	/**
	 * 判断登录商家信息正确性
	 * @return false:登录信息错误 true:登录信息正确
	 */
	boolean loginShopper(String account, String password);
	/**
	 * 通过账号修改修改商家密码
	 * @param account
	 */
	void changePasswordByAccount(String account, String newPassword);
	/**
	 * 通过输入账号返回绑定邮箱
	 * @param account 输入商家账号
	 * @return 邮箱
	 */
	String getMailByAccount(String account);
	/**
	 * 通过商家账号查找商家编号
	 * @param account 商家账号
	 * @return 商家ID
	 */
	Integer getShopperIdByAccount(String account);
	/**
	 * 通过商家编号获取商家信息
	 * @param shopperId 商家编号
	 * @return 商家信息
	 */
	ShopperBean getShopperByShopperId(Integer shopperId);
	//=========================黄宁===================================//
	/**
	 * 通过商家编号获取绑定邮箱
	 * @param ShopperId
	 * @return 绑定邮箱
	 */
	String getMailByShopperId(Integer shopperId);
	
	/**
	 * 通过商家编号修改名字
	 * @param shopperId 商家编号
	 * @param newShopperName 商家名称
	 */
	void changeShopperNameByShopperId(String newShopperName,Integer shopperId);

	/**
	 * 通过商家编号修改密码
	 * @param shopperId 商家编号
	 * @param newShopperPassword 商家密码
	 */
	void changeShopperPasswordByShopperId(String newShopperPassword,Integer shopperId);

	/**
	 * 通过商家编号修改邮箱
	 * @param ShopperId 商家编号
	 * @param newMail 商家邮箱
	 */
	void changeMailByShopperId(String newMail,Integer shopperId);

	/**
	 * 通过商家编号修改头像
	 * @param shopperId 商家编号
	 * @param newDisplayPicture 商家头像
	 */
	void changeDisplayPictureByShopperId(String newDisplayPicture,Integer shopperId);

	/**
	 * 通过商家编号修改信用卡编号
	 * @param shopperId 商家编号
	 * @param creditCardId 信用卡编号
	 */
	void changeCreditCardIdByShopperId(Integer creditCardId,Integer shopperId);
	/**
	 * 判断shopper数据库中是否有名称等于onlineName的商家
	 * @param onlineName
	 * @return shopper(商家)数据库中与onlineName名称相同的商家数量
	 */
	long countOnlineName(String onlineName,Integer shopperId);
	//=========================黄宁===================================//
	/**
	 * 通过商家编号获取信用卡编号
	 * @param shopperId 商家编号
	 * @return
	 */
	Integer getCreditCardIdByShopperId(Integer shopperId);
}
