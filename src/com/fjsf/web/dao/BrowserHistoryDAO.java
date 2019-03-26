package com.fjsf.web.dao;

import java.util.Date;
import java.util.List;

import com.fjsf.web.bean.BrowserHistoryBean;
import com.fjsf.web.bean.CommentBean;

public interface BrowserHistoryDAO {
	
	/**
	 * 增加用户浏览历史
	 * @param customerId 用户编号
	 * @param productId 产品编号
	 */
	void addBrowserHistory(Integer customerId, Integer productId, Date date);
	
	/**
	 * 通过客户编号获取客户浏览历史
	 * @param customerId 客户编号
	 * @return
	 */
	List<BrowserHistoryBean> getBrowserHistoryByCustomerId(Integer customerId, 
			Integer pageNo, Integer pageSize);
	
	/**
	 * 获取指定客户的浏览历史数量
	 * @param customerId 用户编号
	 * @return
	 */
	long countBrowserHistory(Integer customerId);
	/**
	 * 获取商品的浏览历史指数
	 * @param customerId 用户编号
	 * @return
	 */
	List<Integer> getIndexOfBrowserHistory(Integer customerId);
	/**
	 * 获取商品浏览的商品分类
	 * @param customerId
	 * @return
	 */
	List<BrowserHistoryBean> getClassOfBrowserHistory(Integer customerId);
}
