<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家登录</title>
<link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/css/shopperlogin.css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/shopperlogin.js"></script>

</head>
<body>

	<div id="content">
  <div id="pageheading" style="height:30px"></div>
  <form>
    <div id="login">
    <h2>商家登录</h2>
      <div class="kind" style="margin-top:20px">
        <label class="attribute">账号</label>
        <input class="input" id="account" type="text" placeholder="请输入账号">
        <a href="message/ShopperRegister.jsp" id="shoperreg" style=" float:right;  margin-right:30px;">注册账号</a>
      </div>
      <div class="kind">
        <label class="attribute">密码</label>
        <input class="input" id="password" type="password" placeholder="请输入密码">
        <a href="message/ShopFindPassword1.jsp" id="findpassword" style=" float:right;  margin-right:30px;">找回密码</a>
      </div>
      <div class="kind">
        <input  type="button" value="登 录" id="submit">
      </div>   
    </div>
  </form>
</div>
</div>

	
</body>
</html>