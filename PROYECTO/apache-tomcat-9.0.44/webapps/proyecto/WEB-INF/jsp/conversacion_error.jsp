<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>


<!DOCTYPE html>
<html>
    <head>
        <title>Tweet does NOT EXIST</title>
    </head>
    <body>
		
	<% String usuario = (String) request.getAttribute("usuario"); 	%>	
	<% if(usuario != null ) { 	%>
		<p>
			<form action="logout">
		        <input type="submit" value="Cerrar Sesión">
		    </form>
			<form action="timeline">
		        <input type="submit" value="Ir a Vista Principal">
		    </form>

		</p>
	<% } %>


        <h1>TWEET NO ENCONTRADO</h1>
		
    </body>
</html>
