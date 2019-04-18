<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Add Pilot</title>
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
#shift{
padding-left:4%;

}
.w3-bottom {
    bottom: 0;
        position: fixed;
}
form{
  background: rgba(255, 255, 255, 0.3); 
  color: #f1f1f1;
  width:35%;
  margin-bottom:2%;
  margin-left:7%;
  margin-right:2%;
  margin-top:-0.7%;
  paddin-top:1%;
  padding-bottom:-20%;
  float:right;
}
.w3-bar .w3-button {
  padding: 16px;
}
#edit{
  color: black;
  text-shadow: 3px -3px 1px lightblue;
  padding-right:15%;
  }
.edit{
font-weight:bolder;
  color: lightblue;
  text-shadow: 3px -3px 1px black;
  }
  .textedit{
  color: black;
  font-weight:bolder;
  text-shadow: 3px -3px 1px lightblue;
  font-size: 16px;
  text-align: center;
}
.overlay
{
background-color:rgba(0,0,0,0.4);
height:840px;
width:100%;
}
.errorStyling{
color:#ffc107;
font-weight: bolder;
  text-shadow: 3px -3px 1px black;
}
</style>
<script>
function alphabetOnly(event)
{
	var key=event.keyCode;
	if(!((key>=65 && key<=90) || key==8 || (key>=97 && key <123) || key==32))
	{
		alert("Digits Not Allowed");
		return false;
	}
	return true;
}
function isNumber(event1)
{
	event1=(event1)?event1:window.event;
	var charCode=(event1.which)?event.which:event1.keyCode;
	if(charCode > 31 &&(charCode < 48 || charCode > 57))
		{
		alert("Invalid Number");
		return false;
		}
	return true;
}
function checkZero(event)
{
	var zipCode=document.addPilot.pilotZipCode.value;
	var ssn=document.addPilot.pilotSsn.value;
	if(zipCode==0)
	{
		alert("Invalid Zip Code");
		return false;
	}
	if(ssn==0)
	{
		alert("Invalid SSN");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div class="overlay">
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="viewPilots.htm" class="w3-bar-item w3-button"><i class="fa fa-tasks"></i>&nbsp;<b>VIEW PILOT</b></a>      
      <a href="adminLogout.htm" style="float:right" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i>&nbsp;<b>LOGOUT</b></a>
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive w3-image" id="home">
<br><br>

<div class="w3-container w3-margin-top">

<springform:form id="shift" modelAttribute="pilotModel" method="post" action="addPilot.htm" 
name="addPilot" onsubmit="return checkZero(event)" style="border:10px solid black;">

<div class="w3-center">
<header id="edit">
  <h2><b>Add Pilot</b></h2>
</header></div>

<springform:label path="pilotLicenseNumber" class="edit"><b>License Number</b></springform:label>
<springform:input path="pilotLicenseNumber" class="w3-input w3-border" style="width:85%" autocomplete="off"
maxlength="100" placeholder="License Number" />
<springform:errors path="pilotLicenseNumber" class="errorStyling"></springform:errors>

<p>
<springform:label path="pilotAddressLine1" class="edit"><i class="fa fa-address-book w3-text-light-blue"></i>&nbsp;&nbsp;Address Line 1&nbsp;</springform:label>
<springform:input path="pilotAddressLine1" class="w3-input w3-border" style="width:85%" maxlength="100" 
autocomplete="off" placeholder="Address Line 1"/>
<springform:errors path="pilotAddressLine1" class="errorStyling"></springform:errors>

<p>
<springform:label path="pilotAddressLine2" class="edit"><i class="fa fa-address-book w3-text-light-blue"></i>&nbsp;&nbsp;Address Line 2</springform:label>
<springform:input path="pilotAddressLine2" class="w3-input w3-border" style="width:85%" maxlength="100" 
autocomplete="off" placeholder="Address Line 2" onkeypress="return alphabetOnly(event)"/>
<springform:errors path="pilotAddressLine2" class="errorStyling"></springform:errors>

<div class="w3-row">
<div class="w3-col s6">
<springform:label path="pilotCity" class="edit">City</springform:label>
<springform:input path="pilotCity" class="w3-input w3-border" style="width:80%" maxlength="50" onkeypress="return alphabetOnly(event)"
autocomplete="off" placeholder="City" />
<springform:errors path="pilotCity" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s6">
<springform:label path="pilotState" class="edit">State</springform:label>
<springform:input path="pilotState" class="w3-input w3-border" style="width:70%" maxlength="50" onkeypress="return alphabetOnly(event)"
autocomplete="off" placeholder="State" />
<springform:errors path="pilotState" class="errorStyling"></springform:errors>
</div></div>

<p>
<div class="w3-row">
<div class="w3-col s6">
<springform:label path="pilotZipCode" class="edit">Zip Code</springform:label>
<springform:input path="pilotZipCode" class="w3-input w3-border" style="width:80%" maxlength="11" autocomplete="off"
onkeypress="return isNumber(event)" placeholder="Zip Code" />
<springform:errors path="pilotZipCode" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s6">
<springform:label path="pilotSsn" class="edit">SSN</springform:label>
<springform:input path="pilotSsn" class="w3-input w3-border" style="width:70%" maxlength="10" autocomplete="off"
onkeypress="return isNumber(event)" placeholder="SSN" />
<springform:errors path="pilotSsn" class="errorStyling"></springform:errors>
</div></div>

<p>
<div class="w3-row">
<div class="w3-col s6" style="padding-left:7%;">
<input type="submit" class="w3-button w3-light-blue" value="SUBMIT" style="font-weight: bolder;">
</div>

<div class="w3-col s6" style="padding-left:2%;"> 
<input type="reset" class="w3-button w3-light-blue" value="CANCEL" style="font-weight: bolder;">
</div></div>

<p style="padding-bottom:1%;color:lightblue;font-weight: bolder;">${status}<br></p>
</springform:form>


	
<div class="w3-quarter w3-display-bottomleft w3-center" style="width:20%;">
<a href="pilotMain.htm" style="text-decoration: none;">
<div class="w3-card w3-container" style="background: rgba(255, 255, 255, 0.5);min-height:100px">
<p class="edit">Back</p>
</div></a></div>
</div>
  <!-- End Page Container -->
  	

</div>
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