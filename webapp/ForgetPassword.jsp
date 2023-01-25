<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="jquery-3.6.1.js"></script>
<script type="text/javascript" src="LoginValidation.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">



<meta charset="UTF-8">
<title>Forget Password</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

    <div id="templatemo_content">
    		<jsp:include page="SideBar.jsp"></jsp:include>

<div align="center">
	<form action="logincontroller" method="post" >
	<input type="hidden" name="action" value=fromForgot>
		<table>
			<tr>
				<td>Customer UserName</td>
				<td><input type="text" name="userName" id="userName"></td>
				<td><span id="spUserName"></span></td>
			</tr>

			<tr>
				<td>New Password</td>
				<td><input type="text" name="userPass" id="userPass"></td>
				<td><span id="spUserPass"></span></td>
			</tr>

		</table>
		<tr>
			<td></td>
			<td><input type="submit" value="Change Passsword" id="forgotPassword"></td>
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