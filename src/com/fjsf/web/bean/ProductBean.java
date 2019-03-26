package com.fjsf.web.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductBean {
	
	
	
	//产品名称
	private String productName;
	//作者
	private String writer;
	//销售价格
	private double productSale;
	//销售库存
	private int productStock;
	//上架时间
	@JsonFormat(pattern = "yyyy年MM月dd日")
	private Date shelfTime;
	//产品编号
	private int productId;
	//产品介绍
	private String productIntroduction;
	//商店编号
	private int shopId;
	//产品类别
	private String productClass;
	//产品显示图片
	private String productShowPicture;
	//产品参数
	private String productAttribute;
	//出版社
	private String publishingHouse;
	//产品介绍图片
	private String productIntroductionPictureOne;
	//产品介绍图片
	private String productIntroductionPictureTwo;
	//产品介绍图片
	private String productIntroductionPictureThree;

	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public double getProductSale() {
		return productSale;
	}

	public void setProductSale(double productSale) {
		this.productSale = productSale;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public Date getShelfTime() {
		return shelfTime;
	}

	public void setShelfTime(Date shelfTime) {
		this.shelfTime = shelfTime;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductIntroduction() {
		return productIntroduction;
	}

	public void setProductIntroduction(String productIntroduction) {
		this.productIntroduction = productIntroduction;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}

	public String getProductShowPicture() {
		return productShowPicture;
	}

	public void setProductShowPicture(String productShowPicture) {
		this.productShowPicture = productShowPicture;
	}

	public String getProductAttribute() {
		return productAttribute;
	}

	public void setProductAttribute(String productAttribute) {
		this.productAttribute = productAttribute;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public String getProductIntroductionPictureOne() {
		return productIntroductionPictureOne;
	}

	public void setProductIntroductionPictureOne(String productIntroductionPictureOne) {
		this.productIntroductionPictureOne = productIntroductionPictureOne;
	}

	public String getProductIntroductionPictureTwo() {
		return productIntroductionPictureTwo;
	}

	public void setProductIntroductionPictureTwo(String productIntroductionPictureTwo) {
		this.productIntroductionPictureTwo = productIntroductionPictureTwo;
	}

	public String getProductIntroductionPictureThree() {
		return productIntroductionPictureThree;
	}

	public void setProductIntroductionPictureThree(String productIntroductionPictureThree) {
		this.productIntroductionPictureThree = productIntroductionPictureThree;
	}

	public ProductBean(int productId, int shopId, String productName, String productIntroduction, double productSale,
			int productStock, String productClass, String productShowPicture, String productAttribute, String writer,
			String publishingHouse, Date shelfTime, String productIntroductionPictureOne,
			String productIntroductionPictureTwo, String productIntroductionPictureThree) {
		super();
		this.productId = productId;
		this.shopId = shopId;
		this.productName = productName;
		this.productIntroduction = productIntroduction;
		this.productSale = productSale;
		this.productStock = productStock;
		this.productClass = productClass;
		this.productShowPicture = productShowPicture;
		this.productAttribute = productAttribute;
		this.writer = writer;
		this.publishingHouse = publishingHouse;
		this.shelfTime = shelfTime;
		this.productIntroductionPictureOne = productIntroductionPictureOne;
		this.productIntroductionPictureTwo = productIntroductionPictureTwo;
		this.productIntroductionPictureThree = productIntroductionPictureThree;
	}

	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", shopId=" + shopId + ", productName=" + productName
				+ ", productIntroduction=" + productIntroduction + ", productSale=" + productSale + ", productStock="
				+ productStock + ", productClass=" + productClass + ", productShowPicture=" + productShowPicture
				+ ", productAttribute=" + productAttribute + ", writer=" + writer + ", publishingHouse="
				+ publishingHouse + ", shelfTime=" + shelfTime + ", productIntroductionPictureOne="
				+ productIntroductionPictureOne + ", productIntroductionPictureTwo=" + productIntroductionPictureTwo
				+ ", productIntroductionPictureThree=" + productIntroductionPictureThree + "]\n";
	}
	
	
}
