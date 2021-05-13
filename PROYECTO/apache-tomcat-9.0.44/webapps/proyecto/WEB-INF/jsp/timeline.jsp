<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>

<!DOCTYPE html>
<html>
    <head>
        <title>Timeline</title>
    </head>
    <body>
        <h1>TIMELINE</h1>
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
