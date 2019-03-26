<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单确认</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/orderconfirm.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/Area.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/AreaData_min.js"></script>
<script src="${pageContext.request.contextPath}/script/orderconfirm.js" type="text/javascript"></script>
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
    <div id="deliveryAddress"> 
      <div style="font-weight:700; border-bottom:2px solid #F1F1F1; margin-bottom:20px;">确认收货地址</div>
      
      
      
    </div>
    
    
    <div id="orderMessage">
      <div style="font-weight:700;">确认订单信息</div>
      <div>
        <span id="productName">书名</span>
        <span id="productSale">单价</span>
        <span id="quantity">数量</span>
        <span id="total">小计</span>
      </div>
      
      
    </div>
      
      
      <div style="position:relative;">
        <div id="totalPriceBlock">
          <span id="RMBP">实付款：</span><span id="RMB">¥</span><span id="totalPrice"></span>
        </div>
        <div id="submitOrderBlock">
          <button id="submitOrder">提交订单</button>
        </div>
      </div>
      
      
    
  </div>
	
</body>
</html>