<%@page import="com.OnlineBookStore.Models.Publisher"%>
<%@page import="com.OnlineBookStore.Models.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIDE BAR</title>
<meta name="keywords"
	content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description"
	content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<%
	List<Category> allCategories = (List<Category>) request.getAttribute("allCategories");
	List<Publisher> allPublishers = (List<Publisher>) request.getAttribute("allPublishers");
	%>
	<%

	%>
	<div id="templatemo_container">
		<div id="templatemo_content">
			<div id="templatemo_content_left">
				<div class="templatemo_content_left_section">
					<h1>Categories</h1>
					<ul>
						<%if(allCategories != null){
							if(allCategories.size() !=0){
						
								for (int i = 0; i < allCategories.size(); i++) {
							Category category = allCategories.get(i);
							if(i%1==0){	
						%>
						<li><a href="bookcontroller?action=categories&categoryName=<%=category.getCategoryName()%>"> <%=category.getCategoryName() %></a></li>
						<%
							}else {
						%>
						<li><a href="bookcontroller?action=categories&categoryName=<%=category.getCategoryName()%>"> <%=category.getCategoryName() %>>heee</a></li>
						<%} }}}%>
					
						
					</ul>
				</div>
				<div class="templatemo_content_left_section">
					<h1>Publishers</h1>
					<ul>
						<%if(allPublishers != null){
							if(allPublishers.size() !=0){
						
								for (int i = 0; i < allPublishers.size(); i++) {
							Publisher publisher = allPublishers.get(i);
							
							if(i%1==0){	
						%>
						<li><a href="bookcontroller?action=publishers&publisherName=<%=publisher.getPublisherName()%>"> <%=publisher.getPublisherName() %></a></li>
						<%
							}else {
						%>
						<li><a href="bookcontroller?action=publishers&publisherName=<%=publisher.getPublisherName()%>"> <%=publisher.getPublisherName() %></a></li>
						<%} }}}%>
					</ul>
				</div>

				<div class="templatemo_content_left_section">
					<a href="http://validator.w3.org/check?uri=referer"><img
						style="border: 0; width: 88px; height: 31px"
						src="http://www.w3.org/Icons/valid-xhtml10"
						alt="Valid XHTML 1.0 Transitional" width="88" height="31"
						vspace="8" border="0" /></a> <a
						href="http://jigsaw.w3.org/css-validator/check/referer"><img
						style="border: 0; width: 88px; height: 31px"
						src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
						alt="Valid CSS!" vspace="8" border="0" /></a>
				</div>
			</div>
			<!-- end of content left -->

		</div>
	</div>
</body>
</html>