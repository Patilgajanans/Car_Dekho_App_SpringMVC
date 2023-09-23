<%@page import="java.util.List"%>
<%@page import="com.jspider.car_dekho_mvc.pojo.CarPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Navbar.jsp" />
<%
String msg = (String) request.getAttribute("msg");
List<CarPOJO> cars = (List<CarPOJO>) request.getAttribute("cars");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
	#jfpad{
		padding: 20px !important;
	}
	
</style>
</head>
<body>
	<div align="center"  >
	<div class='container contact_div'>
		<fieldset>
			<h3>Search Car Details</h3>
				<form action="./search" method="post">
					<div class="d-flex justify-content-around align-items-center" style="width: 800px">
							<label>Select Option :</label>
							<select id="selectOption" name="selectedOption" style="width: 100px">
									<option value="All">All Cars</option>
									<option value="id">Car ID</option>
									<option value="name">Car Name</option>
									<option value="brand">Car Brand</option>
									<option value="fuel">Fuel Type</option>
									<option value="price">price</option>
							</select>
							<label>Enter Your value :</label>
							<input type="text" name="value">
							<input type="submit" value="Search"
								class="btn btn-primary">
						</div>

				</form>
			
			<%
			if (msg != null) {
			%>
			<div id="jfpad">
				<div class="alert alert-info" role="alert"><%=msg%></div>
			</div>
			<%
			}
			%>
			<%
			if (cars != null) {
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
			}
			%>
		</fieldset>
	</div>
	</div>
</body>
</html>