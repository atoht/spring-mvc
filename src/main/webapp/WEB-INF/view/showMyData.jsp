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
		<form:form modelAttribute="myData">
		<form:hidden path="id"/>
			<tr><td><form:label path="name">名前</form:label></td>
				<td><form:input path="name" size="20"></form:input>
				<form:errors path="name" cssStyle="color:red"></form:errors></td></tr>
			<tr><td><form:label path="age">年齢</form:label></td>
				<td><form:input path="age" size="20"></form:input>
				<form:errors path="age" cssStyle="color:red"></form:errors></td></tr>
			<tr><td><form:label path="mail">メール</form:label></td>
				<td><form:input path="mail" size="20"></form:input>
				<form:errors path="mail" cssStyle="color:red"></form:errors></td></tr>
			<tr><td><form:label path="memo">メモ</form:label></td>
				<td><form:textarea path="memo" size="20" rows="5"></form:textarea>
				<form:errors path="memo" cssStyle="color:red"></form:errors></td></tr>
			<tr><td><input type="submit"/></td></tr>
		</form:form>
	</table>
	<hr>
	<c:if test="${allMyData != null }">
		<table border="1">
			<tr><th>ID</th><th>名前</th></tr>
			<c:forEach var="obj" items="${allMyData }" varStatus="status">
				<tr>
					<td><c:out value="${obj.id }"></c:out></td>
					<td><c:out value="${obj.name }"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>