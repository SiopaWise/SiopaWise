<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
function dochange(){

document.getElementById("add").style.display="block";
document.getElementById("addsubCategory").style.display="none";

}
function Mychange(){
document.getElementById("add").style.display="none";
document.getElementById("addsubCategory").style.display="block";

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


</style>
</head>
<body>

<form action="./SiopaController" method = "post">
<button type = "submit" name = "action" value = "categoryDisplay" style="width:auto;"><font size="4">Category</font></button>
<button type = "submit" name = "action" value = "subCategoryDisplay" style="width:auto;"><font size="4">SubCategory</font></button>
{
<c:forEach items="${categoryList}" var="categoryList">
	if
	<div class = "column">
			<div id= "img">
			<img src ="./images/category/${categoryList.logo}">
        	CategoryName : ${categoryList.categoryName}</td><br>
        </div>
     </div>
</c:forEach>
}

</form>
</body>
</html>