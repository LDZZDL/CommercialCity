<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>商家注册</title>
 <link rel="stylesheet" type="text/css" charset="utf-8" href="${pageContext.request.contextPath}/css/shopperregister.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/shopperregister.js"></script>

</head>
<body>
	
 <div id="zong">
   <div class="yeshou">
   <span style="margin:0px 0px 0px 20px; font-size:24px">注册账号</span>
   <a href="/CommercialCity/Shop/ShopperLogin.jsp" style="float:right; margin:0px 40px 0px 0px">登录</a>
   </div>
   <div id="content">
   <form action="/CommercialCity/shopperRegister?action=submit" method="post"> 
   <div>  
     <label class="shuxing" style="margin:45px 10px 0px 90px">账号</label>
     <input type="text"  class="kuang" id="account"placeholder="请输入账号" style="margin:45px 10px 0px 0px" name="account"/>
   </div>
   <div>
     <span class="shuxing" >密码</span>
     <input type="password"  id="password" class="kuang" placeholder="请输入密码" name="password"/>
   </div>
   <div>
     <span class="shuxing" >邮箱</span>
     <input type="text" class="kuang" id="mail" placeholder="请输入邮箱"  style="width:100px; margin-right:0px" name="mail"/>
     <span>@</span>
     <select id="mailselect" name="mailAfter">
     <option>qq</option>
     <option>163</option>
     </select>
     <span>.com</span>
   </div>
   <div>
     <span class="shuxing">身份证</span>
     <input type="text" class="kuang"  id="idCard" placeholder="请输入身份证" name="idCard"/>
   </div>
   <div>
     <span class="shuxing" >信用卡账号</span>
     <input type="text" class="kuang" id="creditAccount" placeholder="请输入卡号" name="creditCardAccount"/>
   </div>
   <div>
     <span class="shuxing" >信用卡密码</span>
     <input type="password" class="kuang" id="creditPassword" placeholder="请输入密码" name="creditCardPassword"/>
   </div>
   <div>
     <span class="shuxing" >称呼</span>
     <input type="text" class="kuang" id="onlineName" placeholder="请输入称呼" name="onlineName"/>
   </div>
   <div>
     <span class="shuxing" >验证码</span>
     <input type="text" class="kuang" id="testCode" placeholder="请输入验证码" />
     <input type="button" value="发送验证码" id="codeButton" >
   </div>
     <input  class="tijiao" type="button"  style="margin:25px 10px 0px 263px" id="send" value="注册" />
     <input  class="tijiao"  style="margin:25px 0px 0px 0px" type="reset" id="res" value="清空"/>
   </form>
   </div>
 </div>

</body>
</html>