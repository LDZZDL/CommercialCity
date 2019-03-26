package com.fjsf.web.viewobject;

import java.util.List;

import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.bean.ShopBean;

public class ShoppingCartProductView {
	
	// 商店信息
	private ShopBean shopBean;
	// 产品信息
	private List<ProductBean> listProductBean;
	//产品数量
	private List<Integer> listQuantity;

	public ShopBean getShopBean() {
		return shopBean;
	}

	public void setShopBean(ShopBean shopBean) {
		this.shopBean = shopBean;
	}

	public List<ProductBean> getListProductBean() {
		return listProductBean;
	}

	public void setListProductBean(List<ProductBean> listProductBean) {
		this.listProductBean = listProductBean;
	}

	public List<Integer> getListQuantity() {
		return listQuantity;
	}

	public void setListQuantity(List<Integer> listQuantity) {
		this.listQuantity = listQuantity;
	}

	@Override
	public String toString() {
		return "ShoppingCartProductView [shopBean=" + shopBean + ", listProductBean=" + listProductBean
				+ ", listQuantity=" + listQuantity + "]";
	}

	public ShoppingCartProductView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoppingCartProductView(ShopBean shopBean, List<ProductBean> listProductBean, List<Integer> listQuantity) {
		super();
		this.shopBean = shopBean;
		this.listProductBean = listProductBean;
		this.listQuantity = listQuantity;
	}
}
