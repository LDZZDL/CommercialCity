package com.fjsf.web.viewobject;

import java.util.List;

public class CommentView {
	
	//评论星级
	private List<Integer> listRate;
	//评论内容
	private List<String> listContent;
	//产品编号
	private List<Integer> listProductId;

	public List<Integer> getListRate() {
		return listRate;
	}

	public void setListRate(List<Integer> listRate) {
		this.listRate = listRate;
	}

	public List<String> getListContent() {
		return listContent;
	}

	public void setListContent(List<String> listContent) {
		this.listContent = listContent;
	}

	public List<Integer> getListProductId() {
		return listProductId;
	}

	public void setListProductId(List<Integer> listProductId) {
		this.listProductId = listProductId;
	}

	public CommentView(List<Integer> listRate, List<String> listContent, List<Integer> listProductId) {
		super();
		this.listRate = listRate;
		this.listContent = listContent;
		this.listProductId = listProductId;
	}

	public CommentView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommentView [listRate=" + listRate + ", listContent=" + listContent + ", listProductId=" + listProductId
				+ "]";
	}
}
