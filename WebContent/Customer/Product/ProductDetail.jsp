<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详细页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/productdetail.css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/productdetail.js"></script>

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
  <div style="height:395px; margin-top:20px; border:1px solid #E5E5E5; margin-bottom:20px">
    <div style="float:left">
      <img id="productShowPicture">
    </div>
    <div style="float:left;">
      <div class="kind" style="margin-top:15px">
        <h1 id="productName"></h1>
      </div>
      <div class="kind">
        <p id="productIntroduction" style="overflow:hidden; width:500px;"></p>
      </div>
      <div class="kind" id="price">
        <span class="attribute">价格</span><span id="RMB">¥</span><span id="productSale"></span>
      </div>
      <div style="background:#CCE9F0;
      padding:10px 0px 1px 0px; margin-bottom:20px">
        <div class="kind">
          <span class="attribute">类别</span><span id="productClass"></span>
        </div>
        <div class="kind">
          <span class="attribute">作者</span><span id="writer"></span>
        </div>
        <div class="kind">
          <span class="attribute">出版社</span><span id="publishingHouse"></span>
        </div>
      </div>
      <div class="kind" style="margin-bottom:20px">
        <span class="attribute">数量</span>
        <button id="numDecrease">—</button>
        <input type="text" id="quantity" value="1" autocomplete="off">
        <button id="numIncrease" style="font-size:24px; margin-right:8px;">+</button>
        <span style="font-size:13px">本(库存<span id="productStock"></span>本)</span>
      </div>
      <div class="kind">
        <button id="buyNow">立即购买</button>
        <button id="shoppingCart">加入购物车</button>
      </div>
    </div>
  </div>
  <div style="width:100%; height:100px; border:1px solid #E5E5E5; margin-bottom:20px">
    <p>书籍参数</p>
    <span id="productAttribute"></span>
  </div>
  <div style="border:1px solid #E5E5E5; margin-bottom:20px;">
    <span>展示图片</span>
    <img id="productIntroductionPictureOne">
    <img id="productIntroductionPictureTwo">
    <img id="productIntroductionPictureThree">
  </div>
  
  买家评论
    <div id="comment_div">
    
  
    </div>
    <div style="text-align:center; margin-bottom:40px; margin-top:20px;">
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
  
  
  <div id="showimg_shade">
    <img id="showimg">
  </div>
  <div id="mask"></div>
</body>
</html>
