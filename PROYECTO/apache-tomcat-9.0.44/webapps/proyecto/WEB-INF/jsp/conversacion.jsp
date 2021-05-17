<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>


<!DOCTYPE html>
<html>
    <head>
        <title>Conversacion</title>
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
					<h1 style="color: white">CONVERSACIÓN</h1>
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
<div class="big">
<div class="publicar col-12 col-t-12" style="padding-top : 140px">	
<% Tweet original = (Tweet) request.getAttribute("original"); 	%>
<% Integer rts_original = (Integer) request.getAttribute("rts_original"); 	%>

		<table class="tweets">	
			<tr class="fila">
				<th class="columna1"> 			
                	<a href="profile?profile=<%=original.getAutor_name() %>"> <%= original.getAutor_name() %> </a>
				</th>
				<th class="columna2"></th><th class="columna3"></th>
			</tr>
			<tr class="fila"><th class="columna1">
					<a href="conversacion?id_msg=<%=original.getId() %>"> <%= original.getMensaje() %></a>
				</th>
				<th class="columna2">	
				</th><th class="columna3"><label> <%= original.datetime() %></label></th>
			</tr>
			<tr class="fila"><th class="columna1">
				<% if(usuario != null ) { 	%>
                	<form action="retransmision" method="post">
							<input type="hidden" name="idMensaje" value="<%= original.getId() %>">
				    	<input type="submit" value="RTx" class="RT">
					</form>
				<% } %>
				</th><th class="columna2">
					<label> <%= rts_original %> retransmisiones</label>
				</th>
				<th class="columna3">
					<% if (original.getEs_retweet() != 0) { %>
					 <a href="conversacion?id_msg=<%=original.getEs_retweet() %>"> Ver tweet original </a>
					<% } %>
				</th></tr>
        </table>

		<div>
			<form action="publish" method="post">
		        <div>
					<p><textarea name="mensaje" rows="3" cols="100" placeholder="Responde a este mensaje"></textarea></p>
					<input type="hidden" name="responde_a" value="<%= original.getId() %>">
				</div>
		        <input type="submit" value="Publicar tu respuesta">
		    </form>
		</div>

</div>

<div class="todo">
<% List<Tweet> tweets = (List<Tweet>) request.getAttribute("answers"); %>
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
