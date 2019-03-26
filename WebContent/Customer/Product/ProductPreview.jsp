<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品预览页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/productpreview.css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/productpreview.js"></script>

</head>
<body>
  <div id="content">
  
  <div style="height:395px; margin-top:20px; border:1px solid #E5E5E5; margin-bottom:20px">
    <div style="float:left">
      <img id="productShowPicture">
    </div>
    <div style="float:left;">
      <div class="kind" style="margin-top:25px">
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
  
  
  
  
  
  
  </div>
  
  
   
  
  
  <div id="showimg_shade">
    <img id="showimg">
  </div>
  
</body>
</html>
