<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script type="text/javascript" src="<c:url value="/resources/jquery-2.1.1.js" />"></script>

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

	<div class="container" style="width: 400px;">
		<form action="searchBirth" method="get">
	      <input type="text" name="birth" placeholder="Birth">
	      <input type="submit" value="Search" class="btn btn-success btn-sm" >
  		</form>
   </div>

	<div class="container" style="width: 800px;">

		<div class="table-responsive">
			<table class="table table-condensed table-striped table-bordered">
				<thead>
					<tr>
						<td>Id</td>
						<td>deptId</td>
						<td>Name</td>
						<td>Patronymic</td>
						<td>Surname</td>
						<td>Birth</td>
						<td>Salary</td>
						<td>Delete</td>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="employees" items="${employees}">
						<tr>
							<td>${employees.id}</td>
							<td>${employees.deptId}</td>
							<td>${employees.name}</td>
							<td>${employees.patronymic}</td>
							<td>${employees.surname}</td>
							<td>${employees.birth}</td>
							<td>${employees.salary}</td>
							<td><button value="btn" class="btn btn-danger btn-sm"
									onclick="delEmployee(${employees.id});">Delete</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<span>New employee</span>
			<form action="#" id="createEmplForm">
				<div class="form-group">
					<label for="deptId"></label> <input type="text" name="deptId"
						placeholder="Id Department" class="form-control" />
				</div>
				<div class="form-group">
					<label for="name"></label> <input type="text" name="name"
						placeholder="Name" class="form-control" />
				</div>
				<div class="form-group">
					<label for="patronymic"></label> <input type="text"
						name="patronymic" placeholder="Patronymic" class="form-control" />
				</div>
				<div class="form-group">
					<label for="surname"></label> <input type="text" name="surname"
						placeholder="Surname" class="form-control" />
				</div>
				<div class="form-group">
					<label for="birth"></label> <input type="text" name="birth"
						placeholder="Birth"  class="form-control" />
				</div>
				<div class="form-group">
					<label for="salary"></label> <input type="text" name="salary"
						placeholder="Salary" class="form-control" />
				</div>

				<input type="submit" value="Save" class="btn btn-success btn-sm" class="btn btn-success btn-sm" onclick="location.reload();"/>
			</form>
		</div>
	</div>
	<script>
		
		$("#createEmplForm")
					.submit(
							function(event) {
								event.preventDefault();
								var deptId = $("input[name=deptId]", this)[0].value;
								var name = $("input[name=name]", this)[0].value;
								var surname = $("input[name=surname]", this)[0].value;
								var patronymic = $("input[name=patronymic]", this)[0].value;
								var birth = $("input[name=birth]", this)[0].value;
								var salary = $("input[name=salary]", this)[0].value;
	
								$
										.ajax(
												{
													type : 'POST',
													url : '<c:url value="/employee/insert/"/>'
															+ deptId
															+ "/"
															+ name
															+ "/"
															+ surname
															+ "/"
															+ patronymic
															+ "/"
															+ birth + "/" + salary,
												}) 
											  	
	
							});
						
			function delEmployee(empId) {
				$.ajax({
					type: 'DELETE',
			  		url: '<c:url value="/employee/delete/"/>' + empId,
			  	}).done(function() {
			  	    location.reload();
			  	});	 
			}
			
	</script>


</body>

</html>
