package com.fjsf.web.dao.impl;

import java.util.Date;
import java.util.List;

import com.fjsf.web.bean.BrowserHistoryBean;
import com.fjsf.web.bean.CommentBean;
import com.fjsf.web.dao.BrowserHistoryDAO;

public class BrowserHistoryDAOImpl extends BaseDAO<BrowserHistoryBean> implements BrowserHistoryDAO{

	@Override
	public void addBrowserHistory(Integer customerId, Integer productId, Date date) {
		String sql = "INSERT INTO BrowserHistory(customerId,productId,time) VALUES(?,?,?)";
		insert(sql, customerId, productId, date);
	}

	private String getLimit(Integer pageNo, Integer pageSize){
		return " LIMIT " + (pageNo-1) * pageSize + "," + pageSize;
	}
	
	private String getDate(){
		return " datediff(now(),time) <= 3";
	}
	
	@Override
	public List<BrowserHistoryBean> getBrowserHistoryByCustomerId(Integer customerId, 
			Integer pageNo, Integer pageSize) {
		String sql = "SELECT customerId,productId,time FROM BrowserHistory WHERE "
				+ " customerId = ? "+ " AND " + getDate() + " ORDER BY time DESC " + 
				getLimit(pageNo, pageSize);
		return queryForList(sql, customerId);
	}

	@Override
	public long countBrowserHistory(Integer customerId) {
		String sql = "SELECT count(*) FROM BrowserHistory WHERE "
				+ " customerId = ? "+ " AND " + getDate();
		return getSingleVal(sql, customerId);
	}

	@Override
	public List<Integer> getIndexOfBrowserHistory(Integer customerId) {
		String sql = "SELECT count(*) FROM browserHistory INNER JOIN product "
				+ " ON(browserHistory.productId = product.productId) "
				+ " WHERE customerId = ? "
				+ " group by productClass ORDER BY count(*) DESC ";
		return getSingleVal(sql, customerId);
	}

	@Override
	public List<BrowserHistoryBean> getClassOfBrowserHistory(Integer customerId) {
		String sql = "SELECT customerId,browserHistory.productId,time FROM browserHistory INNER JOIN product "
				+ " ON(browserHistory.productId = product.productId) "
				+ " WHERE customerId = ? "
				+ " group by productClass ORDER BY count(*) DESC ";
		return queryForList(sql, customerId);
	}
	
}
