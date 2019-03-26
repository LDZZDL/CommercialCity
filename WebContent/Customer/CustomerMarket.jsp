<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/customermarket.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pageSwitch.min.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/pageSwitch.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/script/customermarket.js" type="text/javascript"></script>

</head>
<body>
  <div id="pageHeading">
    <a href="#" id="customerMarket">首页</a>
    <a href="#" id="customerLogin">用户登录</a>
    <a href="#" id="shoppingCart">购物车</a>
    <a href="#" id="personalMessage">个人管理</a>
    <a href="#" id="shopperLogin">商家登录</a>
    <a href="#" id="exit">退出</a> 
  </div>
  <div id="searchDiv">
      <input type="text" placeholder="请输入书名或作者" id="searchValue"/>
      <button id="search">搜 索</button>
  </div>
  <div class="sidebar1">
    <h3 id="sidebar">书籍分类</h3>
    <div id="line"></div>
    <ul class="nav">
      <li><a href="#">教育</a></li> 
      <li><a href="#">小说</a></li> 
      <li><a href="#">文艺</a></li>
      <li><a href="#">青春文学/动漫-幽默</a></li>
      <li><a href="#">生活</a></li>
      <li><a href="#">人文社科</a></li>
      <li><a href="#">经管</a></li>
      <li><a href="#">励志/成功</a></li>
      <li><a href="#">科技</a></li>
    </ul>
  </div>
  <div id="content"> 
  
  
    <div id="container">
	  <div class="sections" style="width:400%">
		
	  </div>
    </div>
    
    
    <div style="height:20px; padding-top:8px;">
      <span style="font-size:20px; font-weight:700; ">— 猜你喜欢 —</span>
    </div>
    <div id="listInterestedProduct"> 
    </div>
    <div id="doubleDiv">
      <div id="listRankingList">
        <h3 id="sidebar1">排行榜</h3>
        <div id="line1"></div>
        <ul class="nav1">
        </ul>
      </div>
      <div style="height:20px; padding-top:13px;">
        <span id="newTitle"><新书上架></span>
      </div>
      <div id="listRecentProduct">   
      </div>
    </div> 
  </div>
</body>
</html>

