<%@page import="com.OnlineBookStore.Models.Customer"%>
<%@page import="com.OnlineBookStore.Models.Book"%>
<%@page import="com.OnlineBookStore.Models.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Update Customer list</title>
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
			List<Customer> allCustomers = (List<Customer>) request.getAttribute("allCustomers");
			%>
			<table>
				<tr>
					<td>Customer Name</td>
					<td>Customer Address</td>
					<td>Customer Emailid</td>
					<td>Customer Contactno</td>
					<td>Customer Password</td>
					<td>Update Customer</td>
					<td>Update Customer</td>
					
				</tr>
				<%
				for (int i = 0; i < allCustomers.size(); i++) {
					Customer customer= allCustomers.get(i);
				%>
				<tr>
					<td><%=customer.getCustomerName()%></td>
					<td><%=customer.getCustomerAddress()%></td>
					<td><%=customer.getCustomerEmailid()%></td>
					<td><%=customer.getCustomerContactno()%></td>
					<td><%=customer.getCustomerPassword()%></td>
					<td><a
						href="customercontroller?action=DeleteCustomerList&customerId=<%=customer.getCustomerId()%>">Delete </a></td>
						<td><a
						href="customercontroller?action=UpdateCustomerList&customerId=<%=customer.getCustomerId()%>">Update </a></td>
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