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
		        <input type="submit" value="Publicar">
		    </form>
		</div>

<% List<Tweet> tweets = (List<Tweet>) request.getAttribute("tweets"); %>
<% for (Tweet tweet: tweets) { %>
        <div>				
                <a href="profile?profile=<%=tweet.getAutor_name() %>"> <%= tweet.getAutor_name() %> </a>
				<a href="conversacion?id_msg=<%=tweet.getId() %>"> <%= tweet.getMensaje() %></a>
				<label> <%= tweet.datetime() %></label>
				<% if (tweet.getEs_retweet() != 0) { %>
				 <a href="conversacion?id_msg=<%=tweet.getEs_retweet() %>"> Ver tweet original </a>
				<% } %>
                <form action="retransmision" method="post">
						<input type="hidden" name="idMensaje" value="<%= tweet.getId() %>">
				    <input type="submit" value="RTx">
				</form>
        </div>
<% } %>
    </body>
</html>
