<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>${title }</title>
	</head> 
	<body>
		<h2>${message}</h2>
		<table>
			<form:form modelAttribute="formModel" action="hel">
				<tr><td><form:input path="input1" size="50" autocomplete="on" list="addd" /></td></tr> 
					<datalist id="addd">
						<option value="aaa1"/>
						<option value="aaa2"/>
						<option value="aaa3"/>
						<option value="aaa4"/>
						<option value="aaa5"/>
					</datalist>
				<tr><td><form:password path="pass1" showPassword="on"/></td></tr>
				<tr><td><form:checkbox path="check1" label="checkbox 1"/></td></tr>
				<tr><td><input type="checkbox"  name="check"/>check</td></tr>
				<tr><td><form:textarea path="area1" cols="40" rows="3"/></td></tr>
				<tr><td><form:checkboxes items="${checks }" path="checks1" itemLabel="label"
				 itemValue="data"/></td></tr>
				 <tr><td><form:select path="select" items="${checks }" itemLabel="label" 
				 itemValue="data"></form:select></td></tr>
				 <tr><td><form:radiobutton path="radio" label="男性"  value="male"/></td></tr>
				 <tr><td><form:radiobutton path="radio" label="女性"  value="female"/></td></tr>
				<tr><td><input type="submit"></td></tr>
			</form:form>
		</table>
	</body>
</html>
