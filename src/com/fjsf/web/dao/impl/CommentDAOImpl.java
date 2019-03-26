package com.fjsf.web.dao.impl;

import java.util.Date;
import java.util.List;

import com.fjsf.web.bean.CommentBean;
import com.fjsf.web.dao.CommentDAO;

public class CommentDAOImpl extends BaseDAO<CommentBean> implements CommentDAO{

	@Override
	public void addCommentDAO(Integer customerId, Integer productId, Integer orderId, 
			String commentContent, Integer goodRate, Date date) {
		String sql = "INSERT INTO comment(customerId,productId,orderId,commentContent,goodRate,commentTime) "
				+ " VALUES(?,?,?,?,?,?)";
		insert(sql, customerId, productId, orderId, commentContent, goodRate, date);
	}

	@Override
	public List<CommentBean> showCommentMessageByProductId(Integer productId) {
		String sql = "SELECT customerId,productId,commentContent,goodRate,commentTime "
				+ " FROM comment WHERE productId = ?";
		return queryForList(sql, productId);
	}

	private String getLimit(Integer pageNo, Integer pageSize){
		
		return " LIMIT " + (pageNo-1)*pageSize + "," + pageSize;
	}
	
	@Override
	public List<CommentBean> showCommentMessageWithCondition(Integer productId, Integer pageNo, Integer pageSize) {
		String sql = "SELECT customerId,productId,commentContent,goodRate,commentTime "
				+ " FROM comment WHERE productId = ?" + getLimit(pageNo, pageSize);
		return queryForList(sql, productId);
	}

	@Override
	public List<CommentBean> getCommentMessageByShopId(Integer shopId, Integer pageNo, Integer pageSize) {
		String sql = "SELECT customerId,comment.productId,commentContent,goodRate,commentTime "
				+ " FROM comment INNER JOIN product ON(comment.productId = product.productId) "
				+ " WHERE shopId = ? ORDER BY commentTime DESC " + getLimit(pageNo, pageSize);
		return queryForList(sql, shopId);
	}

	@Override
	public long countCommentMessageByShopId(Integer shopId) {
		String sql = "SELECT count(*) FROM comment INNER JOIN product "
				+ " ON(comment.productId = product.productId) WHERE shopId = ?";
		return getSingleVal(sql, shopId);
	}

	@Override
	public long countCommentByProductId(Integer productId) {
		String sql = "SELECT count(*) FROM comment WHERE productId= ? order by commentTime DESC";
		return getSingleVal(sql, productId);
	}

	
	
}
