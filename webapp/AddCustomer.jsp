<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="jquery-3.6.1.js"></script>
<script type="text/javascript" src="CustomerValidation.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

    <div id="templatemo_content">
    		<jsp:include page="SideBar.jsp"></jsp:include>

<div align="center">
	<form action="customercontroller" method ="post">
	<input type="hidden" name="action" value="addCustomer" >
		<table>
			<tr>
				<td>Customer Name</td>
				<td><input Type="text" name="customerName" id="customerName"></td>
				<td><span id="spCustomerName"></span></td>
			</tr>
			
			<tr>
				<td>Customer Address</td>
				<td><input Type="text" name="customerAddress" id="customerAddress"></td>
				<td><span id="spCustomerAddress"></span></td>
			</tr>
			
			<tr>
				<td>Customer Emailid</td>
				<td><input Type="text" name="customerEmailid" id="customerEmailid"></td>
				<td><span id="spCustomerEmailid"></span></td>
			</tr>
			
			<tr>
				<td>Customer Contactno</td>
				<td><input Type="text" name="customerContactno" id="customerContactno"></td>
				<td><span id="spCustomerContactno"></span></td>
			</tr>
			
			<tr>
				<td>Customer Password</td>
				<td><input Type="text" name="customerPassword" id="customerPassword"></td>
				<td><span id="spCustomerPassword"></span></td>
			</tr>
			
		</table>
			<tr>
				<td></td>
				<td><input Type="submit" name="submit" value="Customer Login" id="customerSubmit"></td>
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