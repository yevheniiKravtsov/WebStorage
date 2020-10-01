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
		<h2>Storages</h2>
		<a href="/Web_Storage/addStorage" class="btn btn-outline-success" role="button">Add Storage</a><br><br>
		<table class ="table table-striped" id="storageTable">
			<thead>		
				<tr><th>id</th><th>Adres</th><th></th><th></th></tr>
			</thead>
			<tbody>
				<c:forEach var="storage" items="${storageList}">
					<tr class= "clickable-row">
						<td>${storage.getStorageId()}</td>
						<td>${storage.getStorageAdres()}</td>
						<td style="text-align: right;">
							<a href="/Web_Storage/editStorage?id=${storage.getStorageId()}" class="btn btn-outline-primary" role="button">Edit Storage</a> 
							<form method="post" action='<c:url value="/deleteStorage" />' style="display:inline;">
	        					<input type="hidden" name="id" value="${storage.getStorageId()}">
	        					<input type="submit" class="btn btn-outline-danger" value="Delete Storage">
	    					</form> 
    					</td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>	
</body>
</html>