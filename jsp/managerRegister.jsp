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
<title>Manager Registration</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
  height: 100%;
  line-height: 1.8;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("images/5.jpg");
  min-height: 100%;
}
.w3-bar .w3-button {
  padding: 16px;
}
#edit{
color:lightblue;
  text-shadow: 3px -3px 2px #0059b3;
  }
form{
  background: rgba(0, 0, 0, 0.5); 
  color: #f1f1f1;
  width:70%;
  margin-left:130%;
}
#shift{
padding-left:6%;
}
.textedit{
  color: lightblue;
  font-weight:bolder;
  text-shadow: 3px -3px 2px #0059b3;
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

function validateEmail(managerEmailId)
{
	var reg= /^([A-Za-z0-9_\-.])+\@([A-Za-z0-9_\-.])+\.([A-Za-z]{2,4})$/;
	if(reg.test(managerEmailId.value)==false)
	{
	alert("Invalid Email Id");
	return false;
	}
	return true;
}
function checkZero(event)
{
	var contactNo=document.managerReg.managerContactNo.value;			
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
      <a href="managerLogin.htm" class="w3-bar-item w3-button"><i class="fa fa-user-o"></i>&nbsp;<b>MANAGER LOGIN</b></a>      
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive" id="home">

<br><br>
<!-- ///////////////////////////////////////////////////// -->

<div class="w3-container w3-half w3-margin-top">

<springform:form name="managerReg" id="shift" class="w3-container w3-card-4 borcolour" onsubmit="return checkZero(event)"
modelAttribute="managerModel" method="post" action="managerRegisterSuccess.htm">

<div class="w3-center">
<header id="edit">
  <h1><b>Manager Registration</b></h1>
</header></div>

<!----------------------------------------------------------------------------------------------->
<p>
<div class="w3-row">
<div class="w3-col s6">
<div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-light-blue fa fa-user"></i></div>
<springform:label path="managerFirstName"/>
<springform:input path="managerFirstName" class="w3-input w3-border" style="width:70%" maxlength="50" 
autocomplete="off" placeholder="First Name" onkeypress="return alphabetOnly(event)"/>
<springform:errors path="managerFirstName" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s6">
<springform:label path="managerLastName"/>
<springform:input path="managerLastName" class="w3-input w3-border" style="width:85%" maxlength="50" 
autocomplete="off" placeholder="Last Name" onkeypress="return alphabetOnly(event)"/>
<springform:errors path="managerLastName" class="errorStyling"></springform:errors>
</div></div>

<!--------------------------------------------------------------------------------------------------->

<p>
<div class="w3-row">
<div class="w3-col s4">
<springform:label path="managerDob" class="textedit">Date Of Birth&nbsp;<i class="fa fa-calendar"></i></springform:label>
<springform:input path="managerDob" type="date" id="dob" class="w3-input w3-border" min="1960/01/01"
 onclick="return validate(this);" onchange="return ageCalculator(this);"  style="font-weight: bolder;font-size:10.5px;width:100%"/>
<springform:errors path="managerDob" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s4" style="padding-left: 4%;">
<springform:label path="managerAge" class="textedit">Age</springform:label>
<springform:input path="managerAge" id="agecal" class="w3-input w3-border" style="width:75%" maxlength="3"
 placeholder="Age" disabled="true"/>
</div>

<div class="w3-col s4">
<springform:label path="managerGender" class="textedit">Gender</springform:label>
<springform:select path="managerGender" class="w3-input w3-border" style="width:80%">
<springform:options items="${genderList}"/>
</springform:select>
</div></div>

<!--------------------------------------------------------------------------------------------------->

<p>
<div class="w3-row">
<div class="w3-col s6">
<springform:label path="managerContactNo" class="textedit">Contact Number</springform:label>
<springform:input path="managerContactNo" class="w3-input w3-border" style="width:80%" autocomplete="off"
maxlength="10" minlength="10" onkeypress="return isNumber(event)" placeholder="Contact Number"/>
<springform:errors path="managerContactNo" class="errorStyling"></springform:errors>
</div>

<div class="w3-col s6">
<springform:label path="managerAltContactNo" class="textedit">Alternate Contact No</springform:label>
<springform:input path="managerAltContactNo" class="w3-input w3-border" style="width:86%" autocomplete="off"
maxlength="10" minlength="10" onkeypress="return isNumber(event)"  placeholder="Alt Contact Number" />
</div></div>

<!--------------------------------------------------------------------------------------------------->

<p>
<div>
<div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-light-blue fa fa-envelope"></i></div>
<springform:label path="managerEmailId"/>
<springform:input path="managerEmailId" class="w3-input w3-border w3-center" style="width:80%" maxlength="50" autocomplete="off"
onblur="return validateEmail(managerEmailId)" placeholder="Email ID" />
<springform:errors path="managerEmailId" class="errorStyling"></springform:errors>
</div>

<p>
<div>
<div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-light-blue fa fa-key"></i></div>
<springform:label path="managerPassword"/>
<springform:password path="managerPassword" class="w3-input w3-border w3-center" style="width:80%" maxlength="15" 
autocomplete="off" placeholder="Password" />
<springform:errors path="managerPassword" class="errorStyling"></springform:errors>
</div>

<p class="w3-center">
<input type="submit" class="w3-button w3-blue" value="REGISTER" style="font-weight: bolder;"></button></p>
<p style="padding-bottom:1%;color:white">${status}<br>${managerMSG}&nbsp;&nbsp;
${note}${managerId}</p>
</springform:form>

</div>
</header>

</body>
</html>