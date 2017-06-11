<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/adminCheck.js"></script>
<title>图书展示</title>
<style type="text/css">
*{
	margin:0px;
	padding:0px
}
	


</style>
</head>

<body >
<div align="center">
<table  width ="1200px" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td width="1000px" height="85" colspan="11" align="center"><h2>图书借阅系统</h2></td>
  </tr>
    <tr>
    <td width="1000px" height="33" colspan="11" align="right">
    当前用户${userCode}<a href="${pageContext.request.contextPath}/logout.do">退出</a>
    </td>
   
  </tr>
  <tr>
    <td width="200px">书名</td>
    <td width="200px">图书代码</td>
    <td width="200px">图书类型</td>
    <td width="200px">图书类型编码</td>   
    <td width="200px">图书作者编码</td>
    <td width="200px">发布日期</td>
    <td width="200px">是否借阅代码</td>
    <td width="200px">创建者</td>
    <td width="200px">创建日期</td>
    <td width="200px">最后更新日期</td>
    <td width="200px">借阅</td>

    



    
  </tr>
  <c:forEach var="book" items="${bookInfoList}"	varStatus="index">
  <c:if test="${index.index %2 == 0}">

  	<tr style="background-color:yellowgreen">
    <td>${book.bookName}</td>
    <td>${book.bookCode}</td>
    <td>${book.typeName}</td>
    <td>${book.bookType}</td>
    <td>${book.bookAuthor}</td>
    <td>${book.publishPress}</td>
    <td>${book.isBorrow}</td>
    <td>${book.createBy}</td> 
    <td>${book.creationTime}</td>
    <td>${book.lastUpdateTime}</td>
    <td><a href="javascript:;">申请借阅</a></td>
    
    
  </tr>
  </c:if>
  <c:if test="${index.index %2 != 0}">
  <tr style="background-color:gold">
    <td>${book.bookName}</td>
    <td>${book.bookCode}</td>
    <td>${book.typeName}</td>
    <td>${book.bookType}</td>
    <td>${book.bookAuthor}</td>
    <td>${book.publishPress}</td>
    <td>${book.isBorrow}</td>
    <td>${book.createBy}</td> 
    <td>${book.creationTime}</td>
    <td>${book.lastUpdateTime}</td>
    <td><a href="javascript:;">申请借阅</a></td>
    </tr>
    </c:if>
    
  
  
  
  
  
  </c:forEach>
  
</table>
</div>
</body>
</html>
