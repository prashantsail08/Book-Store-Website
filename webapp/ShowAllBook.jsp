
<%@page import="com.OnlineBookStore.Models.Cart"%>
<%@page import="com.OnlineBookStore.Models.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SHOW ALL BOOK</title>
</head>
<body>
	<%
	List<Book> allBooks = (List<Book>) request.getAttribute("allBooks");

	//System.out.println(allBooks);
	%>

	<div id="templatemo_content_right">

		<%
		for (int i = 0; i < allBooks.size(); i++) {
			Book book = allBooks.get(i);
			if (i % 2 == 0) {
		%>

		<div class="templatemo_product_box">
			<h1><%=book.getBookName()%>
				<span>(by <%=book.getBookAuthor()%>)
				</span>
			</h1>
			<img
				src="<%=book.getBookImg().substring(book.getBookImg().indexOf("BookStore_Image"))%>"
				alt="image" />
			<div class="product_info">
				<p><%=book.getBookDesc()%></p>
				<h3><%=book.getBookPrice()%></h3>
				

				<div class="buy_now_button">
					<a
						href="cartcontroller?action=addCart&bookId=<%=book.getBookId()%>&bookName=<%=book.getBookName()%>&bookPrice=<%=book.getBookPrice()%>">Add
						to Cart</a>
				</div>
				<div class="detail_button">
					<a
						href="bookcontroller?action=detail&bookId=<%=book.getBookId()%>&bookName=<%=book.getBookName()%>&bookDesc=<%=book.getBookDesc()%>">Detail</a>
				</div>
			</div>
			<div class="cleaner">&nbsp;</div>
		</div>

		<%
		} else {
		%>

		<div class="cleaner_with_width">&nbsp;</div>

		<div class="templatemo_product_box">
			<h1><%=book.getBookName()%>
				<span>(by <%=book.getBookAuthor()%>)
				</span>
			</h1>
			<img
				src="<%=book.getBookImg().substring(book.getBookImg().indexOf("BookStore_Image"))%>"
				alt="image" />
			<div class="product_info">
				<p><%=book.getBookDesc()%>>
				</p>
				<h3><%=book.getBookPrice()%></h3>
				<div class="buy_now_button">
					<a
						href="cartcontroller?action=addCart&bookId=<%=book.getBookId()%>&bookName=<%=book.getBookName()%>&bookPrice=<%=book.getBookPrice()%>">Add
						to Cart</a>
				</div>
				<div class="detail_button">
					<a
						href="bookcontroller?action=detail&bookId=<%=book.getBookId()%>&bookName=<%=book.getBookName()%>&bookDesc=<%=book.getBookDesc()%>">Detail</a>
				</div>
			</div>
			<div class="cleaner">&nbsp;</div>
		</div>

		<div class="cleaner_with_height">&nbsp;</div>

		<%
		}
		}
		%>

		<a href="subpage.html"><img src="images/templatemo_ads.jpg"
			alt="ads" /></a>
	</div>
	<!-- end of content right -->
</body>
</html>