package com.fjsf.web.dao;

import java.util.Date;
import java.util.List;

import com.fjsf.web.bean.CommentBean;

public interface CommentDAO {
	
	/**
	 * 增加评论
	 * @param customerId 客户编号
	 * @param productId 商品编号
	 * @param orderId 订单编号
	 * @param commentContent 评论内容
	 * @param goodRate 好评率
	 * @param date 日期
	 */
	void addCommentDAO(Integer customerId, Integer productId, Integer orderId,
			String commentContent, Integer goodRate, Date date);
	/**
	 * 按照商品编号显示评论信息
	 * @param productId 商品编号
	 */
	List<CommentBean> showCommentMessageByProductId(Integer productId);
	/**
	 * 根据调价显示评论信息
	 * @param productId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<CommentBean> showCommentMessageWithCondition(Integer productId, Integer pageNo, Integer pageSize);
	/**
	 * 计算产品的评论信息书目
	 * @param productId 产品编号
	 * @return
	 */
	long countCommentByProductId(Integer productId);
	/**
	 * 通过商店编号获取评论信息
	 * @param shopId 商店编号
	 * @param pageNo 
	 * @param pageSize
	 * @return
	 */
	List<CommentBean> getCommentMessageByShopId(Integer shopId, Integer pageNo, Integer pageSize);
	/**
	 * 获取指定商店的评论数量
	 * @param shopId 商店编号
	 * @return
	 */
	long countCommentMessageByShopId(Integer shopId);
}
