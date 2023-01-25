<%@page import="com.OnlineBookStore.Models.Payment"%>
<%@page import="com.OnlineBookStore.Models.Order"%>
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
<meta name="keywords"
	content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description"
	content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>

		<div id="templatemo_content">
			<jsp:include page="SideBar.jsp"></jsp:include>



<% Book book =(Book)request.getAttribute("book");%>

			<form action="paymentcontroller" method="get">
				<input type="hidden" name="action" value="addReciept">
			<input type="hidden" name="bookId" value="<%=book.getBookId()%>">
				<table>
					<tr>
						<td>Order Id</td>
<%-- 						<td><input type="text" name="orderId" id="orderId" value="<%=order.getOrderId()%>"></td> --%>
					</tr>
					
					<tr>
					<td><%=book.getBookName() %></td>
					</tr>
					
					
					<tr>
					<td>Total Bill</td>
<%-- 						<td><input type="text" name="orderId" id="orderId" value="<%=order.getTotalBill()%>"></td> --%>
						
					</tr>
					
					
					
					</table>
					</form>
					
			
					
					
					
					
					
		</div>
		<!-- end of content left -->


		<div class="cleaner_with_height">&nbsp;</div>

		<!-- end of content -->
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>


</body>
</html>