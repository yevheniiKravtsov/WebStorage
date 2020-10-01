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
			<div class="form-group">
				<h2>Edit Supplier</h2><br>
				<input type="hidden" value="${supplier.getSupplierId()}" name="id" />
				<input type="text" class="form-control" value="${supplier.getSupplierName()}" name="name"  placeholder="Enter adres" style="width:50%" required/>
				<div class="valid-feedback">Valid.</div>
    			<div class="invalid-feedback">Please fill out this field.</div><br>
    			<input type="text" class="form-control" value="${supplier.getSupplierPhone()}" name="phone"  placeholder="Enter adres" style="width:50%" required/>
				<div class="valid-feedback">Valid.</div>
    			<div class="invalid-feedback">Please fill out this field.</div><br>
				<tr>
					<td><button type="submit" class="btn btn-outline-primary">Save</button></td>
					<td><a href="/Web_Storage/suppliers" class="btn btn-outline-danger" role="button">Close</a></td>
				</tr>
			</div>
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