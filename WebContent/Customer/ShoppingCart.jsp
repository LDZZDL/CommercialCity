<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shoppingcart.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/shoppingcart.js" type="text/javascript"></script>

</head>
<body>
  <div id="pageHeading">
    <a href="#" id="customerMarket">首页</a>
    <a href="#" id="shoppingCart1">购物车</a>
    <a href="#" id="personalMessage">个人管理</a>
    <a href="#" id="shopperLogin">商家登录</a>
    <a href="#" id="exit">退出</a> 
  </div>
  <div id="content">
    <div style="font-size:22px; border-bottom:2px solid #E6E6E6; margin-bottom:15px; padding-bottom:10px;">购物车</div>
    <div id="shoppingCart">
      <div>
        <input type="checkbox" class="quan" autocomplete="off" style="margin-left:10px">
        <span class="all">全选</span>
        <span id="productName">书籍信息</span>
        <span id="productSale">单价</span>
        <span id="quantity">数量</span>
        <span id="totalPrice">金额</span>
        <span id="operation">操作</span>
      </div>
    </div>
    
    
    <div id="payBlock">
      <input type="checkbox" class="quan" autocomplete="off" style="margin-left:5px">
      <span class="all" style="margin-top:15px;">全选</span> 
      <div style="float:right;">
        <span>合计：</span>
        <span id="RMB">¥</span>
        <span id="totalMoney">0</span>
        <a href="#" id="pay">结 算</a>
      </div>
    </div>
    
    
    
    <div style="text-align:center; margin-bottom:40px; margin-top:20px;">
      <button class="previousPage">上一页</button>
        <span class="pageNo" style="margin-left:5px; margin-right:5px;"></span>|
        <span class="totalPageNo" style="margin-right:5px"></span>
      <button class="nextPage">下一页</button>
    </div>
    
    
    
  </div>
	
</body>
</html>