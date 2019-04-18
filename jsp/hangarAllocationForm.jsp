<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hangar Allocation Form</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
  height: 100%;
  line-height: 1.8;
  overflow: hidden;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("images/17.jpg");
  min-height: 100%;
  background-size: 100% 720px;
 background-attachment: fixed;
  background-repeat: no-repeat;
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
  text-shadow: 3px -3px 1px #00ffff;
  padding: 0px;
  }
.editLabel{
float:left;
font-weight: bolder;
  color: black;
  text-shadow: 3px -3px 1px #00ffff;
}
</style>
<script type="text/javascript">
function validate(dob)
{
	var today=new Date();
	var dd=today.getDate();
	var mm=today.getMonth()+1;
	var yyyy=today.getFullYear();	
	if(dd<10)
	{
		dd='0'+dd;
	}
	else (mm<10)
	{
		mm='0'+mm;
	}	
	today=yyyy+'-'+mm+'-'+dd;	
	var today1=new Date();
	var dd1=today1.getDate();	
	var mm1=today1.getMonth()+2;
	var yyyy1=today1.getFullYear();
	if(dd1<10)
	{
		dd1='0'+dd1;
	}
	else (mm<10)
	{
		mm1='0'+mm1;
	} 
	today1=yyyy1+'-'+mm1+'-'+dd1;	
	document.getElementById("dob").setAttribute("min",today);
	document.getElementById("dob").setAttribute("max",today1);

	document.getElementById("dob1").setAttribute("min",today);
	document.getElementById("dob1").setAttribute("max",today1);

	document.getElementById("dob2").setAttribute("min",today);
	document.getElementById("dob2").setAttribute("max",today1);

	document.getElementById("dob3").setAttribute("min",today);
	document.getElementById("dob3").setAttribute("max",today1);
	return true;
}
</script>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a class="w3-bar-item" style="padding:16px;"><i class="fa fa-home"></i>&nbsp;<b>HANGAR ALLOCATION</b></a>
      <a href="managerLogout.htm" style="float:right" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i>&nbsp;<b>LOGOUT</b></a>
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive" id="home">
<br><br>
<div class="w3-content" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
    
    
    <!-- Right Column -->
   <div class="w3-rest">   
    <div class="w3-container">      
    <div class="w3-row-padding w3-center" style="padding-left: 7%;" >   <br>
   
     <div class="w3-container" style="width:40%;background: rgba(255, 255, 255, 0.7);font-weight: bolder;color:black;border:8px white solid;border-bottom: none;"><br>
    <div class="w3-responsive">
<springform:form modelAttribute="hangarStatusModel" method="post" action="addPlaneIntoHanger.htm">
<div class="w3-center">
<header class="editText">
  <h2><b>Allocate Hangar</b></h2>
</header></div>
<center>
<div><p class="editLabel" style="float: left;">
Plane Id:
<springform:select path="planeId" items="${planeIdList}" style="padding:1%;"/></div>

<div class="w3-row">
<div class="w3-col s6">
<springform:label path="hangarId" class="editLabel">Hanger Id</springform:label>
<springform:input path="hangarId" value="${hangarId}" readonly="true"/>
</div>

<div class="w3-col s6" style="float:right;">
<springform:label path="managerId" class="editLabel">Manager Id</springform:label>
<springform:input path="managerId" value="${managerId}" readonly="true"/></div></div>

<p>
<div class="w3-row">
<div class="w3-col s6">
<springform:label path="occupancyFromDate" class="editLabel"><i class="fa fa-calendar"></i>&nbsp;Occupancy From Date:</springform:label>
<springform:input path="occupancyFromDate" id="dob" onclick="return validate(dob);"
type="date" class="w3-input w3-border" style="font-size:12px;width:80%"/></div>

<div class="w3-col s6" style="float:right;">
<springform:label path="occupancyTillDate" class="editLabel"><i class="fa fa-calendar"></i>&nbsp;Occupancy Till Date:</springform:label>
<springform:input path="occupancyTillDate" id="dob1" onclick="return validate(dob1);" 
type="date" class="w3-input w3-border" style="font-size:12px;width:80%"/></div></div>

<p>
<div class="w3-row">
<div class="w3-col s6">
<springform:label path="availableFromDate" class="editLabel"><i class="fa fa-calendar"></i>&nbsp;Available From Date:</springform:label>
<springform:input path="availableFromDate" id="dob2" onclick="return validate2(dob2);" 
type="date" class="w3-input w3-border" style="font-size:12px;width:80%"/></div>

<div class="w3-col s6" style="float:right;">
<springform:label path="availableTillDate" class="editLabel"><i class="fa fa-calendar"></i>&nbsp;Available Till Date:</springform:label>
<springform:input path="availableTillDate" id="dob3" onclick="return validate3(dob3);" 
type="date" class="w3-input w3-border" style="font-size:12px;width:80%"/></div></div>

<p>
<input type="submit" style="background-color: #00ffff;font-weight: bolder;" value="Allocate Plane">
</center>
<p style="padding-bottom:1%;color:#76bdd5">${status}</p>
</springform:form>
</div>	 	

<br>
</div>
		<br>
		<div class="w3-quarter w3-display-bottomright" style="width:15%;padding:2%;">
		  <a href="viewHangerAllocation.htm" style="text-decoration: none;">
		  <div class="w3-card w3-container" style="background: rgba(0, 0, 0, 0.7);min-height:100px">
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