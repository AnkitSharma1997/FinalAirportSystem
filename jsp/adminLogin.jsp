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
<title>Admin Login</title>
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
  }
form{
  background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
  color: #f1f1f1;
  width:50%;
}
#shift{
padding-left:7%;
}
.errorStyling{
color:black;
font-weight: bolder;
text-shadow: 3px -3px 1px red;
}
</style>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>
      <a href="main.htm" class="w3-bar-item w3-button"><i class="fa fa-home"></i>&nbsp;<b>HOME</b></a>
      <a href="adminRegister.htm" class="w3-bar-item w3-button"><i class="fa fa-user"></i>&nbsp;<b>ADMIN REGISTER</b></a>      
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">

<br><br><br><br>

<div id="shift" class="w3-container w3-half w3-margin-top">
<springform:form method="post" modelAttribute="adminModel" class="w3-container w3-card-4" action="adminLoginSuccess.htm">

<div class="w3-center">
<header id="edit">
  <h1><b>Admin Login</b></h1>
</header></div>

<p>
<div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-orange fa fa-user"></i></div>
<div class="w3-rest">
<springform:label path="adminId"/>
<springform:input path="adminId" class="w3-input w3-border" style="width:100%" maxlength="10" placeholder="Admin ID" 
autocomplete="off"/>
<springform:errors path="adminId" class="errorStyling"></springform:errors>
</div>

<p>
<div class="w3-col" style="width:50px"><i class="w3-xxlarge w3-text-orange fa fa-key"></i></div>
<div class="w3-rest">
<springform:label path="adminPassword"/>
<springform:password path="adminPassword" class="w3-input w3-border" style="width:100%" 
autocomplete="off" maxlength="15" placeholder="Admin Password" />
<springform:errors path="adminPassword" class="errorStyling"></springform:errors>
</div>

<p class="w3-center">
<input type="submit" class="w3-button w3-section w3-orange" value="LOGIN" style="font-weight: bolder;"></button></p>
<p style="padding-bottom:1%;color:orange"><b>${status}</b></p>
</springform:form>
</div>
</header>
</body>
</html>