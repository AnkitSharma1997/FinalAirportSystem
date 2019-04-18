<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Airport Management System</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
  height: 100%;
  line-height: 1.8;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("images/2.jpg");
  min-height: 100%;
}
.w3-bar .w3-button {
  padding: 16px;
}
#edit{
  color: black;
  text-shadow: 2px 2px 6px #ffd11a;
  }
</style>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
 
    <!-- Right-sided navbar links -->
    <div class="w3-left w3-hide-small">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>
    </div>
    <div class="w3-right w3-hide-small">
      <a href="adminRegister.htm" class="w3-bar-item w3-button"><i class="fa fa-user"></i>&nbsp;<b>ADMIN REGISTER</b></a>
      <a href="adminLogin.htm" class="w3-bar-item w3-button"><i class="fa fa-user"></i>&nbsp;<b>ADMIN LOGIN</b></a>
      <a href="managerRegister.htm" class="w3-bar-item w3-button"><i class="fa fa-user-o"></i>&nbsp;<b>MANAGER REGISTER</b></a>
      <a href="managerLogin.htm" class="w3-bar-item w3-button"><i class="fa fa-user-o"></i>&nbsp;<b>MANAGER LOGIN</b></a>
    </div>
    <!-- Hide right-floated links on small screens and replace them with a menu icon -->

    <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="w3_open()">
      <i class="fa fa-bars"></i>
    </a>
  </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
<div>
<p class="w3-display-topright w3-jumbo w3-text-black w3-large w3-hide-small"><b id="edit">Airport Management System</b></p></div>
  <div class="w3-display-bottomleft w3-text-grey w3-large" style="padding:24px 48px">
    <i class="fa fa-google w3-hover-opacity"></i>
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
  </div>
</header>

</body>
</html>