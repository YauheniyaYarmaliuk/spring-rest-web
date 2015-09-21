<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript"
	src="<c:url value="/resources/jquery-2.1.1.js" />"></script>

<title>Home</title>

</head>
<body>
	<header class="main-header" role="banner">
		<nav class="main-menu">
			<ul>
				<li><a href="http://localhost:8080/web/">Home</a></li>
				<li><a href="http://localhost:8080/web/department">Departments</a></li>
				<li><a href="http://localhost:8080/web/employee">Employees</a></li>
				<li><a href="http://localhost:8080/web/avgSalary">AvgSalary</a></li>
			</ul>
		</nav>
	</header>

	<div class="container" style="width: 600px;">
		<div class="table-responsive">
			<table class="table table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<td>name</td>
						<td>Salary</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="avgSalary" items="${avgSalary}">
						<tr>
							<td>${avgSalary.name}</td>
							<td>${avgSalary.salary}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>

</html>
