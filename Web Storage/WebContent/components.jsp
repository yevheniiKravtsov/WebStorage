<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"><link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Web Storage</title>
</head>
<body>
	<jsp:include page="header.html"/>
	<div class="container pt-3">
		<h2>Components</h2>
		<a href="/Web_Storage/addComponent" class="btn btn-outline-success" role="button">Add Component</a><br><br>
		<table class ="table table-striped">
			<thead>
				<tr><th>id</th><th>Part Number</th><th>Manufacturer</th><th>Supplier</th><th>Description</th><th></th></tr>
			</thead>
			<tbody>
				<c:forEach var="component" items="${componentList}">
					<tr><td>${component.getComponentId()}</td>
						<td>${component.getPartNumber()}</td>
						<td>${component.getManufacturer().getManufacturerName()}</td>
						<td>${component.getSupplier().getSupplierName()}</td>
						<td>${component.getComponentDescription()}</td>
						<td style="text-align: right;">
							<a href="/Web_Storage/editComponent?id=${component.getComponentId()}" class="btn btn-outline-primary" role="button">Edit Component</a> 
							<form method="post" action='<c:url value="/deleteComponent" />' style="display:inline;">
	        					<input type="hidden" name="id" value="${component.getComponentId()}">
	        					<input type="submit" class="btn btn-outline-danger" value="Delete Component">
	    					</form> 
    					</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
	</div>

</body>
</html>