<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>


<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="styles/general.css">
        <link rel="stylesheet" href="styles/style.css">
		<link rel="stylesheet" href="styles/main.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="./js/sidenav.js"></script>
    </head>
    <body>
<% String usuario = (String) request.getAttribute("usuario"); 	%>	
<header>
            <div class="header">  <!-- Header part: Will be the ssame in each file-->
				<div id="block_container">
                <div class="dropdown" id="bloc1"> <!-- Hamburger menu (only used in phone mode) -->
                    <img src="images/menu.png" class="menu-img" alt="Menu" onclick="openNav()" >
                </div>	
				<div id="bloc2">
					 <img class="profpic" src="images/logo2.png" alt="logo"> <!-- cOURSE MAIN IMAGE-->
				</div>
				<div id="bloc3">
					<h1 style="color: white">PERFIL</h1>
				</div>
				<div id="bloc5"> 
				<% if(usuario != null ) { 	%>
           			<form action="logout">
		        		<input type="submit" value="Cerrar Sesión" class="logout" id="logout">
		   			</form>
				<% } %>
				</div>
				
        </header>

		<div id="mySidenav" class="sidenav">
  			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<% if(usuario != null ) { 	%> 			
				<a href="/proyecto/timeline">Ir a Vista Principal</a>
			<% } %>
 			<a href="#">About</a>
  			<a href="#">Help</a>
		</div>

<div class="publicar col-12 col-t-12">	

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
</div>
<div class="big">
<div class="todo">
<% List<Tweet> tweets = (List<Tweet>) request.getAttribute("tweets"); %>
<% List<Integer> rts = (List<Integer>) request.getAttribute("rts"); %>
<% for (int i=0; i<tweets.size(); i++) { %>
        <table class="tweets">	
			<tr class="fila">
				<th class="columna1"> 			
                	<a href="profile?profile=<%=tweets.get(i).getAutor_name() %>"> <%= tweets.get(i).getAutor_name() %> </a>
				</th>
				<th class="columna2"></th><th class="columna3"></th>
			</tr>
			<tr class="fila"><th class="columna1">
					<a href="conversacion?id_msg=<%=tweets.get(i).getId() %>"> <%= tweets.get(i).getMensaje() %></a>
				</th>
				<th class="columna2">	
				</th><th class="columna3"><label> <%= tweets.get(i).datetime() %></label></th>
			</tr>
			<tr class="fila"><th class="columna1">
				<% if(usuario != null ) { 	%>
                	<form action="retransmision" method="post">
							<input type="hidden" name="idMensaje" value="<%= tweets.get(i).getId() %>">
				    	<input type="submit" value="RTx" class="RT">
					</form>
				<% } %>
				</th><th class="columna2">
					<label> <%= rts.get(i) %> retransmisiones</label>
				</th>
				<th class="columna3">
					<% if (tweets.get(i).getEs_retweet() != 0) { %>
					 <a href="conversacion?id_msg=<%=tweets.get(i).getEs_retweet() %>"> Ver tweet original </a>
					<% } %>
				</th></tr>
        </table>
<% } %>
	</div>
    </body>
</html>
