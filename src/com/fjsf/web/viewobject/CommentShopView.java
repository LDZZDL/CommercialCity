package com.fjsf.web.viewobject;

import java.util.List;

import com.fjsf.web.bean.CommentBean;
import com.fjsf.web.bean.ProductBean;

public class CommentShopView {
	
	// 产品信息
	private ProductBean productBean;
	// 评论信息
	private List<CommentBean> listCommentBean;

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public List<CommentBean> getListCommentBean() {
		return listCommentBean;
	}

	public void setListCommentBean(List<CommentBean> listCommentBean) {
		this.listCommentBean = listCommentBean;
	}

	public CommentShopView(ProductBean productBean, List<CommentBean> listCommentBean) {
		super();
		this.productBean = productBean;
		this.listCommentBean = listCommentBean;
	}

	public CommentShopView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommentShopView [productBean=" + productBean + ", listCommentBean=" + listCommentBean + "]";
	}
}
