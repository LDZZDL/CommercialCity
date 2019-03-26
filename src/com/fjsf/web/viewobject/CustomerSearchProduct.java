package com.fjsf.web.viewobject;

public class CustomerSearchProduct {
	// 当前页数
	private int pageNo;
	// 每页显示多少条记录
	private int pageSize = 5;
	// 共有多少条记录
	private long totalProductNumber;
	// 总页数
	private long totalPageNo;
	// 搜索条件
	private String searchValue;
	// 排序类型
	private String orderType;
	// 价格左边界
	private Double priceRangeLeft;
	// 价格右边界
	private Double priceRangeRight;
	// 搜索类型
	private String searchClass;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalProductNumber() {
		return totalProductNumber;
	}

	public void setTotalProductNumber(long totalProductNumber) {
		this.totalProductNumber = totalProductNumber;
	}

	public long getTotalPageNo() {
		return totalPageNo;
	}

	public void setTotalPageNo(long totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Double getPriceRangeLeft() {
		return priceRangeLeft;
	}

	public void setPriceRangeLeft(Double priceRangeLeft) {
		this.priceRangeLeft = priceRangeLeft;
	}

	public Double getPriceRangeRight() {
		return priceRangeRight;
	}

	public void setPriceRangeRight(Double priceRangeRight) {
		this.priceRangeRight = priceRangeRight;
	}

	public String getSearchClass() {
		return searchClass;
	}

	public void setSearchClass(String searchClass) {
		this.searchClass = searchClass;
	}

	public CustomerSearchProduct(int pageNo, int pageSize, long totalProductNumber, long totalPageNo,
			String searchValue, String orderType, Double priceRangeLeft, Double priceRangeRight, String searchClass) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalProductNumber = totalProductNumber;
		this.totalPageNo = totalPageNo;
		this.searchValue = searchValue;
		this.orderType = orderType;
		this.priceRangeLeft = priceRangeLeft;
		this.priceRangeRight = priceRangeRight;
		this.searchClass = searchClass;
	}

	public CustomerSearchProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerSearchProduct [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalProductNumber="
				+ totalProductNumber + ", totalPageNo=" + totalPageNo + ", searchValue=" + searchValue + ", orderType="
				+ orderType + ", priceRangeLeft=" + priceRangeLeft + ", priceRangeRight=" + priceRangeRight
				+ ", searchClass=" + searchClass + "]";
	}
}
