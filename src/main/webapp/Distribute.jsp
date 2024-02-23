<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>

<title>ration card registration</title>
<style type="text/css">
</style>
</head>

<body>
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
	<center>
		<h1>Ration Card Distribution System</h1>
	</center>
	</nav>
	<div class="container">
		<div class="form-row" role="alert">
			<h2 class="alert alert-danger">Before distribute smart card
				verify details once!!!. <br><br>After distribute not able to modify!!!</h2>
		</div>
	</div>
	<form action="RationCardController" method="post" name="rform">
		<div class="container">
			<div class="form-row">
				<input name="rationCardId" value="${details.rationCardId}"
					id="rationCardId" type="hidden">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputRationCardNumber">Ration Card Number :</label> <input
						class="form-control" type="text"
						value="${details.rationCardNumber}" readonly>
				</div>
				<div class="form-group col-md-6">
					<label for="inputfamilyHeadName">Family Head Name</label> <input
						class="form-control" type="text" value="${details.familyHeadName}"
						readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputdob">DOB</label> <input class="form-control"
						type="text" value="${details.dob}" readonly>
				</div>
				<div class="form-group col-md-6">
					<label for="inputgender">Gender</label> <input class="form-control"
						type="text" value="${details.gender}" readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputnofoFamilyMenbers">No Of Family Members</label> <input
						class="form-control" type="text"
						value="${details.noOfFamilyMembers}" readonly>
				</div>
				<div class="form-group col-md-6">
					<label for="inputoccupation">Occupation</label> <input
						class="form-control" type="text" value="${details.occupation}"
						readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputfatherName">Father Name</label> <input
						class="form-control" type="text" value="${details.fatherName}"
						readonly>
				</div>
				<div class="form-group col-md-6">
					<label for="inputmotherName">Mother Name</label> <input
						class="form-control" type="text" value="${details.motherName}"
						readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputaddress1">Address1</label> <input
						class="form-control" type="text" value="${details.address1}"
						readonly>
				</div>
				<div class="form-group col-md-6">
					<label for="inputaddress2">Address2</label> <input
						class="form-control" type="text" value="${details.address2}"
						readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputcity">City</label> <input class="form-control"
						type="text" value="${details.city}" readonly>
				</div>
				<div class="form-group col-md-6">
					<label for="inputdistrict">District</label> <input
						class="form-control" type="text" value="${details.district}"
						readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputstate">State</label> <input class="form-control"
						type="text" value="${details.state}" readonly>
				</div>
				<div class="form-group col-md-6">
					<label for="inputpincode">Pin Code</label> <input
						class="form-control" type="text" value="${details.pincode}"
						readonly>
				</div>
			</div>


			<div class="form-group col-md-12">
				<input class="btn btn-primary" type="submit" name="submit"
					value="Distribute"></input>
				<button class="btn btn-danger"
					style="position: relative; left: 40px" type="submit" value="Cancel"
					name="submit">Cancel</button>
			</div>
		</div>
	</form>
</body>
</html>