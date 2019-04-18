<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Manager Requests</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
  height: 100%;
  line-height: 1.8;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("images/6.jpg");
  min-height: 100%;
}
.w3-bar .w3-button {
  padding: 16px;
}
.edit{
font-weight:bolder;
  color: #ff8000;
  text-shadow: 3px -3px 1px black;
  }
.editText{
font-weight:bolder;
  color: black;
  text-shadow: 3px -3px 1px #ff8000;
  font-size: 120%;
  }
table,th,td,tr{
border: 2px solid black;}
</style>
<script type="text/javascript">
function refresh(){
	setTimeout(function(){
		window.location.reload();
	}, 5000)
}
</script>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="adminLogout.htm" style="float:right" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i>&nbsp;<b>LOGOUT</b></a>
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive" id="home">
<br><br>
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
    
    
    <!-- Right Column -->
    <div class="w3-rest">   
    <div class="w3-container w3-margin-bottom">      
    <div class="w3-row-padding w3-center w3-margin-bottom" >   
   
    <div class="w3-container" style="width:90%;background: rgba(0, 0, 0, 0.5);font-weight: bolder;color:black;"><br>
    <div class="w3-responsive">
  	<table class="w3-table-all w3-hoverable w3-centered">
		<tr style="background-color: #ffb366;">
			<th class="editText">Manager ID</th>
			<th class="editText">First Name</th>
			<th class="editText">Last Name</th>
			<th class="editText">Age</th>
			<th class="editText">Gender</th>
			<th class="editText">DOB</th>
			<th class="editText">Contact No</th>
			<th class="editText">Alternate Contact No</th>
			<th class="editText">Email</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${managerList}" var="manager">
		<tr style="opacity: 0.8">
				<td><c:out value="${manager.managerId}"/></td>
				<td><c:out value="${manager.managerFirstName}"/></td>
				<td><c:out value="${manager.managerLastName}"/></td>
				<td><c:out value="${manager.managerAge}"/></td>
				<td><c:out value="${manager.managerGender}"/></td>
				<td><c:out value="${manager.managerDob}"/></td>
				<td><c:out value="${manager.managerContactNo}"/></td>
				<td><c:out value="${manager.managerAltContactNo}"/></td>
				<td><c:out value="${manager.managerEmailId}"/></td>

						<td><a href="changeRequestStatus.htm?managerId=${manager.managerId}&action=approve"
						style="text-decoration: none;color:green;font-weight: bolder;">Approve</a></td>
						<td><a href="changeRequestStatus.htm?managerId=${manager.managerId}&action=reject"
						style="text-decoration: none;color:red;font-weight: bolder;">Reject</a> </td>
		</tr>
		</c:forEach>
	 	</table></div>
	 	
	 	<br>
	 	</div>
		
		<div class="w3-quarter w3-display-bottomright" style="width:20%;">
		  <a href="welcomeAdmin.htm" style="text-decoration: none;">
		  <div class="w3-card w3-container" style="background: rgba(0, 0, 0, 0.5);min-height:100px">
		  <p class="edit">Back</p>
		  </div></a>
		</div>
		<br><br>
		</div>
		</div>
      </div>
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
</div>
  <!-- End Page Container -->
</header>

<footer class="w3-bottom w3-container w3-black w3-center" >
  Find us on social media<br>
    <i class="fa fa-google w3-hover-opacity"></i>
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
</footer>
</body>
</html>