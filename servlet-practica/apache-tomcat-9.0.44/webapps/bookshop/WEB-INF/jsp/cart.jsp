<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='bookshop.Book' %>
<%@ page import='java.util.List' %>

<!DOCTYPE html>
<html>
    <head>
        <title>Cart</title>
    </head>
    <body>
        <h1>Books in your cart</h1>
		<table>
<% List<Book> books = (List<Book>) session.getAttribute("cart"); %>
<% for (Book book: books) { %>
			<tr>
				<th><%= book.getIsbn() %></th>
				<th><%= book.getTitle() %></th>
			</tr>
<% } %>
		</table>
    </body>
</html>
