<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee | Home</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f1f1f1;
	margin: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.wel-container {
	text-align: center;
	background-color: ffffff;
	border: 1px, solid #dddddd;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.welcome-text {
	font-size: 100px;
	font-weight: bold;
	margin-bottom: 20px;
}

.options-container {
	display: flex;
	text-decoration: none;
	justify-content: space-around;
}

.option-button {
	padding: 10px 20px;
	border: none;
	border-radius: 50px;
	background-color: #007bff;
	color: #ffffff;
	font-size: 30px;
	cursor: pointer;
	transition: background-color 0.3s ease;
	text-decoration: none;
}

.option-button:hover {
	background-color: #0056b3;
}

a {
	color: white;
}

a:hover {
	color: white;
	text-decoration: none;
}
</style>
</head>
<body>

	<div class="wel-container">
		<h1>Welcome To Employee Management System</h1>
		<div class="opt-container">

			<a class="option-button" href="/viewEmployeeList">Check Database</a>
		</div>
	</div>



</body>
</html>