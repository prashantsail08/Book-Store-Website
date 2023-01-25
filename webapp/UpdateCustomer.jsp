
<%@page import="com.OnlineBookStore.Models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

    <div id="templatemo_content">
    		<jsp:include page="SideBar.jsp"></jsp:include>
<%Customer customer= (Customer)request.getAttribute("customer"); %>
<div align="center">
<form action="customercontroller" method="post">
<input type="hidden" name="action" value="updateCustomer">
<input type="hidden" name="customerId" value="<%=customer.getCustomerId() %>">
		<table>
			<tr>
				<td>Customer Name</td>
				<td><input type="text" name="customerName" id="customerName" value="<%=customer.getCustomerName() %>"></td>
				<td><span id="spCustomerName"></span></td>
			</tr>

			<tr>
				<td>Customer Address</td>
				<td><input type="text" name="customerAddress" id="customerAddress" value="<%=customer.getCustomerAddress() %>">
				</td>
				<td><span id="spCustomerAddress"></span></td>
			</tr>

			<tr>
				<td>Customer Emailid</td>
				<td><input type="text" name="customerEmailid" id="customerEmailid" value="<%=customer.getCustomerEmailid() %>">
				</td>
				<td><span id="spCustomerEmailid"></span></td>
			</tr>

			<tr>
				<td>Customer Contactno</td>
				<td><input type="text" name="customerContactno" id="customerContactno" value="<%=customer.getCustomerContactno() %>">
				</td>
				<td><span id="spCustomerContactno"></span></td>
			</tr>
			
			<tr>
				<td>Customer Password</td>
				<td><input type="text" name="customerPassword" id="customerPassword" value="<%=customer.getCustomerPassword() %>">
				</td>
				<td><span id="spCustomerPassword"></span></td>
			</tr>
		
			
		</table>
		<tr>
			<td></td>
			<td><input type="submit" value="Update Customer" id="customerSubmit"></td>
			<td></td>
		</tr>
	</form>
	</div>
    	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    	<jsp:include page="Footer.jsp"></jsp:include>
 </div>
</body>
</html>