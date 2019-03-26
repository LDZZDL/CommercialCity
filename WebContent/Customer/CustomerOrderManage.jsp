<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户订单管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/customerordermanage.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/customerordermanage.js" type="text/javascript"></script>
</head>
<body>
	<!-- 顾客信息管理首页 -->
  
  <div id="pageHeading">
    <a href="#" id="customerMarket">首页</a>
    <a href="#" id="shoppingCart">购物车</a>
    <a href="#" id="personalMessage">个人管理</a>
    <a href="#" id="shopperLogin">商家登录</a>
    <a href="#" id="exit">退出</a> 
  </div>
  <h2>用户订单管理</h2>

  <div class="sidebar1">
    <h3 id="sidebar">用户个人管理</h3>
    <div id="line"></div>
    <ul class="nav">
      <li><a href="/CommercialCity/Customer/Message/CustomerMessage.jsp">信息管理<span class="jiange">></span></a></li> 
      <li><a href="/CommercialCity/Customer/CustomerOrderManage.jsp" style="background-color:#f00; color:#fff;">订单管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Customer/CustomerBrowseHistory.jsp">浏览历史<span class="jiange">></span></a></li>
    </ul>
    <div style="height:250px;"></div>
  </div>
  
  
  
  <div id="content">
  
  
    <div style="height:40px; margin-bottom:20px;">
      <ul id="orderStatusBlock">
        <li id="waitPay" style="border-bottom-color:#FF0000; color:#FF0000;">待付款</li><span class="line">|</span>
        <li id="waitSend">待发货</li><span class="line">|</span>
        <li id="waitConfirm">待收货</li><span class="line">|</span>
        <li id="waitRate">待评价</li><span class="line">|</span>
        <li id="and">已完成</li>
      </ul>
    </div>
    
    
    <div id="orderMessage">
      <span id="productName">书籍</span>
      <span id="productSale">单价</span>
      <span id="quantity">数量</span>
      <span id="totalPrice">实付款</span>
      <span id="orderStatus">交易状态</span>
      <span id="operation">操作</span>
    </div>
    
    <div style="text-align:right; margin-bottom:10px;">
        <button class="previousPage">上一页</button>
          <span class="pageNo" style="margin-left:5px; margin-right:5px;"></span>|
          <span class="totalPageNo" style="margin-right:5px"></span>
        <button class="nextPage">下一页</button>
      </div>
    
    <div id="orders"> 
           
    </div>
    
    
    <div style="text-align:right; margin-bottom:10px;">
      <button class="previousPage">上一页</button>
        <span class="pageNo" style="margin-left:5px; margin-right:5px;"></span>|
        <span class="totalPageNo" style="margin-right:5px"></span>
      <button class="nextPage">下一页</button>
    </div>
    
    
    
  </div>
  
  <!--商品评价盒子-->
  
  
  <div id="rateBox">
    <div style="background:#F7F7F7">
      <span class="heading">商品评论</span><a href="javascript:void(0)" title="关闭窗口" id="RcloseBtn">X</a>
    </div>
    <div class="kind">
      <span id="grade">星级</span>
      <select id="rateGrade">
        <option value="1">一星</option>
        <option value="2">二星</option>
        <option value="3">三星</option>
        <option value="4">四星</option>
        <option value="5" selected>五星</option>
      </select>
    </div>
    <div class="kind">
      <span id="commentName">评论</span>
      <textarea id="comment" placeholder="请输入评论"></textarea>
    </div>
    
    <div class="kind">
      <input type="button" id="ratesubmit" value="发表评论" autocomplete="off">
    </div>  
  </div>
  
  
  
  <div id="mask"></div>
</body>
</html>