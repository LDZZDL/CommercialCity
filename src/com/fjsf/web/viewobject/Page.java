package com.fjsf.web.viewobject;

public class Page {
	
	// 页数
	private Integer pageNo;
	// 页面大小
	private Integer pageSize = 5;
	// 总页数
	private Integer totalPageNo;
	// 总数量
	private Integer totalNumber;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPageNo() {
		return totalPageNo;
	}

	public void setTotalPageNo(Integer totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Page(Integer pageNo, Integer pageSize, Integer totalPageNo, Integer totalNumber) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalPageNo = totalPageNo;
		this.totalNumber = totalNumber;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalPageNo=" + totalPageNo + ", totalNumber="
				+ totalNumber + "]";
	}
	
	
}
