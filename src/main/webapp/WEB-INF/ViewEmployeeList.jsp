<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

<style>
a {
	color: white;
}

a:hover {
	color: white;
	text-decoration: none;
}

.table-heading {
	background-color: lime;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="p-3 text-center">Employees Table</h1>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="table-heading">Id</th>
					<th class="table-heading">First Name</th>
					<th class="table-heading">Last Name</th>
					<th class="table-heading">Salary</th>
					<th class="table-heading">Department</th>
					<th class="table-heading">Position</th>
					<th class="table-heading">Email</th>
					<th class="table-heading">Contact Number</th>
					<th class="table-heading">Picture</th>
					<th class="table-heading">Edit</th>
					<th class="table-heading">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${employeeList}">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.first_name}</td>
						<td>${employee.last_name}</td>
						<td>${employee.salary}</td>
						<td>${employee.department}</td>
						<td>${employee.position}</td>
						<td>${employee.email}</td>
						<td>${employee.contactNumber}</td>
						<td><img alt="" src="/imagedata/${employee.picture}"
							style="width: 100px; height: 100px;"></td>

						<td>
							<button type="button" class="btn btn-success">
								<a href="/editEmployee/${employee.id}">Edit</a>
							</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger">
								<a href="/deleteEmployee/${employee.id}">Delete</a>
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<button type="button" class="btn btn-primary btn-block">
			<a href="/addEmployee">Register New Employee</a>
		</button>
	</div>
	<script th:inline="javascript">
		window.onload = function() {

			var msg = "${message}";
			console.log(msg);
			if (msg == "save success") {
				Command: toastr["success"]
						("Employee Data added successfully!!")
			} else if (msg == "Delete success") {
				Command: toastr["success"]
						("Employee Data deleted successfully!!")
			} else if (msg == "Delete failure") {
				Command: toastr["error"]
						("Some error occurred, couldn't delete Employee Data")
			} else if (msg == "Edit success") {
				Command: toastr["success"]
						("Employee Data updated successfully!!")
			}

			toastr.options = {
				"closeButton" : true,
				"debug" : false,
				"newestOnTop" : false,
				"progressBar" : true,
				"positionClass" : "toast-top-right",
				"preventDuplicates" : false,
				"showDuration" : "300",
				"hideDuration" : "1000",
				"timeOut" : "5000",
				"extendedTimeOut" : "1000",
				"showEasing" : "swing",
				"hideEasing" : "linear",
				"showMethod" : "fadeIn",
				"hideMethod" : "fadeOut"
			}
		}
	</script>

</body>
</html>
