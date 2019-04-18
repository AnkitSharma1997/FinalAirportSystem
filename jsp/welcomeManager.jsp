<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Welcome Manager</title>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
body, html {
  height: 100%;
  line-height: 1.8;
}
.bgimg-1 {
  background-position: center;
  background-size: cover;
  background-image: url("images/9.jpg");
  min-height: 100%;
}
.w3-bar .w3-button {
  padding: 16px;
}
.edit{
font-weight:bolder;
  color: lightblue;
  text-shadow: 3px -3px 1px black;
  }
.editSymbol{
  font-weight:bolder;
  color: black;
  text-shadow: 3px -3px 1px lightblue;
  text-align: center;
    font-size: 300%;
  }
.editHeading{
  font-weight:bolder;
  color: black;
  text-shadow: 3px -3px 1px #ffb066;
  text-align: center;
}
 .editLeftColumn{
  color: black;
  font-weight:bolder;
  text-shadow: 3px -3px 1px #ffb066;
}
</style>
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-black w3-card" id="myNavbar">
      <i class="w3-bar-item fa fa-plane" style="font-size:40px;"></i>
      <a href="managerLogout.htm" style="float:right" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i>&nbsp;<b>LOGOUT</b></a>
   </div>
</div>

<!-- Header with full-height image -->
<header class="bgimg-1 w3-display-container w3-grayscale-min w3-responsive" id="home">
<br><br>
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    <div class="w3-quarter" style="min-width:20%">

      <div class="w3-card-4" style="color:black;background: rgba(0, 0, 0, 0.5);
      background-color: lightblue;border: 5px white solid;border-bottom: none;">
        <div class="w3-display-container">
        
          <div class="w3-container">
          <br>
            <h3 class="editHeading">Welcome Manager</h3>
          </div>
          <div class="w3-container">
          <p class="editLeftColumn"><i class="fa fa-user fa-fw w3-margin-right w3-margin-left w3-large"></i>${managerName}</p>
          <p class="editLeftColumn"><i class="fa fa-calendar fa-fw w3-margin-right w3-margin-left w3-large"></i>${managerDob}</p>
          <p class="editLeftColumn"><i class="fa fa-male fa-fw w3-margin-right w3-margin-left w3-large "></i>${managerGender}</p>
          <p class="editLeftColumn"><i class="fa fa-hourglass-2 fa-fw w3-margin-right w3-margin-left w3-large"></i>Age - ${managerAge}</p>    
          <p class="editLeftColumn"><i class="fa fa-envelope fa-fw w3-margin-right w3-margin-left w3-large"></i>${managerEmail}</p>
          <p class="editLeftColumn"><i class="fa fa-phone fa-fw w3-margin-right w3-margin-left w3-large"></i>${managerContactNo}</p>
          <br>
          <br><br><br><br><br>
          </div>
        </div>
 
      </div><br>
    <!-- End Left Column -->
    </div>
    <!-- Right Column -->
    <div class="w3-half">
    
      <div class="w3-container w3-margin-bottom" >
       
        <div class="w3-row-padding w3-center w3-margin-bottom">
        <br>
        
        <div class="w3-quarter">
	    <a href="viewHangerAllocation.htm" style="text-decoration: none;">
  		<div class="w3-card w3-container" style="background: rgba(0, 0, 0, 0.5);min-height:150px">
  		<br>
  			<i class="fa fa-home editSymbol"></i>
  			<h4 class="edit">Allocate Hangars</h4>
  		</div></a>
		</div>
	
		<div class="w3-quarter">
 		  <a href="viewHangarStatus.htm" style="text-decoration: none;">
 		<div class="w3-card w3-container" style="background: rgba(0, 0, 0, 0.5);min-height:150px;">
 		<br>
 		  <i class="fa fa-info-circle editSymbol"></i>
		  <h4 class="edit">ViewHangar Status</h4>
		  </div></a>
		</div>

		<div class="w3-quarter">
		</div>
		
		<div class="w3-quarter">
		</div>
		</div>
      </div>
    <!-- End Right Column -->
    </div>
    </div>
  <!-- End Grid -->
<div class="w3-bottom">
<footer class="w3-container w3-black w3-center">
  Find us on social media<br>
    <i class="fa fa-google w3-hover-opacity"></i>
    <i class="fa fa-facebook-official w3-hover-opacity"></i>
    <i class="fa fa-instagram w3-hover-opacity"></i>
    <i class="fa fa-snapchat w3-hover-opacity"></i>
</footer></div>
  
  <!-- End Page Container -->

</header>


</body>
</html>