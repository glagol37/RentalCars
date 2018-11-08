<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RentalCars</title>
<style>
<%@include file='static/CSS/style.css'%>
</style>
</head>
<body>
	<header>
		<jsp:include page="fragment/header.jsp" />
	</header>
	<jsp:include page="${currentPage }" />

</body>
</html>