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
<title>View Plane</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body {
  height: 100%; 
  line-height: 1.8;
  background-position: center;
  background-size: cover;
  background-image: url("images/10.png");
  background-repeat:no-repeat;
}
.bgimg-1 {
  min-height: 100%;
}
.overlay
{
background-color:rgba(0,0,0,0.4);
height:840px;
width:100%;
overflow: auto;
}
.w3-bar .w3-button {
  padding: 16px;
}
.edit{
font-weight:bolder;
  color: lightblue;
  text-shadow: 3px -3px 1px black;
  }
.editText{
font-weight:bolder;
  color: black;
  text-shadow: 3px -3px 1px lightblue;
  font-size: 120%;
  }
table,th,td,tr{
border: 2px solid black;
}
</style>
</head>
<body>
<div class="overlay">
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="pilotForm.htm" class="w3-bar-item w3-button"><i class="fa fa-plus-square"></i>&nbsp;&nbsp;<b>ADD PILOTS</b></a>      
      <a href="adminLogout.htm" style="float:right" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i>&nbsp;<b>LOGOUT</b></a>
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive" id="home">
<br><br>
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    <div class="w3-col w3-container" style="width:20%">

      <div class="w3-card-4">
        <div class="w3-display-container" style="padding-left: 15%;">
       
     </div>
      </div><br>
    <!-- End Left Column -->
    </div>
    
    
    <!-- Right Column -->
    <div class="w3-rest">   
    <div class="w3-container w3-margin-bottom" style="padding-left: 5%;">      
    <div class="w3-row-padding w3-center w3-margin-bottom" >   
   <div class="edit" >
    <h1><b>View Pilot :</b></h1></div>
     </div>
    <div class="w3-container w3-right" style="width:50%;  background: rgba(255, 255, 255, 0.4);font-weight: bolder;color:black;"><br>
    <div class="w3-responsive">
  	<table class="w3-table-all w3-hoverable w3-centered">
		<tr class="w3-light-blue">
			<th class="editText">Pilot ID</th>
			<th class="editText">License Number</th>
		</tr>
		<c:forEach items="${pilotList}" var="pilot">
			<tr style="opacity: 0.8">
				<td><a href="viewOnePilot.htm?pilotId=${pilot.pilotId}" style="text-decoration: none;"><c:out value="${pilot.pilotId}" /></a></td>
				<td><c:out value="${pilot.pilotLicenseNumber}" /></td>
			</tr>
		</c:forEach>
	 </table></div>
	 <br>
	 </div>
	
		<div class="w3-quarter w3-display-bottomleft" style="width:20%;">
		  <a href="pilotMain.htm" style="text-decoration: none;">
		  <div class="w3-card w3-container w3-center" style="background: rgba(255, 255, 255, 0.4);min-height:100px">
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
</div></div>
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