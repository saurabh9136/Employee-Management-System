<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Employee | Edit</title>

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

</head>
<body>

	<div class="container">

		<h1 class="p-3">Edit an Employee</h1>

		<form:form action="/editSaveEmployee" method="post"
			modelAttribute="employee" enctype="multipart/form-data">
			<div class="row">
				<div class="form-group col-md-12">
					<div class="col-md-6">
						<form:hidden path="id" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="first_name">First Name</label>
					<div class="col-md-6">
						<form:input type="text" path="first_name" id="first_name"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="last_name">Last Name</label>
					<div class="col-md-6">
						<form:input type="text" path="last_name" id="last_name"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="salary">Salary</label>
					<div class="col-md-6">
						<form:input type="number" path="salary" id="salary"
							class="form-control input-sm" required="required" step="any" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="department">Department</label>
					<div class="col-md-6">
						<form:input type="text" path="department" id="department"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="position">Position</label>
					<div class="col-md-6">
						<form:input type="text" path="position" id="position"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="email">Email</label>
					<div class="col-md-6">
						<form:input type="email" path="email" id="email"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="contactNumber">Contact Number</label>
					<div class="col-md-6">
						<form:input type="number" path="contactNumber" id="contactNumber"
							class="form-control input-sm" required="required" maxlength="10" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3" for="picture">Picture</label>
					<div class="col-md-6">
						<!-- Check if the image should be updated or not -->
						<!-- Display the current image using an <img> tag -->
						<img id="currentImage" src="/imagedata/${employee.picture}"
							style="width: 100px; height: 100px;">
						<!-- File input field -->
						<input type="file" id="picture" name="file" accept="image/*">
					</div>
				</div>
			</div>


			<div class="row p-2">
				<div class="col-md-2">
					<button type="submit" value="Register" class="btn btn-success">Update</button>
				</div>
			</div>

		</form:form>

	</div>
	<script>
		window.onload = function() {

			var msg = "${message}";
			console.log(msg);
			if (msg == "Edit failure") {
				Command: toastr["error"]("Something went wrong with the edit.")
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