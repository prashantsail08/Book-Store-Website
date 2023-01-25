<%@page import="com.OnlineBookStore.Models.Payment"%>
<%@page import="com.OnlineBookStore.Models.Customer"%>
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
<title>Credit Card</title>
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
			Customer customer = (Customer) request.getAttribute("customer");
			%>
			<%
			Payment payment = (Payment) request.getAttribute("payment1");
			%>

			
			<form action="paymentcontroller" method="post">
				<input type="hidden" name="action" value="addCards">
				<input type="hidden" name="payType" value="<%=payment.getPayType()%>">
				<table>
					<h3>Enter Your Credit Card Details</h3>

					<tr>
						<td>User Name</td>
						<td><%=customer.getCustomerEmailid()%></td>
					</tr>
					<tr>
						<td>Bank Name</td>
						<td><select id="bankName" name="bankName">
								<option values="-1">select</option>
								<option values="SBI">SBI</option>
								<option values="HDFC">HDFC</option>
						</select></td>
						<td><span id="spBankNamee"></span></td>
					</tr>

					<tr>
						<td>Card Number</td>
						<td><input type="number" name="cardNumber" id="cardNumber"></td>
						<td><span id="spCardNumber"></span></td>
					</tr>

					<tr>
						<td>Name of Card</td>
						<td><input type="text" name="cardName" id="cardName"></td>
						<td><span id="spCardName"></span></td>
					</tr>

					<tr>
						<td>Valid Till</td>
						<td><input type="date" name="date" id="date"></td>
						<td><span id="spCardDate"></span></td>
					</tr>

					<tr>
						<td>Card CVV</td>
						<td><input type="text" name="cardCvv" id="cardCvv"></td>
						<td><span id="spCardCvv"></span></td>
					</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="SAVE" id="cardSubmit"></td>
					<td></td>
				</tr>
				</table>
			</form>
<%-- <%} %> --%>


		</div>
		<!-- end of content left -->


		<div class="cleaner_with_height">&nbsp;</div>

		<!-- end of content -->
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>


</body>
</html>