<%@page import="com.OnlineBookStore.Models.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>BOOK LIST</title>
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


			<% List<Book> categoriesBook = (List<Book>)request.getAttribute("categoriesBook");%>

			<div id="templatemo_content_right">

				<%for(int i = 0; i < categoriesBook.size();i++)
        { 
        	Book book = categoriesBook.get(i);
        	if(i % 2 == 0)
        	{%>
				<div class="templatemo_product_box">
					<h1><%=book.getBookName() %>
						<span>(by <%=book.getBookAuthor() %> )
						</span>
					</h1>
					<img
						src="<%= book.getBookImg().substring(book.getBookImg().indexOf("BookStore_Image"))%>"
						alt="image" />
					<div class="product_info">
						<p><%=book.getBookDesc() %></p>
						<h3><%=book.getBookPrice() %></h3>
						<div class="buy_now_button">
							<a
								href="cartcontroller?action=addCart&bookId=<%=book.getBookId()%>&bookName=<%=book.getBookName()%>&bookQuantity=<%=book.getBookQuantity() %>&bookPrice=<%=book.getBookPrice()%>">Add To Cart</a>
						</div>
						<div class="detail_button">
							<a
								href="bookcontroller?action=detail&bookId=<%=book.getBookId() %>">Details</a>
						</div>
					</div>
					<div class="cleaner">&nbsp;</div>
				</div>

				<%} else { %>

				<div class="cleaner_with_width">&nbsp;</div>

				<div class="templatemo_product_box">
					<h1><%=book.getBookName() %>
						<span>(by <%=book.getBookAuthor() %>)
						</span>
					</h1>
					<img
						src="<%= book.getBookImg().substring(book.getBookImg().indexOf("BookStore_Image")) %>"
						alt="image" />
					<div class="product_info">
						<p><%=book.getBookDesc() %>>
						</p>
						<h3><%=book.getBookPrice() %></h3>
						<div class="buy_now_button">
							<a
								href="cartcontroller?action=addCart&bookId=<%=book.getBookId() %>&bookName=<%=book.getBookName()%>&bookQuantity=<%=book.getBookQuantity() %>&bookPrice=<%=book.getBookPrice()%>">Add To Cart</a>
						</div>
						<div class="detail_button">
							<a
								href="bookcontroller?action=detail&bookId=<%=book.getBookId() %>">Details</a>
						</div>
					</div>
</div>
					<% }
        	
        } %>

									
</div>

			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
	
</body>
</html>