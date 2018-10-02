<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<style>
	h1 {font-size: 16pt; background-color: #CCCCFF; padding: 3px;}
	p {color: #000066}
</style>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!--   <link rel="stylesheet" href="/resources/demos/style.css"> -->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	$( "#datepicker" ).datepicker({
		dateFormat : "yy/mm/dd"
	});
//     $( "#datepicker" ).datepicker("option", "dateFormat", "yy/mm/dd");
  } );
  </script>
</head>
<body>
	<h1>${title }</h1>
	<p>${message }</p>
	<table>
		<form:form modelAttribute="formModel">
<%-- 		<tr><td></td><td><form:errors path="*" element="div"></form:errors></td></tr> --%>
			<tr><td><form:label path="item">商品名</form:label></td>
				<td><form:input path="item" size="20"></form:input>
				<form:errors path="item" cssStyle="color:red"></form:errors></td></tr>
			<tr><td><form:label path="price">金額</form:label></td>
				<td><form:input path="price" size="20"></form:input>
				<form:errors path="price" cssStyle="color:red"></form:errors></td></tr>
			<fmt:formatDate value="${formModel.buyDate }" pattern='yyyy/MM/dd' var="dateItem"/>
			<tr><td><form:label path="buyDate">日付</form:label></td>
				<td><form:input path="buyDate" value="${dateItem }" size="20" id="datepicker" ></form:input>
				<form:errors path="buyDate" cssStyle="color:red"></form:errors></td></tr>
			<tr><td><form:label path="mail">メール</form:label></td>
				<td><form:input path="mail" size="20"></form:input>
				<form:errors path="mail" cssStyle="color:red"></form:errors></td></tr>
			<tr><td><form:label path="memo">メモ</form:label></td>
				<td><form:textarea path="memo" size="20" rows="5"></form:textarea></td></tr>
			<tr><td><input type="submit"/></td></tr>
		</form:form>
	</table>
	<hr>
	<c:if test="${dataList != null }">
		<table border="1">
			<tr><th>商品名</th><th>価格</th></tr>
			<c:forEach var="obj" items="${dataList }" varStatus="status">
				<tr>
					<td><c:out value="${obj.item }"></c:out></td>
					<td><c:out value="${obj.price }"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>