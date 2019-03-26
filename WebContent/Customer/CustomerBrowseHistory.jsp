<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户浏览历史</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/customerbrowsehistory.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/customerbrowsehistory.js" type="text/javascript"></script>
</head>
<body>
	<!-- 用户浏览历史 -->
  <div id="pageHeading">
    <a href="#" id="customerMarket">首页</a>
    <a href="#" id="shoppingCart">购物车</a>
    <a href="#" id="personalMessage">个人管理</a>
    <a href="#" id="shopperLogin">商家登录</a>
    <a href="#" id="exit">退出</a> 
  </div>
  <h2>用户浏览历史</h2>
  <div class="sidebar1">
    <h3 id="sidebar">用户个人管理</h3>
    <div id="line"></div>
    <ul class="nav">
      <li><a href="/CommercialCity/Customer/Message/CustomerMessage.jsp">信息管理<span class="jiange">></span></a></li> 
      <li><a href="/CommercialCity/Customer/CustomerOrderManage.jsp">订单管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Customer/CustomerBrowseHistory.jsp" style="background-color:#f00; color:#fff;">浏览历史<span class="jiange">></span></a></li>
    </ul>
    <div style="height:250px;"></div>
  </div>
  <div id="content">
    <div id="history">
    
      
      
    </div>
  
  
  
  
    <div style="margin:20px 0px 10px 230px;">
      <button class="previousPage">上一页</button>
        <span class="pageNo" style="margin-left:5px; margin-right:5px;"></span>|
        <span class="totalPageNo" style="margin-right:5px"></span>
      <button class="nextPage">下一页</button>
    </div>
  </div>
</body>
</html>