<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery-3.6.1.js"></script>
<script type="text/javascript" src="BookValidation.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>Insert title here</title>
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

			<div align="center">
				<form action="bookcontroller" method="post">
					<input type="hidden" name="action" value="addBook">
					<table>
						<tr>
							<td>Book Name</td>
							<td><input type="text" name="bookName" id="bookName"></td>
							<td><span id="spBookName"></span></td>
						</tr>

						<tr>
							<td>Book Author</td>
							<td><input type="text" name="bookAuthor" id="bookAuthor"></td>
							<td><span id="spBookAuthor"></span></td>
						</tr>

						<tr>
							<td>Book Price</td>
							<td><input type="text" name="bookPrice" id="bookPrice"></td>
							<td><span id="spBookPrice"></span></td>
						</tr>

						<tr>
							<td>Book Publisher</td>
							<td><select id="bookPublisher" name="bookPublisher">
									<option values="-1">select</option>
									<option values="Squad">Squad</option>
									<option values="CT">CT</option>
							</select></td>
							<td><span id="spBookPublisher"></span></td>
						</tr>

						<tr>
							<td>Book Quantity</td>
							<td><input type="text" name="bookQuantity" id="bookQuantity"></td>
							<td><span id="spBookQuantity"></span></td>
						</tr>

						<tr>
							<td>Book Category</td>
							<td><input type="text" name="bookCategory" id="bookCategory"></td>
							<td><span id="spBookCategory"></span></td>
						</tr>

						<tr>
							<td>Book Desc</td>
							<td><input type="text" name="bookDesc" id="bookDesc"></td>
							<td><span id="spBookDesc"></span></td>
						</tr>


					</table>
					<tr>
						<td></td>
						<td><input type="submit" value="Add New Book" id="bookSubmit"></td>
						<td></td>
					</tr>
				</form>
				<form action="bookcontroller" method="get">
					<input type="hidden" name="action" value="fromUpdateBook">
					<td><input type="submit" value="Update Book" id="UpdateBook"></td>
				</form>

			</div>
			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>


</body>
</html>