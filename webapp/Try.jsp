<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<style>
select#portfolio {
	font-size: 50px;
	background-color: #71532c;
	color: #FF9800;
}
</style>

	<form>
		<select name="portfolio" id="portfolio">
		

		<option value="#" disabled selected>HTML</option>
		<option value="Cart.jsp">Cart</option>
		<option value="Login.jsp">Login</option>
</select>
	</form>
	<script>
		var urlMenu = document.getElementById('portfolio');
		urlMenu.onchange = function() {
			var useroption = this.options[this.selectedIndex];
			if (useroption.value != "nothing") {
				window.open(useroption.value, "HTML CSS JAVASCRIPT", "")
			}
		}
	</script>

</body>
</html>