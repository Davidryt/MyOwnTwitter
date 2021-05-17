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
<% Integer rts_original = (Integer) request.getAttribute("rts_original"); 	%>

		<div>				
                <a href="profile?profile=<%=original.getAutor_name() %>"> <%= original.getAutor_name() %> </a>
				<a href="conversacion?id_msg=<%=original.getId() %>"> <%= original.getMensaje() %></a>
				<label> <%= original.datetime() %></label>
				<% if (original.getEs_retweet() != 0) { %>
				 <a href="conversacion?id_msg=<%=original.getEs_retweet() %>"> Ver tweet original </a>
				<% } %>
<% if(usuario != null ) { 	%>
                <form action="retransmision" method="post">
						<input type="hidden" name="idMensaje" value="<%= original.getId() %>">
				    <input type="submit" value="RTx">
				</form>
				<label> <%= rts_original %> retransmisiones</label>


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
<% List<Integer> rts = (List<Integer>) request.getAttribute("rts"); %>
<% for (int i=0; i<answers.size(); i++) { %>
        <div>				
                <a href="profile?profile=<%=answers.get(i).getAutor_name() %>"> <%= answers.get(i).getAutor_name() %> </a>
				<a href="conversacion?id_msg=<%=answers.get(i).getId() %>"> <%= answers.get(i).getMensaje() %></a>
				<label> <%= answers.get(i).datetime() %></label>
<% if(usuario != null ) { 	%>
                <form action="retransmision" method="post">
						<input type="hidden" name="idMensaje" value="<%= answers.get(i).getId() %>">
				    <input type="submit" value="RTx">
				</form>
  <% } %>
				<label> <%= rts.get(i) %> retransmisiones</label>
        </div>
<% } %>

    </body>
</html>
