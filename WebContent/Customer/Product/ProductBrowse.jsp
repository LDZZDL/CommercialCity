<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品浏览</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/productbrowse.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/productbrowse.js" type="text/javascript"></script>

</head>
<body>
  <div id="pageHeading">
    <a href="#" id="customerMarket">首页</a>
    <a href="#" id="customerLogin">用户登录</a>
    <a href="#" id="shoppingCart1">购物车</a>
    <a href="#" id="personalMessage">个人管理</a>
    <a href="#" id="shopperLogin">商家登录</a>
    <a href="#" id="exit">退出</a> 
  </div>
  <div id="content">
    <div id="searchDiv">
      <input type="text" placeholder="请输入书名或作者" id="searchValue"/>
      <button id="search">搜 索</button>
    </div>
    <div id="screen">
      <span style="margin:0px 5px 0px 20px">类别</span>
        <select id="searchClass">
          <option value="全部分类">全部分类</option>
          <option value="教育">教育</option>
          <option value="小说">小说</option>
          <option value="文艺">文艺</option>
          <option value="青春文学/动漫-幽默">青春文学/动漫-幽默</option>
          <option value="生活">生活</option>
          <option value="人文社科">人文社科</option>
          <option value="经管">经管</option>
          <option value="励志/成功">励志/成功</option>
          <option value="科技">科技</option>
        </select>
      <span style="margin:0px 5px 0px 5px">排序</span>
        <select id="orderType">
          <option value="ALL">无序</option>
          <option value="PA">价格从低到高</option>
          <option value="PD">价格从高到低</option>
          <option value="SVA">销量从少到多</option>
          <option value="SVD">销量从多到少</option>
        </select>
        <span style="margin-right:5px;">价格区间</span>
        <input type="text" id="priceRangeLeft" placeholder="下限">
        —
        <input type="text" id="priceRangeRight" placeholder="上限">
        <input type="button" id="priceRangeButton" value="确定">
        <button class="previousPage">上一页</button>
          <span class="pageNo" style="margin-left:5px; margin-right:5px;"></span>|
          <span class="totalPageNo" style="margin-right:5px"></span>
       <button class="nextPage">下一页</button>
    </div>
    <div id="products" style="width:875px; float:left">
    </div>
    <div style="text-align:center; margin-bottom:40px">
       <button class="previousPage">上一页</button>
          <span class="pageNo" style="margin-left:5px; margin-right:5px;"></span>|
          <span class="totalPageNo" style="margin-right:5px"></span>
       <button class="nextPage">下一页</button>
    </div>
  </div>
  
  
  <!--登录盒子-->
  
  
  <div id="loginBox">
    <div style="background:#F7F7F7">
      <span class="heading">用户登录</span><a href="javascript:void(0)" title="关闭窗口" id="AcloseBtn">X</a>
    </div>
    <div class="kind">
      <label id="account1" for="account">账号</label>
      <input type="text" id="account" placeholder="请输入账号" autocomplete="off">
    </div>
    <div class="kind">
      <label id="password1" for="password">密码</label>
      <input type="password" id="password" placeholder="请输入密码" autocomplete="off">
    </div>
    
    <div class="kind">
      <input type="button" id="submit" value="登录" autocomplete="off">
    </div>  
  </div>
  
  <div id="mask"></div>
</body>
</html>