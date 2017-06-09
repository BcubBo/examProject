<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type=""></script>
<title>无标题文档</title>
<style type="text/css">
*{
	margin:0px;
	padding:0px}

</style>
</head>

<body>
<table width="1080" height="378" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="85" colspan="8" align="center"><h2>图书借阅系统</h2></td>
  </tr>
    <tr>
    <td height="33" colspan="8" align="right">
    当前用户：${users.user_code}<a href="${pageContext.request.contextPath}/outLogin.do">退出</a>
    </td>
   
  </tr>
  <tr>
    <td width="101" height="39">书名</td>
    <td width="100">作者</td>
    <td width="119">出版社</td>
    <td width="148">出版日期</td>
    <td width="109">页数</td>
    <td width="124">价格</td>
    <td width="156">内容摘要</td>
    <td>操作</td>
  </tr>
  <tr>
    <td height="44"></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td width="192"></td>
  </tr>
</table>

</body>
</html>
