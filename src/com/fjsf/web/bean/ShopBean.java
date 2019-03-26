package com.fjsf.web.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ShopBean {
	
	//店铺编号
	private int shopId;
	//商家编号即店主编号
	private int shopperId;
	//商店名称
	private String shopName;
	//商店简介
	private String introduction;
	//开店日期
	@JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分",timezone="GMT+8")
	private Date openDate;
	//头像(头像文件存储路径)
	private String displayPicture;
	//好评率
	private double goodRate;
	
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getShopperId() {
		return shopperId;
	}

	public void setShopperId(int shopperId) {
		this.shopperId = shopperId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getDisplayPicture() {
		return displayPicture;
	}

	public void setDisplayPicture(String displayPicture) {
		this.displayPicture = displayPicture;
	}

	public double getGoodRate() {
		return goodRate;
	}

	public void setGoodRate(double goodRate) {
		this.goodRate = goodRate;
	}

	@Override
	public String toString() {
		return "ShopBean [shopId=" + shopId + ", shopperId=" + shopperId + ", shopName=" + shopName + ", introdction="
				+ introduction + ", openDate=" + openDate + ", displayPicture=" + displayPicture + ", goodRate="
				+ goodRate + "]";
	}

	public ShopBean(int shopId, int shopperId, String shopName, String introduction, Date openDate, String displayPicture,
			double goodRate) {
		super();
		this.shopId = shopId;
		this.shopperId = shopperId;
		this.shopName = shopName;
		this.introduction = introduction;
		this.openDate = openDate;
		this.displayPicture = displayPicture;
		this.goodRate = goodRate;
	}

	public ShopBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
