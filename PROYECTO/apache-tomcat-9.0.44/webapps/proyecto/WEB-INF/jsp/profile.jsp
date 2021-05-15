<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>


<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
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


<% List<String> info = (List<String>) request.getAttribute("info"); %>
        <h1><%= info.get(1) %></h1>
		<h1><%= info.get(2) %></h1>
		<h1><%= info.get(3) %></h1>


<% if(usuario != null ) { 	%>
  <% if(!(usuario.equals(info.get(1))) ) { 	%>
	<% if((boolean) request.getAttribute("followed")) { 	%>
		<form action="unfollow" method="post">
            <div>
                <label>
                    <input type="hidden" name="seguido" value="<%= info.get(1) %>">
                </label>
			</div>
            <input type="submit" value="Dejar de seguir">
        </form>
	<% }else{ %>

			<form action="follow" method="post">
		        <div>
		            <label>
		                <input type="hidden" name="seguido" value="<%= info.get(1) %>">
		            </label>
				</div>
		        <input type="submit" value="Seguir">
		    </form>

	<% } %>
  <% } %>
<% } %>

<% List<Tweet> tweets = (List<Tweet>) request.getAttribute("tweets"); %>
<% for (Tweet tweet: tweets) { %>
        <div>				
                <a href="profile?profile=<%=tweet.getAutor_name() %>"> <%= tweet.getAutor_name() %> </a>
				<a href="conversacion?id_msg=<%=tweet.getId() %>"> <%= tweet.getMensaje() %></a>
				<label> <%= tweet.datetime() %></label>
				<label> <%= tweet.datetime() %></label>
				<% if (tweet.getEs_retweet() != 0) { %>
				 <a href="conversacion?id_msg=<%=tweet.getEs_retweet() %>"> Ver tweet original </a>
				<% } %>
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
