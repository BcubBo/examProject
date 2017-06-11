<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆界面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loginCheck.js"></script>
</head>

<body>


<div >
<input type="hidden" value="${pageContext.request.contextPath}" id="hidden"></input>
<input type="hidden" value="${alert}" id="alert"></input>
 <form action="admin.do" method="post" id="form1" >
 <table width="606" height="199" border="0" cellpadding="0" cellspacing="0" >
 
  <tr>
    <td colspan="2" ><h1>图书借阅系统</h1></td>
  </tr>
  <tr>
    <td >登录账号：</td>
    <td ><input type="text" name="user_code" id="user_code"/></td>
    <td color="red"></td>
    <td id="checkBoxUser" width="300px"></td>
  </tr>
  <tr>
    <td>登录密码：</td>
    <td><input type="password" name="password" id="user_password"/></td>
    <td id="password_next"></td>
    <td id="checkBox" width="300px"></td>
  </tr>
  <tr>
    <td colspan="2" >
       <input type="button" value="登录|Login" id="loginButton"/> 
      <input type="button" value="注册用户" id="register" onclick="javascript:window.location='register.jsp'" />
    </td>
  </tr>

  </table>
 </form>





</div>



</body>

</html>
