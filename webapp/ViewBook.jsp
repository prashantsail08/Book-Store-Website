<%@page import="com.OnlineBookStore.Models.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery-3.6.1.js"></script>
<script type="text/javascript" src="BookValidation.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>View Book</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

    <div id="templatemo_content">
    		<jsp:include page="SideBar.jsp"></jsp:include>

<% Book book =(Book)request.getAttribute("allBooks");%> 


        <div id="templatemo_content_right">
        	
            <h1><%=book.getBookName() %> <span>(<%=book.getBookAuthor() %>)</span></h1>
            <div class="image_panel"><img src="<%= book.getBookImg().substring(book.getBookImg().indexOf("BookStore_Image")) %>" alt="image" /></div>
        <!--   <h2>Read the lessons - Watch the videos - Do the exercises</h2>
            <ul>
	            <li>By Deke <a href="#">McClelland</a></li>
            	<li>January 2024</li>
                <li>Pages: 498</li>
                <li>ISBN 10: 0-496-91612-0 | ISBN 13: 9780492518154</li>
            </ul> -->
            
            <p><%=book.getBookDesc() %></p>

             <div class="cleaner_with_height">&nbsp;</div>
             
           
            
            <a href="index.html"><img src="images/templatemo_ads.jpg" alt="css template ad" /></a>
            
        </div> <!-- end of content right -->
    
  

       
        </div> <!-- end of content left -->
        
 
    	<div class="cleaner_with_height">&nbsp;</div>

    <!-- end of content -->
    	<jsp:include page="Footer.jsp"></jsp:include>
 </div>


</body>
</html>