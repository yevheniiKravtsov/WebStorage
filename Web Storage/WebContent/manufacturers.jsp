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
		<h2>Manufacturers</h2>
		<a href="/Web_Storage/addManufacturer" class="btn btn-outline-success" role="button">Add Manufacturer</a><br><br>	
		<table class ="table table-striped">
			<thead>
				<tr><th>id</th><th>Name</th><th>Phone</th><th></th></tr>
			</thead>
			<tbody>	
				<c:forEach var="manufacturer" items="${manufacturerList}">
					<tr><td>${manufacturer.getManufacturerId()}</td>
						<td>${manufacturer.getManufacturerName()}</td>
						<td>${manufacturer.getManufacturerPhone()}</td>
						<td style="text-align: right;">
							<a href="/Web_Storage/editManufacturer?id=${manufacturer.getManufacturerId()}" class="btn btn-outline-primary" role="button">Edit Manufacturer</a> 
							<form method="post" action='<c:url value="/deleteManufacturer" />' style="display:inline;">
	        					<input type="hidden" name="id" value="${manufacturer.getManufacturerId()}">
	        					<input type="submit" class="btn btn-outline-danger" value="Delete Manufacturer">
	    					</form> 
    					</td>				
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>