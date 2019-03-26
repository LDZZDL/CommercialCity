<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家订单管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopperordermanage.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/shopperordermanage.js" type="text/javascript"></script>
</head>
<body>
	<!-- 商家订单管理 -->
  <div>
    <h2>商家订单管理</h2>
  </div>
  <div class="sidebar1">
    <h3 id="sidebar">商家个人管理</h3>
    <div id="line"></div>
    <ul class="nav">
      <li><a href="/CommercialCity/Shop/message/ShopperMessage.jsp">信息管理<span class="jiange">></span></a></li> 
      <li><a href="/CommercialCity/Shop/product/ShopProductManage.jsp">商品管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Shop/ShopperOrderManage.jsp" style="background-color:#f00; color:#fff;">订单管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Shop/ShopperSalesRecord.jsp">销售统计<span class="jiange">></span></a></li>
    </ul>
    <div style="height:250px;"></div>
  </div>
  <div id="content">
  
  
    <div style="height:40px; margin-bottom:20px;">
      <ul id="orderStatusBlock">
        <li id="waitSend" style="border-bottom-color:#FF0000; color:#FF0000;">待发货</li><span class="line">|</span>
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
	
</body>
</html>