<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<div
			class="container d-flex justify-content-center mt-5 card p-5 shadow"
			style="width: 400px">
	<form action="./createAccount" method="post">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">User Name</label>
			<input type="text" name="username" class="form-control"
				id="exampleInputEmail1">
			<div id="emailHelp" class="form-text">We'll never share your
				information with anyone else.</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input type="password" class="form-control" name="password">
		</div>
		<%
		if (msg != null) {
		%>
		<div class="alert alert-info" role="alert">
			<%=msg%>
		</div>
		<%
		}
		%>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	</div>
</body>
</html>