package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import twitter.DBManager;

import javax.naming.NamingException;
import java.sql.SQLException;


@WebServlet("/register")
public class register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();

		String usuario = (String) session.getAttribute("usuario");
        if (usuario != null) {
            response.sendRedirect("timeline");
        }
		else{
			
			try (DBManager db = new DBManager()) {
				String user = request.getParameter("userREG");

				String nombre = request.getParameter("nombre");
				String pass = request.getParameter("passREG");
				String mail = request.getParameter("mail");
				String bio = request.getParameter("bio");

				boolean created = db.newUser(user, pass, nombre, mail, bio);

				if(created){
					session.setAttribute("usuario",user);
					response.sendRedirect("timeline");
				}else{
					response.sendRedirect("login");
				}
				
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}

		}		
		
    }
}
