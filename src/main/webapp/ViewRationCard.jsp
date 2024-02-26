<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view</title>
<style type="text/css">
</style>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>

<script>
	function msg1(id){
		var idValue = id;
		var c=confirm("Are You Sure");
		if(c==true)
			{
				location.href="RationCardController?action=delete&rationCardId="+idValue; 
			}
		
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<center>
			<h1>Smart Ration Distribution System</h1>
		</center>
		̥ </nav>
		̥
		<center>
			<p>
				<font size="5">Ration Card Holder Information</font>
			</p>
		</center>
		<center>
			<span style="color: red">${msg} </span>
		</center>
		<div class="form-row">
			<div class="col-md-10"></div>
			<div class="col-md-1">
				<a href="RationCardController?action=viewStock"><button class="btn btn-info">View
						Ration Stock</button></a>
			</div>
			<div class="col-md-1">
				<form action="LogoutController">
					<input type="submit" name="submit" value="logout"
						class="btn btn-danger">
				</form>
				<input type="hidden" name="confirm" id="confirm" value=""></input>
			</div>
		</div>
<br><br>
		<center>
			<table border="3" class="table table-striped">
				<thead class="thead-dark">
					<tr class="warning">
						<th>Ration Card Number</th>
						<th>Family Head Name</th>
						<th>Date Of Birth</th>
						<th>Gender</th>
						<th>Father Name</th>
						<th>Mother Name</th>
						<th>Occupation</th>
						<th>No Of Family Members</th>
						<th>Subscribed Plan</th>
						<th colspan="1"><a href="RationCardController?action=add">Add
								New</a></th>
					</tr>
				</thead>
				<c:forEach items="${details}" var="detail">
					<tr>
						<td><c:out value="${detail.rationCardNumber}"></c:out></td>
						<td><c:out value="${detail.familyHeadName}"></c:out></td>
						<td><c:out value="${detail.dob}"></c:out></td>
						<td><c:out value="${detail.gender}"></c:out></td>
						<td><c:out value="${detail.fatherName}"></c:out></td>
						<td><c:out value="${detail.motherName}"></c:out></td>
						<td><c:out value="${detail.occupation}"></c:out></td>
						<td><c:out value="${detail.noOfFamilyMembers}"></c:out></td>
						<td><c:out value="${detail.plan}"></c:out></td>
						<td><a
							href="RationCardController?action=update&rationCardId=<c:out value="${detail.rationCardId}"/>"><button>Update</button></a>
							<a><button onclick="msg1(${detail.rationCardId})">Delete</button></a>
							<a
							href="RationCardController?action=distribute&rationCardId=<c:out value="${detail.rationCardId}"/>"><button>Distribute</button></a>
							<a
							href="RationCardController?action=subscribe&rationCardId=<c:out value="${detail.rationCardId}"/>"><button>Subscribe</button></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</div>
</body>
</body>
</html>
