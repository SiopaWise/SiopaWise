<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
body {font-family: Arial, Helvetica, sans-serif;}
h1 {font-size: 300%; line-height:100%;font-style: chmpagne;}
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
    padding: 12px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
	style:auto;
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
.row::after {
    content :"";
    clear : both;
    display : table;
    box-sizing : border-box;
}
.column {
    border-radius:5%;
    float : left;
    width : 48%;
    margin:10px;
    padding : 5px;
    color : black;
    background-image :url('../images/coupons.jpg');
    background-repeat:no-repeat;
    background-position-x:2%;
    
}

img {
    height: 20%;
    width: 50%;
    float: right;
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
select{
  width:600px;
  height:40px;

}

</style>
<script type="text/javascript">
function dochange(){

document.getElementById("add").style.display="block";
document.getElementById("addsubCategory").style.display="none";

}
function Mychange(){
document.getElementById("add").style.display="none";
document.getElementById("addsubCategory").style.display="block";

}



</script>
</head>
<body>

<center>
<h1 style ="background-color:brown;color:white">
SIOPA

<input type = "submit" name ="logout" value="LogOut" style="float:right;style.display='block';width:auto;background-color:brown;border:10px solid brown;color:white;">

</h1>

</center>

<!-- <button onclick="dochange();" style="width:auto;"><font size="4">Category</font></button> -->
<!-- <button onclick="Mychange();" style="width:auto;"><font size="4">SubCategory</font></button> -->




<button type="submit" class="positive" name="add" id="add" style="display:block;width:auto;" onclick= "document.getElementById('id01').style.display='block';" ><font size="6">Add Category</font></button>
<button type="submit" class="positive" name="add" id="addsubCategory" style="display:block;width:auto;" onclick="document.getElementById('id02').style.display='block'"><font size="6">Add Sub-Category</font></button>

<form action="./SiopaController" method = "post">
<!-- onclick="dochange();"-->
<button  style="width:auto;"><font size="4">Category</font></button>

<!-- <button type="submit" class="positive" name="add" id="add" style="display:none;width:auto;" onclick= "document.getElementById('id01').style.display='block';"><font size="6">+</font></button>-->
<c:forEach items="${categoryList}" var="categoryList">
	<div class = "column">
			<div id= "img">
			<img src ="./images/category/${categoryList.logo}">
        	CategoryName : ${categoryList.categoryName}<br>
        </div>
     </div>
</c:forEach>



<input type = "hidden" name = "action" value = "button1">


</form>
<form action="./SiopaController" method = "post">
<input type = "hidden" name = "action" value = "button2">
<!-- onclick="Mychange();"-->
<button  style="width:auto;"><font size="4">SubCategory</font></button>

<!-- <button type="submit" class="positive" name="add" id="addsubCategory" style="display:none;width:auto;" onclick="document.getElementById('id02').style.display='block'"><font size="6">+</font></button> -->
<c:forEach items="${subcategoryList}" var="subcategoryList">
	<div class = "column">
			<div id= "img">
			<img src ="./images/subCategory/${subcategoryList.image}">
        	SubCategoryName : ${subcategoryList.subCategoryName}<br>
        </div>
     </div>
</c:forEach>

</form>


<div id="id01" class="modal">



  
  <form class="modal-content animate" action="./SiopaController" method = "post" enctype = "multipart/form-data">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      
       <div data-role="popup" id="myPopup1" class="ui-content" style="min-width:10%;">
                        
                            <div>
                                <div class="container">
                                <div class="row">
                                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                                        <h1 class="text-center login-title">Category</h1>
                                        <div class="user-login">
                                            
                                            <br>
                                            
                                                CategoryName:
                                                <input type="text" class="form-control" name = "catName" placeholder="CategoryName" required autofocus>

                                               
                    <br>                            
					
                                                <div class = "form-group">
                                                
                                                
								<label for = "">Choose Category Image:</label>
								<input type = "file" class = "form-control" id = "filename" name = "fileName" value = "Browse"/>
							<input type = "hidden" name = "action" value = "category">
							</div>
							<div class = "form-group">
								<button type = "submit" class = "btn btn-success"><span class = "glyphicon glyphicon-off"></span>Submit</button>
							</div>
                                                
											
                                              
						
                    
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                        
                    </div>
    </div>
  </form>
</div>




<div id="id02" class="modal">
  
  <form class="modal-content animate" action="./SiopaController" method = "post" enctype = "multipart/form-data">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
       <div data-role="popup" id="myPopup1" class="ui-content" style="min-width:300px;">
                   
                            <div>
                                <div class="container">
                                <div class="row">
                                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                                        <h1 class="text-center login-title">SubCategory</h1>
                                        <div class="user-login">
                                            
                                           <br>
                                           
                                           
                                                 CategoryName:<input type="text" class="form-control" name = "categoryName" placeholder="CategoryName" required autofocus>
                                                
					                              <br>
                                           
                                           
                                               
                                                
					

                                                <div class = "form-group">
                                                SubCategoryName:
                              
                                                <input type="text" class="form-control" name = "subCatName" placeholder="SubCategoryName" required autofocus>
                                                
								<label for = "">Choose Sub category Image</label>
								<input type = "file" class = "form-control" id = "file" name = "fileName" value = "Browse"/>
							<input type = "hidden" name = "action" value = "subCategory">
							</div>
							<div class = "form-group">
								<button type = "submit" class = "btn btn-success"><span class = "glyphicon glyphicon-off"></span>Submit</button>
							</div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                            


                    </div>
    </div>
  </form>
</div>
</h1>

<script>
// Get the modal



</script>

</body>
    </html>