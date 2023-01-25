<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="jquery-3.6.1.js"></script>
<script type="text/javascript" src="LoginValidation.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">



<meta charset="UTF-8">
<title>Search Book</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

    <div id="templatemo_content">
    		<jsp:include page="SideBar.jsp"></jsp:include>

<div align="center">
	<form action="bookcontroller" method="get" >
	<input type="hidden" name="action" value="BookSearch">
		<table>
			<tr>
				<td>Search By BookName</td>
				<td><input type="text" name="searchBookName" id="searchBookName"></td>
				
			</tr>
		</table>
		<tr>
			<td></td>
			<td><input type="submit" value="Search" id="searchBookSubmit"></td>
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