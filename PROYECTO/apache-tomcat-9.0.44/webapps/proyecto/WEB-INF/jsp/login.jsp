<%@ page language='java' contentType='text/html;charset=utf-8'%>


<!DOCTYPE html>
<html>
    <head>
       <title>Log In Twitter 2</title>
    	<meta charset="UTF-8">
    	<meta name="author" content="David Rico, Daniel Martin">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<link rel="stylesheet" href="styles/log.css">
    </head>
    <body>
        <div class="col-13 col-t-13" id="minihead">
			<h2>Welcome to Twitter 2</h2>
			<h3>The best social network</h3>
		</div>

		<div id="block_container">
			<div class="col-5 col-t-5" id="bloc1">
				<button onclick="document.getElementById('id01').style.display='block'" class="main_but" >Login</button>
				<button onclick="document.getElementById('id02').style.display='block'" class="main_but" >Sign Up</button>
			</div>

			<div class="col-5 col-t-5" id="bloc2">
				<img src="./images/logo.jpg" alt="Twitter LOGO" class="uc3mlogo">
			</div>
		</div>
		
<div id="id01" class="modal">
  
  <form name="login" class="modal-content animate" action="checklogin" method="post">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
	  		<div>
                <label>Usuario
                    <input type="text" name="user" placeholder="Introduzca su usuario">
                </label>
			</div>
			<div>
				<label>Contraseña
                    <input type="password" name="pass">
                </label>
            </div>
            
        
	</div>
	
		<div class="clearfixv1">
        	<input type="submit" value="Acceder" class = "inside_button">
    	</div>
    
  </form>
</div>

<div id="id02" class="modal">
	
	<form id="signup_form" name="signup" class="modal-content animate" action="register" method="post">
		<div class="imgcontainer">
			<span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
        </div>
		<div class="container">
	    	<div>
                <label>Usuario
                    <input type="text" name="userREG" placeholder="Introduzca su usuario">
                </label>
            </div>
			<div>
                <label>Nombre completo
                    <input type="text" name="nombre" placeholder="Introduzca su nombre completo">
                </label>
            </div>
			<div>
				<label>Contraseña
                    <input type="password" name="passREG">
                </label>
            </div>
			<div>
                <label>Mail
                    <input type="email" name="mail" style="width: 100%" >
                </label>
            </div>
			<div>
                <label>Bio
                    <input type="text" name="bio" placeholder="Introduzca una breve biografia">
                </label>
            </div>
		</div>
	
      <div class="clearfix">
      	<input type="submit" value="Registrarse" class = "inside_button">
      </div>
    </div>
  </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="./js/log_script.js"></script>


    </body>
</html>
