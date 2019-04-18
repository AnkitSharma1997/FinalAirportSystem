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
<title>Update Plane</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
  height: 100%;
  line-height: 1.8;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("images/14.jpg");
  min-height: 100%;
  greyscale:(50%);
}
#shift{
padding-left:6%;

}
.w3-bottom {
    bottom: 0;
        position: fixed;
}
form{
  background: rgba(0, 0, 0, 0.5); 
  color: #f1f1f1;
  width:60%;
  margin-bottom:2%;
  margin-left:7%;
  margin-right:2%;
  margin-top:-0.7%;
  paddin-top:1%;
  padding-bottom:-20%;
}
.w3-bar .w3-button {
  padding: 16px;
}
#edit{
  color: lightblue;
  text-shadow: 3px -3px 1px #0059b3;
  padding-right:7%;
  }
.edit{
font-weight:bolder;
  color: lightblue;
  text-shadow: 3px -3px 1px #0059b3;
  }
.editSymbol{
  font-weight:bolder;
  color: black;
  text-shadow: 3px -3px 1px lightblue;
  }
 .editLeftColumn{
  color: black;
  font-weight:bolder;
  text-shadow: 3px -3px 1px lightblue;
}
  .textedit{
  color: lightblue;
  font-weight:bolder;
  text-shadow: 3px -3px 1px black;
  font-size: 16px;
  text-align: center;
}
.errorStyling{
color:#00ffff;
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
function validateEmail(ownerEmail)
{
	var reg= /^([A-Za-z0-9_\-.])+\@([A-Za-z0-9_\-.])+\.([A-Za-z]{2,4})$/;
	if(reg.test(ownerEmail.value)==false)
	{
	alert("Invalid Email Id");
	return false;
	}
	return true;
}
function checkZero(event)
{
	var ownerContactNo=document.updatePlane.ownerContactNo.value;
	var planeCapacity=document.updatePlane.planeCapacity.value;
	if(ownerContactNo==0)
	{
		alert("Invalid Owner Contact Number");
		return false;
	}
	if(planeCapacity==0)
	{
		alert("Invalid Plane Capacity");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="viewPlanes.htm" class="w3-bar-item w3-button"><i class="fa fa-tasks"></i>&nbsp;<b>VIEW PLANES</b></a>      
      <a href="adminLogout.htm" style="float:right" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i>&nbsp;<b>LOGOUT</b></a>
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive" id="home">
<br><br>

<div class="w3-container w3-half w3-margin-top">

<springform:form id="shift" style="border:10px solid black;" modelAttribute="view1PlaneModel" method="post" action="editPlane.htm"
name="updatePlane" onsubmit="return checkZero(event)">

<div class="w3-center">
<header id="edit">
  <h3 style="font-size: 180%;"><b>Update Plane</b></h3>
</header></div>


<div class="w3-row">
<div class="w3-col s6">
<springform:label path="planeId" class="edit">Plane Id</springform:label>
<springform:input path="planeId" disabled="true" class="w3-input w3-border w3-center" style="width:90%"/>
</div>

<div class="w3-col s6" style="padding-left:1%;">
<springform:label path="ownerId" class="edit">Owner Id</springform:label>
<springform:input path="ownerId" class="w3-input w3-border w3-center" style="width:80%;" disabled="true"/>
</div></div>

<div class="w3-row">
<div class="w3-col s6">
<springform:label path="ownerFirstName" class="textedit"><i class="fa fa-user w3-text-light-blue"></i>&nbsp;&nbsp;Owner First Name&nbsp;</springform:label>
<springform:input path="ownerFirstName" class="w3-input w3-border w3-center" style="width:90%" maxlength="100"
autocomplete="off" placeholder="Owner First Name" onkeypress="return alphabetOnly(event)"/>
<springform:errors path="ownerFirstName" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s6" style="padding-left:1%;">
<springform:label path="ownerLastName"  class="textedit">&nbsp;Owner Last Name&nbsp;</springform:label>
<springform:input path="ownerLastName" class="w3-input w3-border w3-center" style="width:80%;" 
autocomplete="off" maxlength="100" placeholder="Owner Last Name" onkeypress="return alphabetOnly(event)"/>
<springform:errors path="ownerLastName" class="errorStyling"></springform:errors>
</div></div>

<div>
<springform:label path="ownerContactNo" class="textedit"><i class="fa fa-phone w3-text-light-blue"></i>&nbsp;&nbsp;Owner Contact Number&nbsp;</springform:label>
<springform:input path="ownerContactNo" class="w3-input w3-border w3-center" style="width:90%" autocomplete="off"
maxlength="11" onkeypress="return isNumber(event)" placeholder="Owner Contact Number"/>
<springform:errors path="ownerContactNo" class="errorStyling"></springform:errors>
</div>


<div>
<springform:label path="ownerEmail" class="textedit"><i class="fa fa-envelope w3-text-light-blue"></i>&nbsp;&nbsp;Owner Email Id&nbsp;</springform:label>
<springform:input path="ownerEmail" class="w3-input w3-border w3-center" style="width:90%" maxlength="50" autocomplete="off"
onblur="return validateEmail(ownerEmail)" placeholder="Owner Email ID" />
<springform:errors path="ownerEmail" class="errorStyling"></springform:errors>
</div>


<div class="w3-row">
<div class="w3-col s6">
<springform:label path="planeType" class="textedit">Plane Type</springform:label>
<springform:input path="planeType" class="w3-input w3-border" style="width:80%" maxlength="10" 
autocomplete="off" placeholder="Plane Type" />
<springform:errors path="planeType" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s6">
<springform:label path="planeCapacity" class="textedit">Plane Capacity</springform:label>
<springform:input path="planeCapacity" class="w3-input w3-border" style="width:80%" maxlength="4" autocomplete="off"
onkeypress="return isNumber(event)" placeholder="Plane Capacity" />
<springform:errors path="planeCapacity" class="errorStyling"></springform:errors>
</div></div>

<p>
<div class="w3-row w3-center" style="padding-right: 11%;">
<input type="submit" class="w3-button w3-light-blue" value="SAVE" style="font-weight: bolder;">
</div>

<p style="padding-bottom:1%;color:lightblue;font-weight: bolder;padding-top:-1%;">${status}</p>
</springform:form>

</div>
	
<div class="w3-quarter w3-display-bottomright w3-center" style="width:20%;">
<a href="planeMain.htm" style="text-decoration: none;">
<div class="w3-card w3-container" style="background: rgba(0, 0, 0, 0.5);min-height:100px">
<p class="edit">Back</p>
</div></a></div>
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