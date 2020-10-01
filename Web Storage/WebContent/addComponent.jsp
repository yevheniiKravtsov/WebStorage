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
	<div class="container pt-3 justify-content-center">
		<form method ="post" class="needs-validation" novalidate>
		<h2>Add Component</h2><br>	
			<div class="form-group">
				<label>Part number:</label><br>
				<input type="text" class="form-control" name="partNumber"  placeholder="Enter part number" style="width:50%" required/>
				<div class="valid-feedback">Valid.</div>
    			<div class="invalid-feedback">Please fill out this field.</div>
    		</div>
    		<label>Select manufacturer:</label><br>
			<select  name="manufacturerId" class="custom-select" style="width:50%">
				<c:forEach var="manufacturer" items="${manufacturerList}">
					<option value="${manufacturer.getManufacturerId()}">${manufacturer.getManufacturerName()}</option>
				</c:forEach>
			</select><br><br>
			<label>Select supplier:</label><br>
			<select name="supplierId" class="custom-select" style="width:50%">
				<c:forEach var="supplier" items="${supplierList}">
					<option value="${supplier.getSupplierId()}">${supplier.getSupplierName()}</option>
				</c:forEach>
			</select><br><br>
    		<div class="form-group">
    			<label>Description:</label><br>	
    			<input type="text" class="form-control" name="description"  placeholder="Enter description" style="width:50%" required/>
				<div class="valid-feedback">Valid.</div>
    			<div class="invalid-feedback">Please fill out this field.</div><br>
			</div>	
			<table>
				<tr>
					<td><button type="submit" class="btn btn-outline-primary">Save</button></td>
					<td><a href="/Web_Storage/components" class="btn btn-outline-danger" role="button">Close</a></td>
				</tr>
			</table>
		</form>
			
	</div>
<script>
// Disable form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Get the forms we want to add validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
</body>
</html>