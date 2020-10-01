<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Storage</title>
</head>
<body>
	<jsp:include page="header.html"/>
	<div class="container pt-3">
		<h2>Suppliers</h2>
		<a href="/Web_Storage/addSupplier" class="btn btn-outline-success" role="button">Add Supplier</a><br><br>
		<table class="table table-striped">
			<thead>
				<tr><th>id</th><th>Name</th><th>Phone</th><th></th></tr>
			</thead>
			<tbody>
				<c:forEach var="supplier" items="${supplierList}">
					<tr><td>${supplier.getSupplierId()}</td>
						<td>${supplier.getSupplierName()}</td>
						<td>${supplier.getSupplierPhone()}</td>
						<td style="text-align: right;">
							<a href="/Web_Storage/editSupplier?id=${supplier.getSupplierId()}" class="btn btn-outline-primary" role="button">Edit Supplier</a> 
							<form method="post" action='<c:url value="/deleteSupplier" />' style="display:inline;">
	        					<input type="hidden" name="id" value="${supplier.getSupplierId()}">
	        					<input type="submit" class="btn btn-outline-danger" value="Delete Supplier">
	    					</form> 
    					</td>				
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>