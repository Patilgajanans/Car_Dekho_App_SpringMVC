<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	<style >
		 *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Mulish', sans-serif;
 }

 .navbar {
    background-color: #fff !important;
 }

 .navbar-brand{
    font-size: 1.9rem !important;
    color: #565387 !important;
 }

 .navbar a{
    font-size: 1.3rem;
    text-transform: capitalize;
 }
  .navbar a:hover{
    color: #3498db !important;
 }
 
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Car Dekho</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./add">Add Car</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./update">Update</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./search">Search</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./delete">Delete</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./logout">LogOut</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>