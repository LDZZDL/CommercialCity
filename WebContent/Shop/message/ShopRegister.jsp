<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商店注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopregister.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/shopregister.js" type="text/javascript"></script>
</head>
<body>

	<h2>店铺注册</h2>
  <div id="background">
    <form action="/CommercialCity/shopperRegister?action=ShopRegister&actionRegister=submit" method="post" enctype="multipart/form-data">
      <div class="kind1 picture">
        <label class="attribute" for="myfile">头像</label>
        <a id="imgbtn">
          <input type="file" name="displayPicture" id="myfile">点击上传文件 
        </a>
      </div>
      <div class="img_div" style="margin-top:10px">
      </div>
      <div class="kind2" style="margin-top:40px">
        <span class="attribute" >店铺介绍</span>
        <textarea id="introduction" class="input"  name="introduction" placeholder="请输入店铺介绍" rows="5" cols="30"></textarea>
      </div>
      <div class="kind1">
        <label class="attribute" for="shopName">店铺名称</label>
        <input type="text" id="shopName" name="shopName" class="input" placeholder="请输入店铺名称" >
      </div>
      <div class="kind2">
        <input type="button" id="send" value="注 册">
        <input type="reset" id="res" value="重 置">
      </div>
    </form>
  </div>

</body>
</html>