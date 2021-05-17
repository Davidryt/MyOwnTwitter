<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>

<!DOCTYPE html>
<html>
    <head>
        <title>Timeline</title>
    </head>
    <body>
		<p>
			<form action="logout">
		        <input type="submit" value="Cerrar Sesión">
		    </form>

		</p>

        <h1>TIMELINE</h1>

		<div>
			<form action="publish" method="post">
		        <div>
					<p><textarea name="mensaje" rows="5" cols="80" placeholder="Publica un nuevo mensaje"></textarea></p>
				</div>
				<input type="hidden" name="responde_a" value="0">
		        <input type="submit" value="Publicar">
		    </form>
		</div>

<% List<Tweet> tweets = (List<Tweet>) request.getAttribute("tweets"); %>
<% List<Integer> rts = (List<Integer>) request.getAttribute("rts"); %>
<% for (int i=0; i<tweets.size(); i++) { %>
        <div>				
                <a href="profile?profile=<%=tweets.get(i).getAutor_name() %>"> <%= tweets.get(i).getAutor_name() %> </a>
				<a href="conversacion?id_msg=<%=tweets.get(i).getId() %>"> <%= tweets.get(i).getMensaje() %></a>
				<label> <%= tweets.get(i).datetime() %></label>
				<% if (tweets.get(i).getEs_retweet() != 0) { %>
				 <a href="conversacion?id_msg=<%=tweets.get(i).getEs_retweet() %>"> Ver tweet original </a>
				<% } %>
                <form action="retransmision" method="post">
						<input type="hidden" name="idMensaje" value="<%= tweets.get(i).getId() %>">
				    <input type="submit" value="RTx">
				</form>
				<label> <%= rts.get(i) %> retransmisiones</label>
        </div>
<% } %>
    </body>
</html>
