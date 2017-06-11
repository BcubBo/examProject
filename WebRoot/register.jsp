<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册用户</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/registerCheck.js"></script>
</head>

<body>

<form action="${pageContext.request.contextPath}/register.do" id="formSubmit" method="post" >
<input type="hidden" value="${pageContext.request.contextPath}" id="hidden" ></input>
<input type="hidden" name="methodCheck" value="register" />
<table  height="314" border="0" cellpadding="0" cellspacing="0">

  <tr>
    <td colspan="2" ><h1>会员注册</h1></td>
    
  </tr>
  <tr>
    <td>登录账号</td>
    <td><input type="text" name="user_code" id="userCode"/><span id="userCodeBox">*</span></td>
  </tr>
  <tr>
    <td>密 码<span>(*)</span></td>
    <td><input type="password" name="password" id="password"/>    <span id="passwordBox">*</span></td>
  </tr>
  <tr>
    <td>确定密码<span>(*)</span></td>
    <td><input type="password" name="password2" id="password2"/>   <span id="password2Box">*</span></td>
  </tr>
  <tr>
    <td>性别</td>
    <td>
    
    <select name="gender">
    <option value="请选择">--请选择--</option>
     <option value="1">男</option> 
     <option value="2">女</option>
    </select>
    <span id="genderBox">*</span> </td>
  </tr>
  <tr>
    <td>电子邮箱</td>
    <td><input type="text" name="email" id="email"/>
    <span id="emailBox"></span></td>
    
  </tr>


  <tr>
    <td colspan="2" align="left">
    <input  type="submit" value="注册" id="submit"/> 
    <input  type="button" value="返回"/>
    </td>
  </tr>
  </table>
</form>

</body>
</html>