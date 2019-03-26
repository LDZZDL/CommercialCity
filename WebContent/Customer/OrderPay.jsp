<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单支付</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderpay.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/orderpay.js" type="text/javascript"></script>

</head>
<body>
  <div id="pageHeading">
    <a href="#" id="customerMarket">首页</a>
    <a href="#" id="shoppingCart">购物车</a>
    <a href="#" id="personalMessage">个人管理</a>
    <a href="#" id="shopperLogin">商家登录</a>
    <a href="#" id="exit">退出</a> 
  </div>
  <div id="content">
    <div id="password1">
      支付密码：<input type="password" id="payPassword" placeholder="请输入支付密码" autocomplete="off">
    </div>
    <div id="submit1">
      <button id="submit">确 定</button>
    </div>
  </div>

</body>
</html>