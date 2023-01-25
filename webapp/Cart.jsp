<%@page import="com.OnlineBookStore.Models.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cart</title>
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

			<%
			List<Cart> allCart = (List<Cart>) request.getAttribute("allCart");
			%>
			<table>
				<tr>
					<td>Book Name</td>
					<td>Book Price</td>
					<td>Book Quantity</td>
					<td>Action</td>
					<%
					Cart cart1 = new Cart(); %>
					<td><a href="ordercontroller?action=ClearCart">Clear Cart</a></td>
				</tr>
				<%
				for (int i = 0; i < allCart.size(); i++) {
					Cart cart = allCart.get(i);
				%>
				<tr>
					<td><%=cart.getBookName()%></td>
					<td><%=cart.getBookPrice()%></td>

					<form action="cartcontroller" method="get">
						<input type="hidden" name="action" value="quantity"> 
						<input type="hidden" name="cartId" value="<%=cart.getCartId()%>">
						
						<td><select id="quantity" name="quantity">
								<option values="-1"><%=cart.getQuantity() %></option>
								<option values=1>1</option>
								<option values=2>2</option>
						</select></td>
					<td><input type="submit" value="Update Quantity" id="quantity"></td>
					</form>
					<td><a
						href="cartcontroller?action=DeleteCart&cartId=<%=cart.getCartId()%>">Delete</a></td>
				</tr>

				<%
				}
				%>
			</table>
			<form action="ordercontroller" method="get">
				<input type="hidden" name="action" value="placeOrder">
				<%--<input type="hidden" name="bookId" value="<%=cart.getCartId()%>"> --%>

				<td><input type="submit" value="Place Order" id="placeOrder"></td>
			</form>

			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>