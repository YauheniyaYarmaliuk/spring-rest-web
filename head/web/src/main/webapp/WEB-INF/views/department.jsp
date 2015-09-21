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
	<div class="container" style="width: 500px;">

		<div class="table-responsive">
			<table class="table table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="departments" items="${departments}">
						<tr>
							<td>${departments.id}</td>
							<td>${departments.name}</td>
							<td><button value="btn" class="btn btn-danger btn-sm"
									onclick="delDepartment(${departments.id});">Delete</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<span>New department</span>
			<form action="#" id="createDeptForm">
				<div class="form-group">
					<label for="name"></label> <input type="text" name="name"
						placeholder="Name" class="form-control" />
				</div>
				<input type="submit" value="Save" class="btn btn-success btn-sm"
					class="btn btn-success btn-sm" onclick="location.reload();" />
			</form>
		</div>
	</div>

	<script>
			
		$("#createDeptForm")
			.submit (
					function(event) {
						event.preventDefault();
						var name = $("input[name=name]", this)[0].value;
						$.ajax({
								type : 'POST',
								url : '<c:url value="/department/insert/"/>'+ name,
											
							   })
					});

		function delDepartment(depId) {
			$.ajax({
				type: 'DELETE',
		  		url: '<c:url value="/department/delete/"/>' + depId,
		  	}).done(function() {
		  	    location.reload();
		  	});	
		}
			
	</script>

</body>
</html>
