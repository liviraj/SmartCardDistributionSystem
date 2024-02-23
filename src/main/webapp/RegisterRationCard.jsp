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
<script>
	var val1 = $("#gender").val();
	if (val1 == '' || val1 == 0) {
		$(document).ready(function() {
			
		});
	} else {
		$(document).ready(function() {
			$('#gender').val('${details.gender}');
			$('#occupation').val('${details.occupation}');
			$('#district').val('${details.district}');
			$('#state').val('${details.state}');
		});
	}
</script>
</head>

<body>
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
	<center>
		<h1>Ration Card Distribution System</h1>
	</center>
	</nav>
	<form action="RationCardController" method="post" name="rform">
		<div class="container">
			<div class="form-row">
				<input name="rationCardId" value="${details.rationCardId}"
					id="rationCardId" type="hidden">
			</div>
			<br>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="inputRationCardNumber">Ration Card Number</label>
					<c:choose>
						<c:when test="${not empty details.rationCardNumber}">
							<input type="text" class="form-control" id="rationCardNumber"
								name="rationCardNumber" value="${details.rationCardNumber}" ${empty details.rationCardNumber ? 'readonly' : ''}>
						</c:when>
						<c:otherwise>
							<c:set var="rationCardNumber" value="${rationCardNumber}" />
							<input type="text" class="form-control" id="rationCardNumber"
								name="rationCardNumber" value="${rationCardNumber}" ${empty rationCardNumber ? 'readonly' : ''}>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="form-group col-md-4">
					<label for="inputfamilyHeadName">Family Head Name</label> <input
						type="text" class="form-control" id="familyHeadName"
						name="familyHeadName" placeholder="Enter Family Head Name"
						value="${details.familyHeadName}">
				</div>
				<div class="form-group col-md-4">
					<label for="inputdob">DOB</label> <input type="date" path="dob"
						pattern="dd-MM-yyyy" class="form-control" id="dob" name="dob"
						placeholder="DOB" value="${details.dob}">
				</div>
			</div>
			<br>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="inputgender">Gender</label> <select id="gender"
						value="${details.gender}" name="gender" class="form-control">
						<option selected value="" hidden>Choose Gender...</option>
						<option value="Male">Male</option>
						<option value="Femal">Female</option>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="inputnofoFamilyMenbers">No Of Family Members</label> <input
						type="text" class="form-control" id="noOfFamilyMembers"
						name="noOfFamilyMembers" placeholder="No of family members"
						value="${details.noOfFamilyMembers}">
				</div>
				<div class="form-group col-md-4">
					<label for="inputoccupation">Occupation</label> <select
						value="${details.occupation}" id="occupation" name="occupation"
						class="form-control">
						<option selected value="" hidden>Choose Occupation...</option>
						<option value="Agricultural">Agricultural</option>
						<option value="Self Employee">Self Employee</option>
						<option value="Salaried Private">Salaried Private</option>
						<option value="Salaried Gov">Salaried Gov</option>
						<option value="Others">Others</option>
					</select>
				</div>
			</div>
<br>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputfatherName">Father Name</label> <input type="text"
						class="form-control" id="fatherName" name="fatherName"
						placeholder="Enter Father Name" value="${details.fatherName}">
				</div>
				<div class="form-group col-md-6">
					<label for="inputmotherName">Mother Name</label> <input type="text"
						class="form-control" id="motherName" name="motherName"
						placeholder="Enter Mother Name" value="${details.motherName}">
				</div>
			</div>
<br>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="inputaddress1">Address1</label> <input type="text"
						class="form-control" id="address1" name="address1"
						placeholder="Enter Door/Block/Flooor No Street"
						value="${details.address1}">
				</div>
				<div class="form-group col-md-4">
					<label for="inputaddress2">Address2</label> <input type="text"
						class="form-control" id="address2" name="address2"
						placeholder="Enter land mark" value="${details.address2}">
				</div>
				<div class="form-group col-md-4">
					<label for="inputcity">City</label> <input type="text"
						class="form-control" id="city" name="city"
						placeholder="Enter city" value="${details.city}">
				</div>
			</div>
<br>
			<div class="form-row">
				
				<div class="form-group col-md-4">
					<label for="inputdistrict">District</label> <select
						value="${details.district}" id="district" name="district"
						class="form-control">
						<option selected value="" hidden>Choose District...</option>
						<option value="Ariyalur">Ariyalur</option>
						<option value="Chengalpattu">Chengalpattu</option>
						<option value="Chennai">Chennai</option>
						<option value="Coimbatore">Coimbatore</option>
						<option value="Cuddalore">Cuddalore</option>
						<option value="Dharmapuri">Dharmapuri</option>
						<option value="Dindigul">Dindigul</option>
						<option value="Erode">Erode</option>
						<option value="Kallakurichi">Kallakurichi</option>
						<option value="Kanchipuram">Kanchipuram</option>
						<option value="Karur">Karur</option>
						<option value="Krishnagiri">Krishnagiri</option>
						<option value="Madurai">Madurai</option>
						<option value="Nagapattinam">Nagapattinam</option>
						<option value="Namakkal">Namakkal</option>
						<option value="Nilgiris">Nilgiris</option>
						<option value="Perambalur">Perambalur</option>
						<option value="Pudukkottai">Pudukkottai</option>
						<option value="Ramanathapuram">Ramanathapuram</option>
						<option value="Ranipet">Ranipet</option>
						<option value="Salem">Salem</option>
						<option value="Sivaganga">Sivaganga</option>
						<option value="Tenkasi">Tenkasi</option>
						<option value="Thanjavur">Thanjavur</option>
						<option value="Theni">Theni</option>
						<option value="Thoothukudi">Thoothukudi</option>
						<option value="Tiruchirappalli">Tiruchirappalli</option>
						<option value="Tirunelveli">Tirunelveli</option>
						<option value="Tirupathur">Tirupathur</option>
						<option value="Tiruppur">Tiruppur</option>
						<option value="Tiruvallur">Tiruvallur</option>
						<option value="Tiruvannamalai">Tiruvannamalai</option>
						<option value="Tiruvarur">Tiruvarur</option>
						<option value="Vellore">Vellore</option>
						<option value="Viluppuram">Viluppuram</option>
						<option value="Virudhunagar">Virudhunagar</option>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="inputstate">State</label> <select id="state"
						value="${details.state}" name="state" class="form-control">
						<option selected value="" hidden>Choose State...</option>
						<option selected value="Tamil Nadu">Tamil Nadu</option>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label for="inputpincode">Pin Code</label> <input type="text"
						class="form-control" id="pincode" name="pincode"
						placeholder="Enter pin code" value="${details.pincode}">
				</div>
			</div>


			<div class="form-group col-md-12">
				<input class="btn btn-primary" type="submit" name="submit"
					value="${name}"></input>
				<button class="btn btn-warning" type="reset"
					style="position: relative; left: 20px">Reset</button>
				<button class="btn btn-danger"
					style="position: relative; left: 40px" type="submit" value="Cancel"
					name="submit">Cancel</button>
			</div>
		</div>
	</form>
</body>
</html>