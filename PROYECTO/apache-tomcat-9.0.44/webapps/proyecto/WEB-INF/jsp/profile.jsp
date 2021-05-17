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

<% int followers = (int) request.getAttribute("followers"); %>
<% List<String> info = (List<String>) request.getAttribute("info"); %>
        <h1><%= info.get(1) %></h1>
		<h1><%= info.get(2) %></h1>
		<h1><%= info.get(3) %></h1>
		<h3><%= followers %> seguidores</h3>


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
<% List<Integer> rts = (List<Integer>) request.getAttribute("rts"); %>
<% for (int i=0; i<tweets.size(); i++) { %>
        <div>				
                <a href="profile?profile=<%=tweets.get(i).getAutor_name() %>"> <%= tweets.get(i).getAutor_name() %> </a>
				<a href="conversacion?id_msg=<%=tweets.get(i).getId() %>"> <%= tweets.get(i).getMensaje() %></a>
				<label> <%= tweets.get(i).datetime() %></label>
				<label> <%= tweets.get(i).datetime() %></label>
				<% if (tweets.get(i).getEs_retweet() != 0) { %>
				 <a href="conversacion?id_msg=<%=tweets.get(i).getEs_retweet() %>"> Ver tweets original </a>
				<% } %>
				<% if(usuario != null ) { 	%>
                <form action="retransmision" method="post">
						<input type="hidden" name="idMensaje" value="<%= tweets.get(i).getId() %>">
				    <input type="submit" value="RTx">
				</form>
				<% } %>
				<label> <%= rts.get(i) %> retransmisiones</label>
        </div>
<% } %>
    </body>
</html>
