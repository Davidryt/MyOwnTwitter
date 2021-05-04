<%@ page language='java' contentType='text/html;charset=utf-8'%>


<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
		<form action="checklogin" method="post">
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
            <input type="submit" value="Acceder">
        </form>

		<h1>Register</h1>
		<form action="register" method="post">
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
                    <input type="email" name="mail" >
                </label>
            </div>
			<div>
                <label>Bio
                    <input type="text" name="bio" placeholder="Introduzca una breve biografia">
                </label>
            </div>
			
            <input type="submit" value="Registrarse">
        </form>
    </body>
</html>
