<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
button {
    background-color:brown;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: maroon;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 20px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 5%;
    border-radius: 5%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 50%; /* Could be more or less, depending on screen size */
    
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: maroon;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>

<center>
<h1 style ="background-color:brown">
<p style="color:blue;"></p>SIOPA

<input type = "submit" name ="logout" value="logOut" style="float:right">

</h1>

</center>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">sell</button>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="./SiopaController" method = "post" enctype = "multipart/form-data">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      
       <div data-role="popup" id="myPopup1" class="ui-content" style="min-width:10%;">
                        
                            <div>
                                <div class="container">
                                <div class="row">
                                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                                        <h1 class="text-center login-title">sell</h1>
                                        <div class="user-login">
                                            
                                            <br>Description
                        <input type="text" class="form-control" placeholder="Description" name = "description" required autofocus>Old Months
                        <input type="text" class="form-control" placeholder="Old Months" name = "oldMonths" required autofocus>
Maximum Price
                        <input type="text" class="form-control" placeholder="Maximum Price" name = "maxPrice" required autofocus>
Minimum Price
                        <input type="text" class="form-control" placeholder="Minimum Price" name = "minPrice" required autofocus>
DATE
                        <input type="text" class="form-control" placeholder="yyyy/mm/dd" name  = "date" required autofocus>
Sold
                        <input type="text" class="form-control" placeholder="Sold" name = "sold" required autofocus>
Locality
                        <input type="text" class="form-control" placeholder="Locality" name = "locality" required autofocus>
City
                        <input type="text" class="form-control" placeholder="City" name = "city" required autofocus>
State
                        <input type="text" class="form-control" placeholder="State" name = "state" required autofocus>
Country
                        <input type="text" class="form-control" placeholder="Country" name = "country" required autofocus>
Sub Category Name                        
                        <input type="text" class="form-control" placeholder="Sub Category Name" name = "itemSubCategoryName" required autofocus>
Choosefile
                         <input type="file" class="form-control" placeholder="chooseFile" name = "file" required>
						 <input type = "hidden" name = "action" value = "itemInput">
                                               <button   type="submit">Submit</button>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                        
                    </div>
    </div>
    
  </form>
</div>


<button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">postview</button>


<form action="./SiopaController" method = "post">
<button type = "submit" style = "width:auto;">show items</button>
<input type = "hidden" name = "action" value = "xyz">
<c:forEach items="${itemList}" var="itemList">
${itemList.image}
	<div class = "column">
			<div id= "img">
			<img src ="./images/items/${itemList.image}">
        	Item Description : ${itemList.description}<br>
        </div>
     </div>
</c:forEach>
</form>

</h1>

<script>
// Get the modal
var modal = document.getElementById('id01');
var modal = document.getElementById('id02');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>