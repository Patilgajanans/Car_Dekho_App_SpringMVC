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

</head>
<body>
	<div align="center">
		<div class='container contact_div'>
			<fieldset>
				<h4 id="titletag">Delete Car Details</h4>
				<form action="./delete" method="post">
					<div class="d-flex justify-content-around align-items-center px-5"
						style="width: 800px">
						<label>Enter Your Id</label> <input type="number" name="id">
						<input type="submit" value="Remove" class="btn btn-primary">
						</td>
					</div>
				</form>
				<%
				if (msg != null) {
				%>
				<div class="alert alert-info" role="alert"><%=msg%></div>
				<%
				}
				%>
				<%
				if (cars != null) {
					if (!cars.isEmpty()) {
				%>
				<table id="data" class="table table-striped mt-0 border">
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