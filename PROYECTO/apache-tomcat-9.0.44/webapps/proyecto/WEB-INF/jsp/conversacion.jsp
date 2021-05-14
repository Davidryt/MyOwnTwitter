<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>


<!DOCTYPE html>
<html>
    <head>
        <title>Conversacion</title>
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


<% Tweet original = (Tweet) request.getAttribute("original"); 	%>

		<div>				
                <a href="profile?profile=<%=original.getAutor_name() %>"> <%= original.getAutor_name() %> </a>
				<a href="conversacion?id_msg=<%=original.getId() %>"> <%= original.getMensaje() %></a>
				<label> <%= original.datetime() %></label>
<% if(usuario != null ) { 	%>
                <form action="retransmision" method="post">
						<input type="hidden" name="mensaje" value="<%= original.getId() %>">
				    <input type="submit" value="RTx">
				</form>


        </div>

		<div>
			<form action="publish" method="post">
		        <div>
					<p><textarea name="mensaje" rows="3" cols="80" placeholder="Responde a este mensaje"></textarea></p>
					<input type="hidden" name="responde_a" value="<%= original.getId() %>">
				</div>
		        <input type="submit" value="Publicar tu respuesta">
		    </form>
		</div>
 <% } %>

<% List<Tweet> answers = (List<Tweet>) request.getAttribute("answers"); %>
<% for (Tweet tweet: answers) { %>
        <div>				
                <a href="profile?profile=<%=tweet.getAutor_name() %>"> <%= tweet.getAutor_name() %> </a>
				<a href="conversacion?id_msg=<%=tweet.getId() %>"> <%= tweet.getMensaje() %></a>
				<label> <%= tweet.datetime() %></label>
<% if(usuario != null ) { 	%>
                <form action="retransmision" method="post">
						<input type="hidden" name="mensaje" value="<%= tweet.getId() %>">
				    <input type="submit" value="RTx">
				</form>
  <% } %>
        </div>
<% } %>

    </body>
</html>
