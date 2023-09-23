<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Dekho Application </title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container-fluid mt-3">
		<h3 class="text-center">Login</h3>
		<div
			class="container d-flex justify-content-center mt-5 card p-5 shadow"
			style="width: 400px">
			<form action="./login" method="post">
				<%
				if (msg != null) {
				%>

				<div class="alert alert-info" role="alert">
					<%=msg%>
				</div>
				<%
				}
				%>
				<div class="mb-3">
					<label  class="form-label">Username
					</label> <input type="text" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="username">
					<div id="emailHelp" class="form-text">We'll never share your
						email with anyone else.</div>
				</div>
				<div class="mb-3">
					<label  class="form-label">Password</label>
					<input type="password" class="form-control"
						id="exampleInputPassword1" name="password">
				</div>
				<button type="submit" class="btn btn-info">Login</button>
				<a href="./createAccount"
					class="link-info d-block">Create New Account</a>
			</form>

		</div>
	</div>

</body>
</html>