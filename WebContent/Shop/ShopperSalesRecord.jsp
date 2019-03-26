<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家销售记录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shoppersalesrecord.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/shoppersalesrecord.js" type="text/javascript"></script>
</head>
<body>
	<!-- 商家销售统计 -->
  <h2>商家销售统计</h2>
  <div class="sidebar1">
    <h3 id="sidebar">商家个人管理</h3>
    <div id="line"></div>
    <ul class="nav">
      <li><a href="/CommercialCity/Shop/message/ShopperMessage.jsp">信息管理<span class="jiange">></span></a></li> 
      <li><a href="/CommercialCity/Shop/product/ShopProductManage.jsp">商品管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Shop/ShopperOrderManage.jsp">订单管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Shop/ShopperSalesRecord.jsp" style="background-color:#f00; color:#fff;">销售统计<span class="jiange">></span></a></li>
    </ul>
    <div style="height:250px;"></div>
  </div>
  <div id="content">
    
    <div id="screen">
      <span style="margin:0px 2px 0px 30px">排序</span>
        <select id="orderType">
          <option value="SVA">销量从少到多</option>
          <option value="SVD">销量从多到少</option>
        </select>
      <span style="margin:0px 2px 0px 5px">时间</span>
        <select id="time">
          <option value="所有">全部</option>
          <option value="最近一天">最近一天</option>
          <option value="最近三天">最近三天</option>
          <option value="最近一周">最近一周</option>
          <option value="最近一个月">最近一个月</option>
        </select>
    </div>
    
    
    
    <div id="record">
    
      
      
    </div>
  
  
    <div style="margin:20px 0px 10px 320px;">
      <button class="previousPage">上一页</button>
        <span class="pageNo" style="margin-left:5px; margin-right:5px;"></span>|
        <span class="totalPageNo" style="margin-right:5px"></span>
      <button class="nextPage">下一页</button>
    </div>
    
    
    
  </div>
</body>
</html>