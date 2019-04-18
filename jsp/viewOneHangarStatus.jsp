<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Hangar Status</title>
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
  color: #ffb366;
  text-shadow: 3px -3px 1px black;
  }
.editText{
font-weight:bolder;
  color: black;
  text-shadow: 3px -3px 1px #ffb366;
  padding: 0px;
  }
.editLabel{
font-weight: bolder;
  color: black;
  text-shadow: 3px -3px 1px #ffb366;
}
#editStatus{
padding-bottom:1%;
color:orange;
}
</style>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a class="w3-bar-item" style="padding:16px;"><i class="fa fa-home"></i>&nbsp;<b>UPDATE HANGAR STATUS</b></a>
      <a href="managerLogout.htm" style="float:right" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i>&nbsp;<b>LOGOUT</b></a>
      <a href="viewHangarStatus.htm"class="w3-bar-item w3-button" style="float:right;"><i class="fa fa-tasks"></i>&nbsp;<b>VIEW HANGAR STATUS</b></a>
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
    <div class="w3-row-padding w3-center">   <br>
   
     <div class="w3-container" style="width:30%;background: rgba(255, 255, 255, 0.7);font-weight: bolder;color:black;border:8px white solid;border-bottom: none;"><br>
    <div class="w3-responsive">

<springform:form modelAttribute="view1HangarStatusModel" method="post" action="editHangarStatus.htm"
name="updateHangarStatus">

<div class="w3-center">
<header class="editText">
  <h2><b>Update Hangar Status</b></h2>
</header></div>
<center>

<div>
<springform:label path="hangarId" class="editLabel">Hanger Id</springform:label>
&nbsp;&nbsp;&nbsp;
<springform:input path="hangarId" disabled="true" placeholder="HangarId" /></div>


<p><div>
<springform:label path="status" class="editLabel">Status</springform:label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<springform:select path="status" style="width:50%;padding:1%;" items="${statusList}" /></div>

<p>
<input type="submit" style="background-color: #ffb366;font-weight: bolder;" value="Update">
<p id="editStatus">${status}</p>
</center>
</springform:form>
</div>	 	

<br>
</div>
		<div class="w3-quarter w3-display-topright" style="width:20%;padding-top:6%;padding-right:4%;">
		  <div class="w3-card w3-container" style="background: rgba(0, 0, 0, 0.7);min-height:100px">
		  <p class="edit">Update Hangar Status :<br>
		  A - Available<br>O - Occupied</p>
		  </div></div>

		<br>
		<div class="w3-quarter w3-display-bottomright" style="width:15%;">
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