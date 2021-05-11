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
