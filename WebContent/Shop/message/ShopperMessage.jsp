<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家信息查看</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shoppermessage.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/shoppermessage.js" type="text/javascript"></script>
</head>
<body>
	<!-- 商家信息管理首页 -->
	<h2>商家信息查看</h2>
  <div class="sidebar1">
    <h3 id="sidebar">商家个人管理</h3>
    <div id="line"></div>
    <ul class="nav">
      <li><a href="/CommercialCity/Shop/message/ShopperMessage.jsp" style="background-color:#f00; color:#fff;">信息管理<span class="jiange">></span></a></li> 
      <li><a href="/CommercialCity/Shop/product/ShopProductManage.jsp">商品管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Shop/ShopperOrderManage.jsp">订单管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Shop/ShopperSalesRecord.jsp">销售统计<span class="jiange">></span></a></li>
    </ul>
    <div style="height:250px;"></div>
  </div>
  <div id="content" style="margin-top:40px;">
    <div class="kind">
      <div>
        <span class="attribute" style="text-align:center">头像</span>
        <button id="shopperDisplayPictureAlter">修改头像</button>
        <span class="attribute" style="text-align:center; margin-left:46px">店铺头像</span>
        <button id="shopDisplayPictureAlter" >修改店铺头像</button>
      </div>
      <img class="shopperDisplayPicture" style="width:100px; height:100px;">
      <img class="shopDisplayPicture" style="width:100px; height:100px; margin-left:180px;">
    </div>
    <div class="line"></div>
    <div class="kind">
      <span class="attribute">姓名</span><span class="check" id="shopperName"></span>
      <span class="attribute" style="width:40px">店名</span><span class="check" id="shopName"></span>
      <button class="button" id="basicMessageAlter">修改基本信息</button>
    </div>
    <div class="kind">
      <span class="attribute">身份证</span><span class="check" id="idCard"></span>
    </div>
    <div class="kind">
      <span class="attribute">店铺介绍</span><span class="check" id="shopIntroduction"></span>
    </div>
    <div class="kind">
      <span class="attribute">开店日期</span><span class="check" id="openDate"></span>  
    </div>
    <div class="line"></div>
    <div class="kind">
      <span class="attribute">密码</span><span class="check">**********</span>
      <button class="button" id="passwordAlter">修 改 密 码</button>
    </div>
    <div class="line"></div>
    <div class="kind">   
      <span class="attribute">邮箱</span><span class="check" id="shopperMail"></span>
      <button class="button" id="mailAlter">更 改 邮 箱</button>
    </div>
    <div class="line"></div>
    <div class="kind">
      <span class="attribute">信用卡</span><span class="check" id="credit"></span>
      <button class="button" id="creditAlter">更改绑定信用卡</button>
    </div>
    <div class="line"></div>
  </div>
  
  
  <!--修改个人头像盒子-->
  
  <div class="box" id="shopperDisplayPictureBox">
    <div style="background:#F7F7F7">
      <span class="heading">个人头像修改</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="DPcloseBtn">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="myfile" style="text-align:center; width:100px; margin-left:40px; margin-top:5px;">个人头像</label>
        <form action="/CommercialCity/shopMessage?action=ChangeshopMessage&goal=shopperDisplayPicture
" method="post" enctype="multipart/form-data" id="shopperDisplayPictureForm">
          <input type="file" name="displayPicture" id="myfile">
        </form>
      <div class="img_div">
      </div>
    </div>
    
    <div class="kind">
      <input type="button" id="shopperdisplaypicturesubmit" value="确定">
    </div>  
  </div>
  
  <!--修改店铺头像盒子-->
  
  <div class="box" id="shopDisplayPictureBox">
    <div style="background:#F7F7F7">
      <span class="heading">店铺头像修改</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="DPcloseBtn1">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="myfile1" style="text-align:center; width:100px; margin-left:40px; margin-top:5px;">店铺头像</label>
        <form action="/CommercialCity/shopMessage?action=ChangeshopMessage&goal=shopDisplayPicture
" method="post" enctype="multipart/form-data" id="shopDisplayPictureForm">
          <input type="file" name="displayPicture" id="myfile1">
        </form>
      <div class="img_div1">
      </div>
    </div>
    
    <div class="kind">
      <input type="button" id="shopdisplaypicturesubmit" value="确定">
    </div>  
  </div>
  
  
  
  <!--修改基本信息盒子--> 
  <div class="box" id="basicMessageBox">
    <div style="background:#F7F7F7">
      <span class="heading">基本信息修改</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="BMcloseBtn">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="shoppername">个人姓名</label>
      <input type="text" class="input" id="shoppername" placeholder="请输入姓名">
    </div>
    <div class="kind">
      <label class="attribute" for="shopname">店名</label>
      <input type="text" class="input" id="shopname" placeholder="请输入店名">
    </div>
    <div class="kind">
      <label class="attribute" for="shopintroduction" style="float:left; margin-right:14px">店铺介绍</label>
      <textarea type="text" class="input" id="shopintroduction" placeholder="请输入店铺介绍" style="width:250px; height:100px;"></textarea>
    </div>
    <div class="kind">
      <input type="button" id="basicmessagesubmit" value="修改">
    </div>  
  </div>
  
  <!--修改密码盒子-->
  
  <div class="box" id="passwordBox">
    <div style="background:#F7F7F7">
      <span class="heading">密码修改</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="PcloseBtn">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="passwordTestCode">验证码</label>
      <input type="text" class="input" id="passwordTestCode" placeholder="请输入验证码">
      <input type="button" id="passwordTestCodeButton" value="点击发送">
    </div>
    <div class="kind" id="newpassword" style="display:none">
      <div style="margin-bottom:10px">
        <label class="attribute" for="newPassword">新密码</label>
        <input type="password" class="input" id="newPassword" placeholder="请输入密码">
      </div>
      <div>
        <label class="attribute" for="newPassword1">再次输入</label>
        <input type="password" class="input" id="newPassword1" placeholder="请输入密码">
      </div>
    </div>
    <div class="kind">
      <input type="button" id="passwordsubmit" value="修改">
    </div>  
  </div>
  
  <!--修改邮箱盒子-->
  
  <div class="box" id="mailBox">
    <div style="background:#F7F7F7">
      <span class="heading">邮箱修改</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="McloseBtn">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="mailTestCode">验证码</label>
      <input type="text" class="input" id="mailTestCode" placeholder="请输入验证码">
      <input type="button" id="mailTestCodeButton" value="点击发送">
    </div>
    <div class="kind" id="newmail" style="display:none ">
      <div style="margin-bottom:13px;">
        <label class="attribute" for="newMail">新邮箱</label>
        <input type="text" class="input" id="newMail" placeholder="请输入邮箱" style="width:120px">
        <span>@</span>
        <select id="mailselect">
          <option>qq</option>
          <option>163</option>
        </select>
        <span>.com</span>
      </div>
      <div>
        <label class="attribute" for="mailTestCode1">验证码</label>
        <input type="text" class="input" id="mailTestCode1" placeholder="请输入验证码">
        <input type="button" id="mailTestCodeButton1" value="点击发送">
      </div>
    </div>
    <div class="kind">
      <input type="button" id="mailsubmit" value="确定">
    </div>  
  </div>
  
  
  
  <!--修改信用卡盒子-->
  
  <div class="box" id="creditBox" style="display:none">
    <div style="background:#F7F7F7">
      <span class="heading">信用卡修改</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="CcloseBtn">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="creditAccount">账号</label>
      <input type="text" class="input" id="creditAccount" placeholder="请输入信用卡账号">
    </div>
    <div class="kind">
      <label class="attribute" for="creditPassword">密码</label>
      <input type="password" class="input" id="creditPassword" placeholder="请输入信用卡密码">
    </div>
    <div class="kind">
      <input type="button" id="creditsubmit" value="修改">
    </div>  
  </div>
  
  
  
  
  <div id="mask"></div>
  <div id="showimg_shade">
    <img id="showimg">
  </div>
</body>
</html>