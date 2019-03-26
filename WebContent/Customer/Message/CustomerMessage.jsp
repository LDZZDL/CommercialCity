<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/customermessage.css" type="text/css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/Area.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/AreaData_min.js"></script>
<script src="${pageContext.request.contextPath}/script/customermessage.js" type="text/javascript"></script>

</head>
<body>
	<!-- 顾客信息管理首页 -->
  <div id="pageHeading">
    <a href="#" id="customerMarket">首页</a>
    <a href="#" id="shoppingCart">购物车</a>
    <a href="#" id="personalMessage">个人管理</a>
    <a href="#" id="shopperLogin">商家登录</a>
    <a href="#" id="exit">退出</a> 
  </div>
	<h2>用户信息查看</h2>
  <div class="sidebar1">
    <h3 id="sidebar">用户个人管理</h3>
    <div id="line"></div>
    <ul class="nav">
      <li><a href="/CommercialCity/Customer/Message/CustomerMessage.jsp" style="background-color:#f00; color:#fff;">信息管理<span class="jiange">></span></a></li> 
      <li><a href="/CommercialCity/Customer/CustomerOrderManage.jsp">订单管理<span class="jiange">></span></a></li>
      <li><a href="/CommercialCity/Customer/CustomerBrowseHistory.jsp">浏览历史<span class="jiange">></span></a></li>
    </ul>
    <div style="height:250px;"></div>
  </div>
  <div id="content">
    <div class="kind">
      <div>
        <span class="attribute" style="text-align:center">头像</span>
        
      </div>
      <img class="displayPicture">
      <button id="displayPictureAlter" class="button">修改头像</button>
    </div>
    <div class="line"></div>
    <div class="kind">
      <span class="attribute">姓名</span><span class="check" id="customerName"></span>
      <button class="button" id="basicMessageAlter">修改基本信息</button>
    </div>
    <div class="kind">
      <span class="attribute">性别</span><span class="check" id="customerSex"></span>    
    </div>
    <div class="line"></div>
    <div class="kind">
      <span class="attribute">密码</span><span class="check">**********</span>
      <button class="button" id="passwordAlter">修 改 密 码</button>
    </div>
    <div class="line"></div>
    <div class="kind">
      <span class="attribute">邮箱</span><span class="check" id="customerMail"></span>
      <button class="button" id="mailAlter">更 改 邮 箱</button>
    </div>
    <div class="line"></div>
    <div class="kind">
      <span class="attribute">信用卡</span><span class="check" id="credit"></span>
      <button class="button" id="creditAlter">更改绑定信用卡</button>
    </div>
    <div class="line"></div>
    <div class="kind">
      <span class="attribute" style="margin-bottom:6px;">收货地址</span>
      <table>
        <tr>
          <th width="100">姓名</th>
          <th width="150">电话</th>
          <th width="280">地址</th>
          <th width="118">&nbsp;&nbsp;&nbsp;操作&nbsp;&nbsp;&nbsp;&nbsp;<button id="addDeliveryAddress">&nbsp;新增&nbsp;</button></th>
        </tr>
      </table>
    </div>
  </div>
  
  
  <!--修改头像盒子-->
  
  <div class="box" id="displayPictureBox">
    <div style="background:#F7F7F7">
      <span class="heading">头像修改</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="DPcloseBtn">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="myfile" style="text-align:center; width:100px; margin-left:40px; margin-top:5px;">头像</label>
        <form action="/CommercialCity/customerMessage?action=ChangeCustomerMessage&goal=DisplayPicture
" method="post" enctype="multipart/form-data" id="displayPictureForm">
        <input type="file" name="displayPicture" id="myfile">
        </form>
      <div class="img_div">
      </div>
    </div>
    
    <div class="kind">
      <input type="button" id="displaypicturesubmit" value="确定">
    </div>  
  </div>
  
  
  
  <!--修改基本信息盒子-->
  
  
  <div class="box" id="basicMessageBox">
    <div style="background:#F7F7F7">
      <span class="heading">基本信息修改</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="BMcloseBtn">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="customername">姓名</label>
      <input type="text" class="input" id="customername" placeholder="请输入姓名">
    </div>
    <div class="kind">
      <label class="attribute">性别</label>
      <select id="customersex">
        <option>男</option>
        <option>女</option>
      </select>
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
      <div>
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
    <div class="kind" id="newmail" style="display:none">
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
  
  <div class="box" id="creditBox">
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
  
  
  <!--新增、修改收货地址盒子-->
  
  <div class="box" id="deliveryAddressBox">
    <div style="background:#F7F7F7">
      <span class="heading">收货地址</span><a href="javascript:void(0)" title="关闭窗口" class="close_btn" id="DcloseBtn">X</a>
    </div>
    <div class="kind">
      <label class="attribute" for="receiverName">姓名</label>
      <input type="text" class="input" id="receiverName" placeholder="请输入收货人姓名">
    </div>
    <div class="kind">
      <label class="attribute" for="receiverTelephone">手机号码</label>
      <input type="text" class="input" id="receiverTelephone" placeholder="请输入收货人电话">
    </div>
    <div class="kind">
      <label class="attribute" for="receiverAddress">地址</label>
      <select id="seachprov" name="seachprov" onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"></select>
      &nbsp;
      <select id="seachcity" name="homecity" onChange="changeCity(this.value,'seachdistrict','seachdistrict');"></select>
      &nbsp;
      <span id="seachdistrict_div">
        <select id="seachdistrict" name="seachdistrict"></select>
      </span>
    </div>
    <div class="kind">
      <input type="text" class="input" id="receiverAddress" placeholder="请输入详细地址" style="margin-left:107px; width:218px;">
    </div>
    <div class="kind">
      <input type="button" id="deliveryaddresssubmit" value="确定">
    </div>  
  </div>
  
  
  
  <div id="mask"></div>

</body>
</html>