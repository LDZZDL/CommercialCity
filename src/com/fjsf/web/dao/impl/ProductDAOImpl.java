package com.fjsf.web.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;

import com.fjsf.web.bean.ProductBean;
import com.fjsf.web.dao.ProductDAO;
import com.sun.mail.imap.Utility.Condition;

public class ProductDAOImpl extends BaseDAO<ProductBean>implements ProductDAO {
	
	/**
	 * searchValue:不可见字符皆为空(null)
	 * 
	 * priceRangeLeft:不为数字就为空
	 * priceRangeRight:不为数字就为空
	 * 
	 * 商品上架时间：Time ASC(TA)   Time DESC(TD)
	 * 商品价格： Price ASC(PA)	Price DESC(PD)
     * 商品数量： Quantity ASC(QA) Quantity DESC(QD)
	 */
	
	private String orderType(String orderType){
		String selectOrder = new String();
		if(orderType.equals("TA")){
			selectOrder = " ORDER BY shelfTime ASC ";
		}else if(orderType.equals("TD")){
			selectOrder = " ORDER BY shelfTime DESC ";
		}else if(orderType.equals("PA")){
			selectOrder = " ORDER BY productSale ASC ";
		}else if(orderType.equals("PD")){
			selectOrder = " ORDER BY productSale DESC ";
		}else if(orderType.equals("QA")){
			selectOrder = " ORDER BY productStock ASC";
		}else if(orderType.equals("QD")){
			selectOrder = " ORDER BY productStock DESC ";
		}
		return selectOrder;
	}
	
	private String getSearchValue(String searchValue){
		if(searchValue == null){
			searchValue = "%";
		}else{
			String temp = "%";
			for(int i = 0;i<searchValue.length();i++){
				temp += searchValue.substring(i, i+1) + "%";
			}
			searchValue = temp;
		}
		return searchValue;
	}
	
	@Override
	public List<ProductBean> getListsForProductByShopIdAndCondition(Integer shopId, 
			String searchValue, String orderType, Double priceRangeLeft, 
			Double priceRangeRight, Integer pageNo, Integer pageSize) {
		String sql = "SELECT productId,shopId,productName,productIntroduction,productSale,"
				+ "productStock,productClass,productShowPicture,productAttribute,"
				+ "writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
				+ "productIntroductionPictureTwo,productIntroductionPictureThree FROM product ";
		String conditionOne = " WHERE shopId = ? AND productName like ? ";
		String conditionTwo = " shopId = ? AND writer like ? ";
		searchValue = getSearchValue(searchValue);
		if(priceRangeLeft != null && priceRangeRight != null){
			if(priceRangeLeft.compareTo(priceRangeRight) > 0){
				Double temp = priceRangeRight;
				priceRangeRight = priceRangeLeft;
				priceRangeLeft = temp;
			}
			conditionOne += " AND productSale >= ? AND productSale <= ? ";
			conditionTwo += " AND productSale >= ? AND productSale <= ? ";
			conditionTwo += orderType(orderType);
			conditionTwo += " limit " + (pageNo-1)*pageSize + "," + (pageSize);
			sql += conditionOne + " OR " + conditionTwo;
			System.out.println(sql);
			return queryForList(sql, shopId, searchValue, priceRangeLeft, priceRangeRight, 
									shopId, searchValue, priceRangeLeft, priceRangeRight);
		}else if(priceRangeLeft == null && priceRangeRight != null){
			conditionOne += " AND productSale <= ? ";
			conditionTwo += " AND productSale <= ? ";
			conditionTwo += orderType(orderType);
			conditionTwo += " limit " + (pageNo-1)*pageSize + "," + (pageSize);
			sql += conditionOne + " OR " + conditionTwo;
			System.out.println(sql);
			return queryForList(sql, shopId, searchValue, priceRangeRight,
									shopId, searchValue, priceRangeLeft);
		}else if(priceRangeLeft != null && priceRangeRight == null){
			conditionOne += " AND productSale >= ? ";
			conditionTwo += " AND productSale >= ? ";
			conditionTwo += orderType(orderType);
			conditionTwo += " limit " + (pageNo-1)*pageSize + "," + (pageSize);
			sql += conditionOne + " OR " + conditionTwo;
			System.out.println(sql);
			return queryForList(sql, shopId, searchValue, priceRangeLeft,
									shopId, searchValue, priceRangeLeft);
		}else if(priceRangeLeft == null && priceRangeLeft == null){
			conditionTwo += orderType(orderType);
			conditionTwo += " limit " + (pageNo-1)*pageSize + "," + (pageSize);
			sql += conditionOne + " OR " + conditionTwo;
			System.out.println(sql);
			return queryForList(sql, shopId,searchValue, shopId, searchValue);
		}
		System.out.println("搜索失败");
		return null;
	}

	@Override
	public long countProductWithShopIdAndCondition(Integer shopId, String searchValue, String orderType,
			Double priceRangeLeft, Double priceRangeRight) {
		String sql = "SELECT count(*) FROM product ";
		String conditionOne = " WHERE shopId = ? AND productName like ? ";
		String conditionTwo = " shopId = ? AND writer like ? ";
		searchValue = getSearchValue(searchValue);
		if(priceRangeLeft != null && priceRangeRight != null){
			if(priceRangeLeft.compareTo(priceRangeRight) > 0){
				Double temp = priceRangeRight;
				priceRangeRight = priceRangeLeft;
				priceRangeLeft = temp;
			}
			conditionOne += " AND productSale >= ? AND productSale <= ? ";
			conditionTwo += " AND productSale >= ? AND productSale <= ? ";
			conditionTwo += orderType(orderType);
			sql += conditionOne + " OR " + conditionTwo;
			System.out.println(sql);
			return getSingleVal(sql, shopId, searchValue, priceRangeLeft, priceRangeRight, 
									shopId, searchValue, priceRangeLeft, priceRangeRight);
		}else if(priceRangeLeft == null && priceRangeRight != null){
			conditionOne += " AND productSale <= ? ";
			conditionTwo += " AND productSale <= ? ";
			conditionTwo += orderType(orderType);
			sql += conditionOne + " OR " + conditionTwo;
			System.out.println(sql);
			return getSingleVal(sql, shopId, searchValue, priceRangeRight,
									shopId, searchValue, priceRangeLeft);
		}else if(priceRangeLeft != null && priceRangeRight == null){
			conditionOne += " AND productSale >= ? ";
			conditionTwo += " AND productSale >= ? ";
			conditionTwo += orderType(orderType);
			sql += conditionOne + " OR " + conditionTwo;
			System.out.println(sql);
			return getSingleVal(sql, shopId, searchValue, priceRangeLeft,
									shopId, searchValue, priceRangeLeft);
		}else if(priceRangeLeft == null && priceRangeLeft == null){
			conditionTwo += orderType(orderType);
			sql += conditionOne + " OR " + conditionTwo;
			System.out.println(sql);
			return getSingleVal(sql, shopId,searchValue, shopId, searchValue);
		}
		System.out.println("搜索失败");
		return 0;
	}

	@Override
	public void deleteProductByProductId(Integer productId) {
		String sql = "DELETE FROM product WHERE productId = ?";
		update(sql, productId);
	}

	@Override
	public ProductBean getProductDetailMessage(Integer productId) {
		String sql = "SELECT productId,shopId,productName,productIntroduction,productSale,"
				+ "productStock,productClass,productShowPicture,productAttribute,"
				+ "writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
				+ "productIntroductionPictureTwo,productIntroductionPictureThree FROM product "
				+ "WHERE productId = ?";
		return query(sql, productId);
	}

	@Override
	public void changeProductForMessageByProductId(ProductBean productBean) {
		String sql = "UPDATE product set productName = ?,productIntroduction = ?,"
				+ "productSale = ?,productStock = ?,productClass = ?,"
				+ "productAttribute = ?,writer = ?,publishingHouse = ? WHERE productId = ?";
		update(sql, productBean.getProductName(), productBean.getProductIntroduction(),
					productBean.getProductSale(), productBean.getProductStock(),
					productBean.getProductClass(), productBean.getProductAttribute(),
					productBean.getWriter(), productBean.getPublishingHouse(), productBean.getProductId());
	}

	@Override
	public void changeProductForPictureByProductId(ProductBean productBean) {
		String sql = "UPDATE product set productShowPicture = ?,"
				+ "productIntroductionPictureOne = ?,"
				+ "productIntroductionPictureTwo = ?,"
				+ "productIntroductionPictureThree = ?"
				+ " WHERE productId = ?";
		update(sql, productBean.getProductShowPicture(),
					productBean.getProductIntroductionPictureOne(),
					productBean.getProductIntroductionPictureTwo(),
					productBean.getProductIntroductionPictureThree(),
					productBean.getProductId());
	}

	@Override
	public long addProductMessage(ProductBean productBean) {
		String sql = "INSERT INTO product(productId,shopId,productName,productIntroduction,"
				+ "productSale,productStock,productClass,productShowPicture,"
				+ "productAttribute,writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
				+ "productIntroductionPictureTwo,productIntroductionPictureThree) "
				+ " VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		productBean.setProductShowPicture("");
		productBean.setProductIntroductionPictureOne("");
		productBean.setProductIntroductionPictureTwo("");
		productBean.setProductIntroductionPictureThree("");
		return insert(sql, productBean.getShopId(), productBean.getProductName(), 
					productBean.getProductIntroduction(), productBean.getProductSale(), 
					productBean.getProductStock(), productBean.getProductClass(), 
					productBean.getProductShowPicture(),
					productBean.getProductAttribute(), productBean.getWriter(),
					productBean.getPublishingHouse(), productBean.getShelfTime(),
					productBean.getProductIntroductionPictureOne(),
					productBean.getProductIntroductionPictureTwo(),
					productBean.getProductIntroductionPictureThree()
					);
	}

	@Override
	public Integer getProductStockByProductId(Integer productId) {
		String sql = "SELECT productStock FROM product WHERE productId = ?";
		return getSingleVal(sql, productId);
	}

	@Override
	public void changeProductStockByProductId(Integer quantity, Integer productId) {
		Integer count = getProductStockByProductId(productId) - quantity;
		String sql = "UPDATE product set productStock = ? WHERE productId = ?";
		update(sql, count, productId);
	}

	@Override
	public List<ProductBean> getRecentProduct() {
		String sql = "SELECT productId,shopId,productName,productIntroduction,productSale,"
				+ "productStock,productClass,productShowPicture,productAttribute,"
				+ "writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
				+ "productIntroductionPictureTwo,productIntroductionPictureThree FROM product "
				+ " WHERE datediff(now(),shelftime) <= 600 limit 0,12";
		return queryForList(sql);
	}

	@Override
	public List<ProductBean> getInterestedProduct(List<String> listProductClass) {
		List<ProductBean> listProduct = new ArrayList<>();
		for(String str:listProductClass){
			String sql = "SELECT productId,shopId,productName,productIntroduction,productSale,"
					+ "productStock,productClass,productShowPicture,productAttribute,"
					+ "writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
					+ "productIntroductionPictureTwo,productIntroductionPictureThree FROM product ";
			sql += " WHERE productClass = '" + str + "' order by rand() LIMIT 0,";
			if(listProductClass.size() == 1){
				sql += 6 + "";
			}
			if(listProductClass.size() == 2){
				sql += 3 + "";
			}
			if(listProductClass.size() == 3){
				sql += 2 + "";
			}
			List<ProductBean> temp = queryForList(sql);
			for(ProductBean productBean:temp){
				listProduct.add(productBean);
			}
		}
		System.out.println(listProduct);
		return listProduct;
	}
	
	
	/**
	 * 商品销量： SalesVolume ASC(SVA)   SalesVolume DESC(SVD) 
	 * 商品价格： Price ASC(PA)	Price DESC(PD)
	 */
	
	private String getValidMoneyOrder(){
		return " RIGHT JOIN ordermaster ON(orderDetail.orderId = orderMaster.orderId "
				+ " AND (orderMasterStatus != '订单取消' OR orderMasterStatus != '待付款')) ";
	}
	
	private String getSearchClass(){
		return " AND productClass like ? ";
	}
	
	String getCustomerCondition(String orderType, Double priceRangeLeft, Double priceRangeRight,
			Integer pageNo, Integer pageSize){
		if(orderType.equals("SVA")){
			//return " LEFT JOIN orderDetail ON(product.productId = orderDetail.productId) "
			//		+ " WHERE productName like ? " + getPriceRange(priceRangeLeft, priceRangeRight)
			//		+ " GROUP BY product.productId ORDER BY sum(quantity) ASC " + getLimit(pageNo, pageSize);
			//=================================//
			return " LEFT JOIN orderDetail ON(product.productId = orderDetail.productId) " + getValidMoneyOrder() 
					+ " WHERE productName like ? " + getPriceRange(priceRangeLeft, priceRangeRight)
					+ " GROUP BY product.productId ORDER BY sum(quantity) ASC " + getLimit(pageNo, pageSize);
			//=================================//
		}
		if(orderType.equals("SVD")){
			//return " LEFT JOIN orderDetail ON(product.productId = orderDetail.productId) "
			//		+ " WHERE productName like ? " + getPriceRange(priceRangeLeft, priceRangeRight)
			//		+ " GROUP BY product.productId ORDER BY sum(quantity) DESC " + getLimit(pageNo, pageSize);
			//=======================================//
			return " LEFT JOIN orderDetail ON(product.productId = orderDetail.productId) " + getValidMoneyOrder()
					+ " WHERE productName like ? " + getPriceRange(priceRangeLeft, priceRangeRight)
					+ " GROUP BY product.productId ORDER BY sum(quantity) DESC " + getLimit(pageNo, pageSize);
			//=======================================//
		}
		if(orderType.equals("PA")){
			return " WHERE productName like ? " + getPriceRange(priceRangeLeft, priceRangeRight)
					+ " ORDER BY productSale ASC " + getLimit(pageNo, pageSize);
		}
		if(orderType.equals("PD")){
			return " WHERE productName like ? " + getPriceRange(priceRangeLeft, priceRangeRight)
					+ " ORDER BY productSale DESC " + getLimit(pageNo, pageSize);
		}
		return null;
	}
	
	private String getPriceRange(Double priceRangeLeft, Double priceRangeRight){
		if(priceRangeLeft == null && priceRangeRight != null){
			return " AND productSale <= ? ";
		}
		if(priceRangeLeft != null && priceRangeRight == null){
			return " AND productSale >= ? ";
		}
		if(priceRangeLeft != null && priceRangeRight != null){
			return " AND productSale >= ? AND productSale <= ? ";
		}
		return "";
	}
	
	private String getLimit(Integer pageNo, Integer pageSize){
		return " LIMIT "+ (pageNo-1)*pageSize + "," + pageSize;
	}
	
	private String getCustomerSearchValue(String searchValue){
		if(searchValue == null) return "%";
		return "%"+searchValue+"%";
	}
	
	private String getSearchClass(String searchValue){
		if(searchValue.equals("")){
			return "%";
		}
		if(searchValue.equals("全部分类")){
			return "%";
		}
		return searchValue;
	}
	
	@Override
	public List<ProductBean> customerGetProductWithCondition(String searchValue, String orderType,
			Double priceRangeLeft, Double priceRangeRight, Integer pageNo, Integer pageSize) {
		String sql = "SELECT product.productId,shopId,productName,productIntroduction,productSale,"
				+ "productStock,productClass,productShowPicture,productAttribute,"
				+ "writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
				+ "productIntroductionPictureTwo,productIntroductionPictureThree FROM product ";
		searchValue = getCustomerSearchValue(searchValue);
		String condition = getCustomerCondition(orderType, priceRangeLeft, priceRangeRight,
								pageNo, pageSize);
		if(priceRangeLeft == null && priceRangeRight == null){
			sql += condition;
			System.out.println(sql);
			return queryForList(sql, searchValue);
		}
		if(priceRangeLeft != null && priceRangeRight == null){
			sql += condition;
			System.out.println(sql);
			return queryForList(sql, searchValue, priceRangeLeft);
		}
		if(priceRangeLeft == null && priceRangeRight != null){
			sql += condition;
			System.out.println(sql);
			return queryForList(sql, searchValue, priceRangeRight);
		}
		if(priceRangeLeft != null && priceRangeRight != null){
			sql += condition;
			System.out.println(sql);
			if(priceRangeLeft.compareTo(priceRangeRight) > 0){
				Double temp = priceRangeRight;
				priceRangeRight = priceRangeLeft;
				priceRangeLeft = temp;
			}
			return queryForList(sql, searchValue, priceRangeLeft, priceRangeRight);
		}
		return null;
	}

	@Override
	public long countCustomerProductWithCondition(String searchValue, String orderType, 
			Double priceRangeLeft, Double priceRangeRight, 
			Integer pageNo, Integer pageSize) {
		String sql = "SELECT count(*) FROM product WHERE productName like ?" 
			+ getPriceRange(priceRangeLeft, priceRangeRight);
		String SearchValue = getCustomerSearchValue(searchValue);
		if(priceRangeLeft == null && priceRangeRight == null){
			return getSingleVal(sql, SearchValue);
		}
		if(priceRangeLeft != null && priceRangeRight == null){
			return getSingleVal(sql, SearchValue, priceRangeLeft);
		}
		if(priceRangeLeft == null && priceRangeRight != null){
			return getSingleVal(sql, SearchValue, priceRangeRight);
		}
		if(priceRangeLeft != null && priceRangeRight != null){
			if(priceRangeLeft.compareTo(priceRangeRight) > 0){
				Double temp = priceRangeRight;
				priceRangeRight = priceRangeLeft;
				priceRangeLeft = temp;
			}
			return getSingleVal(sql, SearchValue, priceRangeLeft, priceRangeRight);
		}
		return 0;
	}

	@Override
	public Integer getShopIdByProductId(Integer productId) {
		String sql = "SELECT shopId FROM product WHERE productId = ?";
		return getSingleVal(sql, productId);
	}

	@Override
	public List<ProductBean> getShoppingCartProductAssociateShopId(Integer customerId) {
		String sql = "SELECT product.productId,shopId,productName,productIntroduction,productSale,"
				+ "productStock,productClass,productShowPicture,productAttribute,"
				+ "writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
				+ "productIntroductionPictureTwo,productIntroductionPictureThree FROM shoppingCartProduct INNER JOIN product "
				+ " ON(product.productId=shoppingCartProduct.productId) WHERE "
				+ " customerId = ? GROUP BY shopId ORDER BY time DESC";
		return queryForList(sql, customerId);
	}

	@Override
	public List<ProductBean> getShoppingCartProductMessageByShopId(Integer shopId) {
		String sql = "SELECT product.productId,shopId,productName,productIntroduction,productSale,"
				+ "productStock,productClass,productShowPicture,productAttribute,"
				+ "writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
				+ "productIntroductionPictureTwo,productIntroductionPictureThree FROM shoppingCartProduct INNER JOIN product "
				+ " ON(product.productId=shoppingCartProduct.productId) WHERE "
				+ " shopId = ? ORDER BY time DESC";
		return queryForList(sql, shopId);
	}

	@Override
	public void addProductStockByProductId(Integer quantity, Integer productId) {
		Integer count = getProductStockByProductId(productId) + quantity;
		String sql = "UPDATE product set productStock = ? WHERE productId = ?";
		update(sql, count, productId);
	}

	String getCustomerConditionWithSearchClass(String orderType,String searchClass,
			Double priceRangeLeft, Double priceRangeRight,
			Integer pageNo, Integer pageSize){
		if(orderType.equals("SVA")){
			return " LEFT JOIN orderDetail ON(product.productId = orderDetail.productId) " + getValidMoneyOrder() 
					+ " WHERE productName like ? "+ getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight)
					+ " GROUP BY product.productId ORDER BY sum(quantity) ASC " + getLimit(pageNo, pageSize);
		}
		if(orderType.equals("SVD")){
			return " LEFT JOIN orderDetail ON(product.productId = orderDetail.productId) " + getValidMoneyOrder()
					+ " WHERE productName like ? " + getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight)
					+ " GROUP BY product.productId ORDER BY sum(quantity) DESC " + getLimit(pageNo, pageSize);
		}
		if(orderType.equals("PA")){
			return " WHERE productName like ? " + getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight)
					+ " ORDER BY productSale ASC " + getLimit(pageNo, pageSize);
		}
		if(orderType.equals("PD")){
			return " WHERE productName like ? " + getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight)
					+ " ORDER BY productSale DESC " +  getLimit(pageNo, pageSize);
		}
		return " WHERE productName like ? " + getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight)
		 		+  getLimit(pageNo, pageSize); 
	}
	
	
	
	
	@Override
	public List<ProductBean> customerGetProductWithCondition(String searchValue, String orderType, String searchClass,
			Double priceRangeLeft, Double priceRangeRight, Integer pageNo, Integer pageSize) {
		String sql = "SELECT product.productId,shopId,productName,productIntroduction,productSale,"
				+ "productStock,productClass,productShowPicture,productAttribute,"
				+ "writer,publishingHouse,shelfTime,productIntroductionPictureOne,"
				+ "productIntroductionPictureTwo,productIntroductionPictureThree FROM product ";
		searchValue = getCustomerSearchValue(searchValue);
		searchClass = getSearchClass(searchClass);
		String condition = getCustomerConditionWithSearchClass(orderType, searchClass, 
				priceRangeLeft, priceRangeRight, pageNo, pageSize);
		if(priceRangeLeft == null && priceRangeRight == null){
			sql += condition;
			System.out.println(sql);
			return queryForList(sql, searchValue, searchClass);
		}
		if(priceRangeLeft != null && priceRangeRight == null){
			sql += condition;
			System.out.println(sql);
			return queryForList(sql, searchValue, searchClass, priceRangeLeft);
		}
		if(priceRangeLeft == null && priceRangeRight != null){
			sql += condition;
			System.out.println(sql);
			return queryForList(sql, searchValue, searchClass, priceRangeRight);
		}
		if(priceRangeLeft != null && priceRangeRight != null){
			sql += condition;
			System.out.println(sql);
			if(priceRangeLeft.compareTo(priceRangeRight) > 0){
				Double temp = priceRangeRight;
				priceRangeRight = priceRangeLeft;
				priceRangeLeft = temp;
			}
			return queryForList(sql, searchValue, searchClass, priceRangeLeft, priceRangeRight);
		}
		return null;
	}

	private String getCountCustomerConditionWithSearchClass(String orderType,String searchClass,
			Double priceRangeLeft, Double priceRangeRight){
		if(orderType.equals("SVA")){
			return " LEFT JOIN orderDetail ON(product.productId = orderDetail.productId) " + getValidMoneyOrder() 
					+ " WHERE productName like ? "+ getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight);
		}
		if(orderType.equals("SVD")){
			return " LEFT JOIN orderDetail ON(product.productId = orderDetail.productId) " + getValidMoneyOrder()
					+ " WHERE productName like ? " + getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight);
		}
		if(orderType.equals("PA")){
			return " WHERE productName like ? " + getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight);
		}
		if(orderType.equals("PD")){
			return " WHERE productName like ? " + getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight);
		}
		return " WHERE productName like ? " + getSearchClass() + getPriceRange(priceRangeLeft, priceRangeRight);
	}
	
	@Override
	public long countCustomerProductWithCondition(String searchValue, String orderType, String searchClass,
			Double priceRangeLeft, Double priceRangeRight, Integer pageNo, Integer pageSize) {
		/* 可以恢复
		String sql = "SELECT count(*) FROM product WHERE productName like ?" + getSearchClass()
				+ getPriceRange(priceRangeLeft, priceRangeRight);
		*/
		//======================可以删除=========================//
		String sql = "SELECT count(distinct product.productId) FROM product " + getCountCustomerConditionWithSearchClass(orderType, 
				searchClass, priceRangeLeft, priceRangeRight);
		//======================================================//
		String SearchValue = getCustomerSearchValue(searchValue);
		String SearchClass = getSearchClass(searchClass);
		System.out.println("搜索的值" + SearchValue);
		System.out.println("搜索的分类 " + SearchClass);
		if (priceRangeLeft == null && priceRangeRight == null) {
			System.out.println(sql);
			return getSingleVal(sql, SearchValue, SearchClass);
		}
		if (priceRangeLeft != null && priceRangeRight == null) {
			return getSingleVal(sql, SearchValue, SearchClass, priceRangeLeft);
		}
		if (priceRangeLeft == null && priceRangeRight != null) {
			return getSingleVal(sql, SearchValue, SearchClass, priceRangeRight);
		}
		if (priceRangeLeft != null && priceRangeRight != null) {
			if (priceRangeLeft.compareTo(priceRangeRight) > 0) {
				Double temp = priceRangeRight;
				priceRangeRight = priceRangeLeft;
				priceRangeLeft = temp;
			}
			return getSingleVal(sql, SearchValue, SearchClass, priceRangeLeft, priceRangeRight);
		}
		return 0;
	}

	private String getSaleOrderType(String orderType){
		if(orderType.equals("SVD")){
			return " ORDER BY sum(quantity) DESC ";
		}
		if(orderType.equals("SVA")){
			return " ORDER BY sum(quantity) ASC ";
		}
		return null;
	}
	
	private String getDay(Integer day){
		if(day == null) return "";
		return "  AND datediff(now(),orderMasterTime) <= ? ";
	}
	
	@Override
	public List<ProductBean> getProductBySale(Integer shopId, String orderType, Integer day, Integer pageNo,
			Integer pageSize) {
		String sql = "SELECT product.productId,shopId,productName,productIntroduction,productSale, "
				+ " productStock,productClass,productShowPicture,productAttribute, "
				+ " writer,publishingHouse,shelfTime,productIntroductionPictureOne, "
				+ " productIntroductionPictureTwo,productIntroductionPictureThree FROM product "
				+ " INNER JOIN orderDetail ON(product.productId = orderDetail.productId) "
				+ " INNER JOIN orderMaster ON(orderDetail.orderId = orderMaster.orderId) "
				+ " WHERE shopId = ? AND orderMasterStatus != '订单取消' "
				+ " AND orderMasterStatus != '待付款' AND orderMasterStatus != '待发货'" + getDay(day)
				+ " GROUP BY product.productId " + getSaleOrderType(orderType)
				+ getLimit(pageNo, pageSize);
		if(day == null) return queryForList(sql, shopId);
		return queryForList(sql, shopId, day);
	}

	@Override
	public long countProductBySale(Integer shopId, String orderType, Integer day) {
		String sql = "SELECT count(*) FROM product "
				+ " INNER JOIN orderDetail ON(product.productId = orderDetail.productId) "
				+ " INNER JOIN orderMaster ON(orderDetail.orderId = orderMaster.orderId) "
				+ " WHERE shopId = ? AND orderMasterStatus != '订单取消' "
				+ " AND orderMasterStatus != '待付款' " + getDay(day)
				+ " GROUP BY product.productId ";
		if(day == null) return getSingleVal(sql, shopId);
		return getSingleVal(sql, shopId, day);
	}

	@Override
	public long getProductQuantityByProductId(Integer productId, String orderType, Integer day) {
		String sql = "SELECT sum(quantity) FROM product "
				+ " INNER JOIN orderDetail ON(product.productId = orderDetail.productId) "
				+ " INNER JOIN orderMaster ON(orderDetail.orderId = orderMaster.orderId) "
				+ " WHERE product.productId = ? AND orderMasterStatus != '订单取消' "
				+ " AND orderMasterStatus != '待付款' " + getDay(day)
				+ " GROUP BY product.productId " + getSaleOrderType(orderType);
		if(day == null){
			BigDecimal bigDecimal = getSingleVal(sql, productId);
			return bigDecimal.intValue();
		}
		BigDecimal bigDecimal = getSingleVal(sql, productId, day);
		return bigDecimal.intValue();
	}
}
