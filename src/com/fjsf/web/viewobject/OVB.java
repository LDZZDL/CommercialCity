package com.fjsf.web.viewobject;


public class OVB {
	
	// 店铺编号
	private int shopId;
	// 商家编号即店主编号
	private int shopperId;
	// 商店名称
	private String shopName;
	// 商店简介
	private String introduction;
	// 开店日期
	private String openDate;
	// 头像(头像文件存储路径)
	private String shopDisplayPicture;
	// 好评率
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

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getShopDisplayPicture() {
		return shopDisplayPicture;
	}

	public void setShopDisplayPicture(String shopDisplayPicture) {
		this.shopDisplayPicture = shopDisplayPicture;
	}

	public double getGoodRate() {
		return goodRate;
	}

	public void setGoodRate(double goodRate) {
		this.goodRate = goodRate;
	}

	@Override
	public String toString() {
		return "OVB [shopId=" + shopId + ", shopperId=" + shopperId + ", shopName=" + shopName + ", introduction="
				+ introduction + ", openDate=" + openDate + ", shopDisplayPicture=" + shopDisplayPicture + ", goodRate="
				+ goodRate + "]";
	}

	public OVB(int shopId, int shopperId, String shopName, String introduction, String openDate,
			String shopDisplayPicture, double goodRate) {
		super();
		this.shopId = shopId;
		this.shopperId = shopperId;
		this.shopName = shopName;
		this.introduction = introduction;
		this.openDate = openDate;
		this.shopDisplayPicture = shopDisplayPicture;
		this.goodRate = goodRate;
	}

	public OVB() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
