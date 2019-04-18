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
<title>Admin Registration</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
  height: 100%;
  line-height: 1.8;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("images/3.jpg");
  min-height: 100%;
}
.w3-bar .w3-button {
  padding: 16px;
}
#edit{
  color: orange;
  text-shadow: 3px -3px 1px black;
  padding-right:2%;
  }
form{
  background: rgba(0, 0, 0, 0.5); 
  color: #f1f1f1;
  width:70%;
  margin-bottom:2%;
  margin-left:2%;
  margin-right:2%;
  margin-top:-0.7%;
  paddin-top:1%;
}
#result{
  width:17%;
  padding-left:1%;
  padding-right: 1%;
  margin:1.5%;
  font-weight: bolder;
}
#shift{
padding-left:6%;
}
.textedit{
  color: orange;
  font-weight:bolder;
  text-shadow: 3px -3px 1px black;
  font-size: 16px;
}
.errorStyling{
color:black;
font-weight: bolder;
text-shadow: 3px -3px 1px red;
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

function validateEmail(adminEmailId)
{
	 var reg= /^([A-Za-z0-9_\-.])+\@([A-Za-z0-9_\-.])+\.([A-Za-z]{2,4})$/;
	if(reg.test(adminEmailId.value)==false)
		{
		alert("Invalid Email Id");
		return false;
		} 
	return true;
}
function checkZero(event)
{
	var contactNo=document.adminReg.adminContactNo.value;			
	if(contactNo==0)
	{
		alert("Invalid Contact Number");
		return false;
	}
	return true;
}
function ageCalculator(agecal)
{
	var d=document.getElementById("dob").value;
	var a=d.substring(0,4);
	var k=parseInt(a,10);
	var today=new Date();
	var yyyy=today.getFullYear();
	var s=yyyy-k;
	if(s<18)
	{
		alert("Age less than 18 Not eligible to register");
		return false;
	}
	else if(s>=18)
	{		
			document.getElementById("agecal").value=s;
			return true;
	}
	else
		{
		   alert("Please Enter Date Of Birth");
		   return false;
		}	
}
function validate(dob)
{
	var today=new Date();
	var dd=today.getDate();
	var mm=today.getMonth()+1;
	var yyyy=today.getFullYear()-18;
	if(dd<10)
	{
		dd='0'+dd;
	}
	else (mm<10)
	{
		mm='0'+mm;
	}
	today=yyyy+'-'+mm+'-'+dd;
	document.getElementById("dob").setAttribute("max",today);
	return true;
}
</script>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>
      <a href="main.htm" class="w3-bar-item w3-button"><i class="fa fa-home"></i>&nbsp;<b>HOME</b></a>
      <a href="adminLogin.htm" class="w3-bar-item w3-button"><i class="fa fa-user"></i>&nbsp;<b>ADMIN LOGIN</b></a>      
   </div>
</div>



<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive" id="home">

<br><br>
<!-- ///////////////////////////////////////////////////// -->

<div class="w3-container w3-half w3-margin-top">

<springform:form id="shift" class="w3-container w3-card-4" modelAttribute="adminModel" method="post" 
onsubmit="return checkZero(event)" name="adminReg" action="adminRegisterSuccess.htm">

<div class="w3-center">
<header id="edit">
  <h1><b>Admin Registration</b></h1>
</header></div>

<!----------------------------------------------------------------------------------------------->
<p>
<div class="w3-row">
<div class="w3-col s6">
<div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-orange fa fa-user"></i></div>
<springform:label path="adminFirstName"/>
<springform:input path="adminFirstName" class="w3-input w3-border" style="width:70%" maxlength="50" 
autocomplete="off" onkeypress="return alphabetOnly(event)" placeholder="First Name" />
<center>&nbsp;&nbsp;&nbsp;&nbsp;
<springform:errors path="adminFirstName" class="errorStyling"></springform:errors></center>
</div>

<div class="w3-col s6">
<springform:label path="adminLastName"/>
<springform:input path="adminLastName" class="w3-input w3-border" style="width:85%" maxlength="50" 
autocomplete="off" onkeypress="return alphabetOnly(event)" placeholder="Last Name" />
<springform:errors path="adminLastName" class="errorStyling"></springform:errors>
</div></div>

<!--------------------------------------------------------------------------------------------------->

<p>
<div class="w3-row">
<div class="w3-col s4">
<springform:label path="adminDob" class="textedit">Date Of Birth&nbsp;<i class="fa fa-calendar"></i></springform:label>
<springform:input path="adminDob" type="date" id="dob" class="w3-input w3-border" min="1960/01/01" autocomplete="off" 
onclick="return validate(this);" onchange="return ageCalculator(this);"  style="font-weight: bolder;font-size:10.5px;width:100%"/>
<springform:errors path="adminDob" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s4" style="padding-left: 4%;">
<springform:label path="adminAge" class="textedit">Age</springform:label>
<springform:input path="adminAge" id="agecal" class="w3-input w3-border" style="width:75%" maxlength="3"
placeholder="Age" disabled="true"/>
</div>

<div class="w3-col s4">
<springform:label path="adminGender" class="textedit">Gender</springform:label>
<springform:select path="adminGender" class="w3-input w3-border" style="width:80%">
<springform:options items="${genderList}"/>
</springform:select>
</div></div>

<!--------------------------------------------------------------------------------------------------->

<p>
<div class="w3-row">
<div class="w3-col s6">
<springform:label path="adminContactNo" class="textedit">Contact Number</springform:label>
<springform:input path="adminContactNo" class="w3-input w3-border" style="width:80%" autocomplete="off" 
maxlength="10" minlength ="10" onkeypress="return isNumber(event)" placeholder="Contact Number"/>
<springform:errors path="adminContactNo" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s6">
<springform:label path="adminAltContactNo" class="textedit">Alternate Contact No</springform:label>
<springform:input path="adminAltContactNo" class="w3-input w3-border" style="width:86%" autocomplete="off"
maxlength="10" minlength ="10" onkeypress="return isNumber(event)" placeholder="Alt Contact Number" />
</div></div>

<!--------------------------------------------------------------------------------------------------->

<p>
<div>
<div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-orange fa fa-envelope"></i></div>
<springform:label path="adminEmailId"/>
<springform:input path="adminEmailId" class="w3-input w3-border w3-center" style="width:80%" maxlength="50" autocomplete="off"
onblur="return validateEmail(adminEmailId)" placeholder="Email ID" />
<center><springform:errors path="adminEmailId" class="errorStyling"></springform:errors></center>
</div>

<p>
<div>
<div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-orange fa fa-key"></i></div>
<springform:label path="adminPassword"/>
<springform:password path="adminPassword" class="w3-input w3-border w3-center" style="width:80%" maxlength="15" 
autocomplete="off" placeholder="Password" />
<center><springform:errors path="adminPassword" class="errorStyling"></springform:errors></center>
</div>

<p class="w3-center">
<input type="submit" class="w3-button w3-orange" value="REGISTER" style="font-weight: bolder;"></button></p>
<p style="padding-bottom:1%;color:orange">${status}<br>${adminMSG}${note}&nbsp;${adminId}</p>
</springform:form>

</div>
</header>
</body>
</html>
