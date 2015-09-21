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
				<li><a href="http://localhost:8080/web/avgSalary">Avg Salary</a></li>
			</ul>
		</nav>
	</header>
	<div class="container" style="width: 800px;">
		<h1>Hello,</h1>
		<p>you look for a few examples RESTful requests in the table</p>
		
		<div class="table-responsive">

			<table class="table table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<td>rest</td>
						<td>description</td>
					</tr>
				</thead>
				<tbody>

					<tr class="success">
						<td>rest/departments</td>
						<td>show all departments</td>
					</tr>

					<tr class="error">
						<td>rest/employees</td>
						<td>show all employees</td>
					</tr>


					<tr class="info">
						<td>rest/departments/{id}</td>
						<td>show one department</td>
					</tr>

					<tr class="warning">
						<td>rest/employees/{id}</td>
						<td>show one employee</td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>