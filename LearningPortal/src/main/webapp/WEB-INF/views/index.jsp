<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>
<style>
body {
background-color:lightskyblue;
    font-family: "Lato", sans-serif;
}
#main {
    transition: margin-left .5s;
    padding: 20px;
}

    
#nav-block{
    margin-top: 5em;
    width:100%;
        height:300px;
    border:none;
        
}   
.pages{
    background-image: url("resources/images/skill1.jpg");
   
    background-size:cover;
    width:30%;
    height:262px;
    display:inline-block;
    border:none;
    margin:1em; 
    }
  #learningPlan{
  width:30%;
  background-size:contain;
    background-image: url("resources/images/learningPlan.jpg");
  
  }
  #trainer{
  background-size:cover;
  
    background-image: url("resources/images/update2.png");
    
  
  }
    .pages:hover{
        background-color: greenyellow;
        opacity: 0.7;
         transition:  0.5s;
    }
.pages>img{
    width:100%;
        height: 100%;
    border:none;
        
    }


.sidenav {
    height: 100%;
    width: 0;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
}

.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

.sidenav a:hover {
    color: #f1f1f1;
}

.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}
#desc{
margin-top:10%;
width:100%;
height:800px;
background-color:red;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}


.inner-box{
border:2px solid red;
background-color:yellow;
display:inline;}

</style>

</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">About</a>
 
  <a href="/LearningPortal/index/login">Login</a>
 
</div>
   
    
    <div id="main">
    <span style=" font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Grow & Explore</span>
    <h2>XYZ Software Ltd.</h2>
    <p>Learning Plan Casetudy </p>
 
     <div id="nav-block">
         	       <a  class="pages"  href="/LearningPortal/index/skill" ></a>
            	   <a id="learningPlan"class="pages" href="/LearningPortal/index/" ></a>
	     		   <a id="trainer"class="pages" href="/LearningPortal/index/trainers" ></a>
    </div>
  </div>
    <script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
    function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
}
</script>
     
</body>

</html>
