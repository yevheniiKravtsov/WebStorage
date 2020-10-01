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
		<h2>Storage Elements</h2>
		<a href="/Web_Storage/addStorageElement" class="btn btn-outline-success" role="button">Add Storage Element</a><br><br>
		<form method="post">
		<div class="row justify-content-start">
	    	
			<div class="col-3">
				Date from:
			    <input class="form-control" type="date" id="date-input" name="dateFrom">
			</div>
			<div class="col-3">
				Date to:
			    <input class="form-control" type="date" id="date-input" name="dateTo">
			</div>
			<div class="col-3">
				<br>
			    
	        		<input type="submit" class="btn btn-outline-primary" value="Select">
	    		
			</div>
			
		</div><br>
	</form>
		<table class="table table-striped">
			<thead>
				<tr><th>id</th><th>Date</th><th>Part Number</th><th>Number</th><th>Price</th><th>Storage</th><th></th></tr>
			</thead>
			<tbody>	
				<c:forEach var="storageElement" items="${storageElementsList}">
					<tr><td>${storageElement.getStorageElementId()}</td>
						<td>${storageElement.getElementAddingTime()}</td>
						<td>${storageElement.getComponent().getPartNumber()}</td>
						<td>${storageElement.getNumberOfComponents()}</td>
						<td>${storageElement.getStorageElementPrice()}</td>
						<td>${storageElement.getStorage().getStorageAdres()}</td>
						<td style="text-align: right;">
							<a href="/Web_Storage/infoStorageElement?id=${storageElement.getStorageElementId()}" class="btn btn-outline-primary" role="button">Information</a> 
							<form method="post" action='<c:url value="/deleteStorageElement" />' style="display:inline;">
	        					<input type="hidden" name="id" value="${storageElement.getStorageElementId()}">
	        					<input type="submit" class="btn btn-outline-danger" value="Delete">
	    					</form> 
    					</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>