<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Header</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%HttpSession httpSession = request.getSession();
String username = (String)httpSession.getAttribute("loggedInUser"); %>
	<div id="templatemo_menu">
    	<ul>
            <li><a href="bookcontroller?action=home" class="current">Home</a></li>
            <li><a href="bookcontroller?action=SearchBook">Search</a></li>
            
            <%if(username != null && username.equals("admin")){ %>
            <li><a href="bookcontroller?action=addBook">AddBook</a></li> 
            <%} else { %>
            <li><a href="bookcontroller?action=home">Books</a></li>   
            <%} %>   
            
            <%if(username != null && username.equals("admin")){ %>       
              <li><a href="customercontroller?action=ShowCustomer">Show All Customers</a></li> 
            <%} else { %>
            <li><a href="cartcontroller?action=ShowCart">Show All Cart</a></li> 
            <%} %>
            
             <%if(username != null && username.equals("admin")){ %> 
            <li><a href="logincontroller?action=OrderList">All Orders</a></li>
            <%} else { %>
             <li><a href="logincontroller?action=OrderStatus">Order Status</a></li>
             <%} %>
             
             
            <li><a href="logincontroller?action=Logout">LogOut</a></li>
			
			<% if(username !=null) {%>
			<li><a href="#">Welcome <%=username%></a></li>
			<%}else{%>
			<li><a href="#"></a></li>
			<%}%>
			
    	</ul>
    </div> <!-- end of menu -->
    
    <div id="templatemo_header">
    	<div id="templatemo_special_offers">
        	<p>
                <span>25%</span> discounts for
        purchase over $80
        	</p>
			<a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
        
        
        <div id="templatemo_new_books">
        	<ul>
                <li>Suspen disse</li>
                <li>Maece nas metus</li>
                <li>In sed risus ac feli</li>
            </ul>
            <a href="subpage.html" style="margin-left: 50px;">Read more...</a>
        </div>
    </div> <!-- end of header -->


</body>
</html>