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
		<h2>Element Information</h2><br>
		<div class="row justify-content-start">
	    	<div class="col-4">
	    		<label>Element ID:</label>
	    		<h4>${storageElement.getStorageElementId()}</h4>
	    	</div>
	    	<div class="col-4">
	      		<label>Date of create:</label>
	    		<h4>${storageElement.getElementAddingTime()}</h4>
	    	</div>
	    	<div class="col-4">
	      		<label>Storage:</label>
	    		<h4>${storageElement.getStorage().getStorageAdres()}</h4>
	    	</div>
	  	</div><br>
	  	<div class="row justify-content-start">
	    	<div class="col-4">
	    		<label>Component part number:</label>
	    		<h4>${storageElement.getComponent().getPartNumber()}</h4>
	    	</div>
	    	<div class="col-4">
	      		<label>Number of components:</label>
	    		<h4 style="color:green">${storageElement.getNumberOfComponents()}</h4>
	    	</div>
	    	<div class="col-4">
	      		<label>Price:</label>
	    		<h4 style="color:green">${storageElement.getStorageElementPrice()}</h4>
	    	</div>
	  	</div><br>
	  	<div class="row justify-content-start">
	    	<div class="col-4">
	    		<label>Manufacturer:</label>
	    		<h4>${storageElement.getComponent().getManufacturer().getManufacturerName()}</h4>
	    	</div>
	    	<div class="col-4">
	      		<label>Manufacturer phone:</label>
	    		<h4>${storageElement.getComponent().getManufacturer().getManufacturerPhone()}</h4>
	    	</div>
	  	</div><br>
	  	<div class="row justify-content-start">
	    	<div class="col-4">
	    		<label>Supplier:</label>
	    		<h4>${storageElement.getComponent().getSupplier().getSupplierName()}</h4>
	    	</div>
	    	<div class="col-4">
	      		<label>Supplier phone:</label>
	    		<h4>${storageElement.getComponent().getSupplier().getSupplierPhone()}</h4>
	    	</div>
	  	</div><br>
	  	<td><a href="/Web_Storage/main" class="btn btn-outline-primary" role="button">Back</a></td>
		
	</div>
</body>
</html>