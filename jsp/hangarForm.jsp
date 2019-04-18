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
<title>Add Hangar</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
  height: 100%;
  line-height: 1.8;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("images/11.jpg");
  min-height: 100%;
  greyscale:(50%);
}
#shift{
padding-left:3%;

}
.w3-bottom {
    bottom: 0;
        position: fixed;
}
form{
  background: rgba(0, 0, 0,0.5);
  border:10px solid black;
  border-top:20px solid black;
  color: #f1f1f1;
  width:35%;
  margin-left:7%;
  margin-right:2%;
  margin-top:-0.7%;
  float:right;
}
.w3-bar .w3-button {
  padding: 16px;
}
#edit{
font-weight:bolder;
  color: #ffb366;
  text-shadow: 3px -3px 1px BLACK;
  padding-right:5%;
  }
.edit{
font-weight:bolder;
  color: #ffb366;
  text-shadow: 3px -3px 1px BLACK;
  }
  .textedit{
 font-weight:bolder;
  color: #ffb366;
  text-shadow: 3px -3px 1px BLACK;
  font-size: 17px;
  text-align: center;
}
.errorStyling
{
color:#87ceeb;
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
	var zipCode=document.addHangar.hangarZipCode.value;
	if(zipCode==0)
	{
		alert("Invalid Zip Code");
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
      <a href="viewHangars.htm" class="w3-bar-item w3-button"><i class="fa fa-tasks"></i>&nbsp;<b>VIEW HANGARS</b></a>      
      <a href="adminLogout.htm" style="float:right" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i>&nbsp;<b>LOGOUT</b></a>
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive" id="home">
<br><br>

<div class="w3-container w3-rest w3-margin-top">


<springform:form id="shift" modelAttribute="hangarModel" method="post" action="addHangar.htm" 
name="addHangar" onsubmit="return checkZero(event)">

<div class="w3-center">
<header id="edit">
  <h2><b>Add Hangar</b></h2>
</header></div>

<p style="padding-left: 8%;">
<springform:label path="managerId" class="textedit">Manager Id</springform:label>
<springform:input path="managerId" class="w3-input w3-border" style="width:83%" maxlength="10" autocomplete="off"
placeholder="ManagerId" onkeypress="return alphabetOnly(event)"/>
<springform:errors path="managerId" class="errorStyling"></springform:errors>

<p style="padding-left: 8%;">
<springform:label path="managerAddressLine1" class="textedit"><i class="fa fa-address-book"></i>&nbsp;&nbsp;Manager Address Line 1&nbsp;</springform:label>
<springform:input path="managerAddressLine1" class="w3-input w3-border" style="width:83%" 
autocomplete="off" maxlength="100" placeholder="Address Line 1" />
<springform:errors path="managerAddressLine1" class="errorStyling"></springform:errors>

<p style="padding-left: 8%;">
<springform:label path="managerAddressLine2" class="textedit"><i class="fa fa-address-book"></i>&nbsp;&nbsp;Manager Address Line 2&nbsp;</springform:label>
<springform:input path="managerAddressLine2" class="w3-input w3-border" style="width:83%" maxlength="100" 
autocomplete="off" placeholder="Address Line 2"/>

<p>
<div class="w3-row">
<div class="w3-col s4" style="padding-left: 2%;">
<springform:label path="hangarCity" class="textedit">City</springform:label>
<springform:input path="hangarCity" class="w3-input w3-border" style="width:80%" maxlength="50" 
autocomplete="off" placeholder="City" onkeypress="return alphabetOnly(event)"/>
<springform:errors path="hangarCity" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s4" style="padding-left: 1%;">
<springform:label path="hangarState" class="textedit">State</springform:label>
<springform:input path="hangarState" class="w3-input w3-border" style="width:80%" maxlength="50" 
onkeypress="return alphabetOnly(event)" autocomplete="off" placeholder="State" />
<springform:errors path="hangarState" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s4" style="padding-left: -1%; padding-right:4%;"">
<springform:label path="hangarZipCode" class="textedit">Zip Code</springform:label>
<springform:input path="hangarZipCode" class="w3-input w3-border" style="width:80%" maxlength="11" autocomplete="off"
onkeypress="return isNumber(event)" placeholder="Zip Code" />
<springform:errors path="hangarZipCode" class="errorStyling"></springform:errors>
</div></div>

<p>
<div class="w3-row">
<div class="w3-col s6" style="padding-left:12%;">
<input type="submit" class="w3-button w3-text-black" value="SUBMIT" style="background-color:#ffb366;font-weight: bolder;">
</div>

<div class="w3-col s6" style="padding-left:2%;"> 
<input type="reset" class="w3-button w3-text-black" value="CANCEL" style="background-color:#ffb366;font-weight: bolder;">
</div></div>

<p style="padding-bottom:1%;color:#ffb366;font-weight: bolder;">${status}<br></p>
</springform:form>

</div>
	
<div class="w3-quarter w3-display-bottomleft w3-center" style="padding-left:1%;width:10%;">
<a href="hangarMain.htm" style="text-decoration: none;">
<div class="w3-card w3-container" style="background: rgba(0, 0,0, 0.7);min-height:100px">
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