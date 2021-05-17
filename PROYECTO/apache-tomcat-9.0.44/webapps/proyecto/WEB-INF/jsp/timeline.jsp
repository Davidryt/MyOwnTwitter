<%@ page language='java' contentType='text/html;charset=utf-8'%>
<%@ page import='twitter.Tweet' %>
<%@ page import='java.util.List' %>

<!DOCTYPE html>
<html>
    <head>
        <title>Timeline</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="styles/general.css">
        <link rel="stylesheet" href="styles/style.css">
		<link rel="stylesheet" href="styles/main.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="./js/sidenav.js"></script>
    </head>
    <body>

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
					<h1 style="color: white">TIMELINE</h1>
				</div>
				<div id="bloc5"> 
           			<form action="logout">
		        		<input type="submit" value="Cerrar Sesión" class="logout" id="logout">
		   			</form>
				</div>
				
        </header>

		<div id="mySidenav" class="sidenav">
  			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
 			<a href="/proyecto/profile">Profile</a>
 			<a href="#">About</a>
  			<a href="#">Help</a>
		</div>


<div class="big">
		<div class="publicar col-12 col-t-12">
			<form action="publish" method="post">
		        <div>
					<p><textarea name="mensaje" rows="5" cols="100" placeholder="Publica un nuevo mensaje"></textarea></p>
				</div>
				<input type="hidden" name="responde_a" value="0">
		        <input type="submit" value="Publicar">
		    </form>
		</div>
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
                	<form action="retransmision" method="post">
							<input type="hidden" name="idMensaje" value="<%= tweets.get(i).getId() %>">
				    	<input type="submit" value="RTx" class="RT">
					</form>
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
<div>





    </body>
</html>
