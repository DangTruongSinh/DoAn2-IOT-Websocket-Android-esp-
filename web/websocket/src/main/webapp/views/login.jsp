<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/views/login.css">
</head>
<body>
	<div class="divlogin">
		<p class="loginform">Login form</p>
		<c:if test="${not empty message}">
			<p class="thongbao">Tài khoản không chính xác</p>
		</c:if>
		<form action="/login" method="post">
			<input type="text" name="taikhoan" placeholder="Your account">
			<br>
			<input type="Password" name="matkhau" placeholder="Password">
			<br>
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>