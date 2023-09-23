<%@page import="com.jspider.car_dekho_mvc.pojo.CarPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
String msg = (String) request.getAttribute("msg");
%>
<jsp:include page="Navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
	.data{
		padding: 10px;
	}
	.alert-info{
	padding: 15px !important ;
	}
</style>
</head>
<body>
	<div class='my-5'>
		<h1 class='text-center'>Add Car In DataBase</h1>
	</div>
	
	<div class='container contact_div'>
		<div class='row'>
			<div class='col-md-5 col-8 mx-auto'>
				<form action="./add" method="post" class="data">
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label">Car Name </label>
						<div class="col-sm-9">
							<input type="text" class="form-control"
								id="exampleFormControlInput1" name='carName'
								placeholder="Enter Car Name / Model Name" />
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label">Brand Name</label> 
						<div class="col-sm-9">
						<input type="text"
							class="form-control" id="exampleFormControlInput1"
							name='brandName' placeholder="Brand name" />
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label">Fuel Type</label> 
						<div class="col-sm-9">
						<input type="text"
							class="form-control" id="exampleFormControlInput1"
							name='fuelType' placeholder="Petrol/Dizel/LPG/Electrical" />
					</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label">Enter Price </label> 
						<div class="col-sm-9">
						<input
							type="number" class="form-control" id="exampleFormControlInput1"
							name='price' placeholder="Price In INR" />
					</div>
					</div>
					<div class="d-grid gap-2 col-6 mx-auto">
						<button class="btn btn-outline-primary" type="submit">Add
							Car</button>
					</div>
				</form>
			</div>
		</div>
		<%
		String str = request.getParameter("carName");

		if (msg != null) {
			msg = str + " " + msg;
		%>
		<div class="alert alert-info" role="alert"><%=msg%></div>
		<%
		}
		%>

		<%
		if (!cars.isEmpty()) {
		%>
		<table id="data" class="table table-striped border">
			<tr>
				<th>Id</th>
				<th>Car Name</th>
				<th>Brand Name</th>
				<th>Fuel Type</th>
				<th>Price</th>
			</tr>
			<%
			for (CarPOJO car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getModelName()%></td>
				<td><%=car.getBrandName()%></td>
				<td><%=car.getFuelType()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>

	</div>


</body>
</html>