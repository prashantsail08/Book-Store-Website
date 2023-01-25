<%@page import="com.OnlineBookStore.Models.Order"%>

<%@page import="java.util.List"%>
<%@page import="com.OnlineBookStore.Models.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="jquery-3.6.1.js"></script>
<script type="text/javascript" src="LoginValidation.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">



<meta charset="UTF-8">
<title>OrderList</title>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>

		<div id="templatemo_content">
			<jsp:include page="SideBar.jsp"></jsp:include>
			<%
			HttpSession httpSession = request.getSession();
			String username = (String) httpSession.getAttribute("loggedInUser");
			%>

			<%
			List<Order> allOrders = (List<Order>) request.getAttribute("allOrders");
			%>
			<table>
				<tr>
					<td>Order Id</td>
					<td>Order Status</td>
					
					<%if(username!=null && username.equals("admin")){ %>
					<td>Update</td>
					<%} %>

					<td>Total Bill</td>
					<br>
					<td>Customer Name</td>
				</tr>
				<%
				for (int i = 0; i < allOrders.size(); i++) {
					Order order = allOrders.get(i);
				%>
				<tr>
					<td><%=order.getOrderId()%></td>
					
					<form action="ordercontroller" method="post">
						<input type="hidden" name="action" value="UpdateStatus"> 
						<input type="hidden" name="orderId" value="<%=order.getOrderId()%>">
						<%
						if (username != null && username.equals("admin")) {
						%>
<%-- 					<td><input type="text" name="orderStatus" id="orderStatus" value="<%=order.getOrderStatus()%>"></td> --%>
						<td><select id="UpdateStatus" name="UpdateStatus">
									<option values="-1">select</option>
									<option values="Send">send</option>
									<option values="delivered">delivered</option>
							</select></td>
							
					<td><input type="submit" value="Update Status" id="UpdateStatus"></td>
					</form>
					<%
					} else {
					%>
					<td><%=order.getOrderStatus()%></td>
					<%
					}
					%>

					<td><%=order.getTotalBill()%></td>
					<td><%=order.getCustomerName()%></td>
				</tr>

				<%
				}
				%>
			</table>



			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>

</body>
</html>