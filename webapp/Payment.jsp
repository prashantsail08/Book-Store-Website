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
<title>Payment</title>
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
			HttpSession httpSession = request.getSession();
			String username = (String) httpSession.getAttribute("loggedInUser");
			%>
<% 
			Customer customer = (Customer) request.getAttribute("customer");
			%>
			<%
			Payment payment = (Payment) request.getAttribute("payment1");
			%>
			
  			
			<form action="paymentcontroller" method="get">
				<input type="hidden" name="action" value="payment">
			

				<table>
					<tr>
					<td>Payment Details</td>
						<td><select id="paymentType" name="paymentType">
								<option value="-1">SELECT Payment Type</option>
								<option value="COD">COD</option>
								<option value="DebitCard">Debit Card</option>
								<option value="CreditCard">Credit Card</option>
						</select></td>
					
					<tr>
					<td></td>
						<td><input type="submit" value="Make Payment" id="payment"></td>
						<td></td>
					</tr>
					</tr>
				</table>
			</form>

















			<!-- 		<script>
				var urlMenu = document.getElementById('paymentType');
				urlMenu.onchange = function() {
					var useroption = this.options[this.selectedIndex];
					if (useroption.value != "nothing") 
					{
						window.open(useroption.value, "Cart Login","")
					}
				}
			</script> -->







		</div>
		<!-- end of content left -->


		<div class="cleaner_with_height">&nbsp;</div>

		<!-- end of content -->
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>


</body>
</html>