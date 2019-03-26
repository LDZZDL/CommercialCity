package com.fjsf.web.dao;

import java.util.List;

import com.fjsf.web.bean.OrderMasterBean;
import com.fjsf.web.bean.ProductBean;

/**
 * 定义数据库中商商品信息表的操作接口
 * @author lin
 */
public interface ProductDAO {
	
	/**
	 * 商品上架时间：Time ASC(TA)   Time DESC(TD)
	 * 商品价格： Price ASC(PA)	Price DESC(PD)
	 * 商品数量： Quantity ASC(QA) Quantity DESC(QD)
	 */
	/**
	 * 通过商店编号和搜索条件获取商品信息
	 * @param shopId 商店编号
	 * @param searchValue 搜索条件
	 * @param orderType 排序类型
	 * @param priceRangeLeft 价格左范围
	 * @param priceRangeRight 价格右范围
	 * @param pageNo 页数
	 * @param pageSize 页面包含产品个数
	 * @return 产品信息
	 */
	List<ProductBean> getListsForProductByShopIdAndCondition(Integer shopId, String searchValue, String orderType,
			Double priceRangeLeft, Double priceRangeRight, Integer pageNo, Integer pageSize);
	/**
	 * 通过商品编号和搜索条件获取商品数量
	 * @param shopId 商店编号
	 * @param searchValue 搜索条件
	 * @param orderType 排序类型
	 * @param priceRangeLeft 价格左范围
	 * @param priceRangeRight 价格右范围
	 * @return 个数
	 */
	long countProductWithShopIdAndCondition(Integer shopId, String searchValue, String orderType,
			Double priceRangeLeft, Double priceRangeRight);
	/**
	 * 根据商品编号修改商品信息
	 * @param productBean
	 */
	void changeProductForMessageByProductId(ProductBean productBean);
	/**
	 * 根据店铺编号修改商品图片
	 * @param productBean
	 */
	void changeProductForPictureByProductId(ProductBean productBean);
	/**
	 * 通过商品编号删除商品
	 * @param productId 商品编号
	 */
	void deleteProductByProductId(Integer productId);
	/**
	 * 按照商品编号获取商品详细信息
	 * @param productId 商品编号
	 * @return
	 */
	ProductBean getProductDetailMessage(Integer productId);
	/**
	 * 增加商品信息
	 * @param productBean
	 */
	long addProductMessage(ProductBean productBean);
	/**
	 * 获取商品库存通过商品编号
	 * @param productId 商品编号
	 * @return
	 */
	Integer getProductStockByProductId(Integer productId);
	/**
	 * 改变商品库存
	 * @param quantity 数量
	 */
	void changeProductStockByProductId(Integer quantity, Integer productId);
	
	/**
	 * 获取最近新上架上架书籍
	 * @return 产品信息
	 */
	List<ProductBean> getRecentProduct();
	
	/**
	 * 猜你喜欢
	 */
	List<ProductBean> getInterestedProduct(List<String> listProductClass);
	
	/**
	 * 根据顾客搜索条件获取商品信息
	 * @param searchValue 搜索值（书名）
	 * @param orderType（排序类型）
	 * @param priceRangeLeft （左值）
	 * @param priceRangeRight（右值）
	 * @param pageNo（显示的页数）
	 * @param pageSize（页数产品数量）
	 * @return
	 */
	List<ProductBean> customerGetProductWithCondition(String searchValue, String orderType,
			Double priceRangeLeft, Double priceRangeRight, Integer pageNo, Integer pageSize);
	/**
	 * 根据顾客搜索条件获取符合条件的商品数量
	 * @param searchValue 搜索值（书名）
	 * @param orderType（排序类型）
	 * @param priceRangeLeft （左值）
	 * @param priceRangeRight（右值）
	 * @param pageNo（显示的页数）
	 * @param pageSize（页数产品数量）
	 * @return 
	 */
	long countCustomerProductWithCondition(String searchValue, String orderType,
			Double priceRangeLeft, Double priceRangeRight, Integer pageNo, Integer pageSize);
	/**
	 * 通过商品编号获取商店编号
	 * @param productId 商店编号
	 * @return
	 */
	Integer getShopIdByProductId(Integer productId);
	/**
	 * 获取指定用户的购物车商品编号
	 * @param customerId 用户编号
	 * @return
	 */
	List<ProductBean> getShoppingCartProductAssociateShopId(Integer customerId);
	/**
	 * 通过商店编号获取购物车中的产品信息
	 * @param shopId 商店编号
	 * @return
	 */
	List<ProductBean> getShoppingCartProductMessageByShopId(Integer shopId);
	/**
	 * 通过商品编号增加商家的库存
	 * @param quantity
	 * @param productId
	 */
	void addProductStockByProductId(Integer quantity, Integer productId);
	/**
	 * 根据顾客搜索条件获取商品信息
	 * @param searchValue 搜索值（书名）
	 * @param orderType 排序类型
	 * @param priceRangeLeft （左值）
	 * @param priceRangeRight（右值）
	 * @param pageNo（显示的页数）
	 * @param pageSize（页数产品数量）
	 * @return
	 */
	List<ProductBean> customerGetProductWithCondition(String searchValue, String orderType, String searchClass,
			Double priceRangeLeft, Double priceRangeRight, Integer pageNo, Integer pageSize);
	/**
	 * 根据顾客搜索条件获取商品信息
	 * @param searchValue 搜索值（书名）
	 * @param orderType 排序类型
	 * @param priceRangeLeft （左值）
	 * @param priceRangeRight（右值）
	 * @param pageNo（显示的页数）
	 * @param pageSize（页数产品数量）
	 * @return
	 */
	long countCustomerProductWithCondition(String searchValue, String orderType, String searchClass,
			Double priceRangeLeft, Double priceRangeRight, Integer pageNo, Integer pageSize);
	
	/**
	 * 根据销售统计获取商品信息
	 * @param shopId 商店编号
	 * @param orderType 排序类型
	 * @param day 距离今天的天数
	 * @param pageNo 页数
	 * @param pageSize 页面大小
	 * @return
	 */
	List<ProductBean> getProductBySale(Integer shopId, String orderType, Integer day, Integer pageNo, Integer pageSize);
	
	/**
	 * 根据销售统计获取商品的刷另
	 * @param shopId 商店编号
	 * @param orderType 排序类型
	 * @param day 距离今天的天数
	 * @return
	 */
	long countProductBySale(Integer shopId, String orderType, Integer day);
	/**
	 * 获取商品的销售数量
	 * @param shopId
	 * @return
	 */
	long getProductQuantityByProductId(Integer productId, String orderType, Integer day);
	
	
}

