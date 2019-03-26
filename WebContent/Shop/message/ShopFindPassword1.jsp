<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码-账号</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shopfindpassword.css">
<script src="${pageContext.request.contextPath}/script/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/script/shopfindpassword1.js"></script>

</head>
<body>
<h2>验证账号</h2>
<div id="background">
  <div id="content">
    <div id="progress">
      <table>
        <tr>
          <td id="progress1">验证账号</td>
          <td id="progress2">验证邮箱</td>
          <td id="progress3">重置密码</td>
        </tr>
      </table>
    </div>
    <form>
      <div class="kind">
        <label class="attribute">账号</label>
        <input type="text" id="account"  class="input" placeholder="请输入账号"> 
      </div>
      <input type="button" value="确定" class="submit">
    </form>
  </div>
</div>
</body>

</html>