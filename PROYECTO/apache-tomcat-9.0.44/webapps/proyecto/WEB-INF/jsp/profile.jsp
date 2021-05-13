<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>


<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
    </head>
    <body>
<% List<String> info = (List<String>) request.getAttribute("info"); %>
        <h1><%= info.get(1) %></h1>
		<h1><%= info.get(2) %></h1>
		<h1><%= info.get(3) %></h1>

<% String usuario = (String) request.getAttribute("usuario"); 	%>
<% if(usuario != null) { 	%>
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

<% List<Tweet> tweets = (List<Tweet>) request.getAttribute("tweets"); %>
<% for (Tweet tweet: tweets) { %>
        <div>				
                <a href="profile?profile=<%=tweet.getAutor_name() %>"> <%= tweet.getAutor_name() %> </a>
				<label> <%= tweet.getMensaje() %></label>
				<label> <%= tweet.datetime() %></label>
                
        </div>
<% } %>
    </body>
</html>
