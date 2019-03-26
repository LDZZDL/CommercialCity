<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/customerregister.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/customerregister.js"></script>

</head>
<body>

<div id="content">
  <div id="pageheading">用户注册</div>
   <div id="background">
  <form action="/CommercialCity/customerRegister?action=submit" method="post"> 
    <div class="kind1">
      <label class="attribute">账号</label>
      <input type="text"  name="customerAccount" class="input" id="customerAccount" placeholder="请输入账号">
    </div>
    <div class="kind">
      <label class="attribute">密码</label>
      <input type="password" name="customerPassword" class="input" id="customerPassword" placeholder="请输入密码">
    </div>
    <div class="kind">
      <label class="attribute">姓名</label>
      <input type="text" name="customerName" class="input" id="customerName" placeholder="请输入姓名">
    </div>
    <div class="kind">
      <label class="attribute">性别</label>
      <select id="customerSex" name="customerSex">
        <option>男</option>
        <option>女</option>
      </select>
    </div>
    <div class="kind">
      <label class="attribute">邮箱</label>
      <input type="text" name="customerMail" class="input" id="customerMail" placeholder="请输入邮箱" />
       <span>@</span>
       <select id="mailselect" name="mailAfter">
         <option>qq</option>
         <option>163</option>
       </select>
       <span>.com</span>
    </div>
    <div class="kind">
      <label class="attribute">信用卡账号</label>
      <input type="text" name="creditCardAccount" class="input" id="creditAccount" placeholder="请输入信用卡号">
    </div>
    <div class="kind">
      <label class="attribute">信用卡密码</label>
      <input type="password"  name="creditCardPassword" class="input" id="creditPassword" placeholder="请输入信用卡密码">
    </div>
    <div class="kind">
     <span class="attribute" >验证码</span>
     <input type="text" class="input" id="testCode" placeholder="请输入验证码" />
     <input type="button" value="点击发送验证码" id="codeButton">
   </div>
    <div class="kind">
        <input type="button" id="send" value="注 册" style="margin:0px 20px 0px 125px;">
        <input type="reset" id="res" value="清 空">
    </div>
  </form>
  </div>
</div>

</body>
</html>