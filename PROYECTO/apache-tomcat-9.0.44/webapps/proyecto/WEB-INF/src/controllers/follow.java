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


@WebServlet("/follow")
public class follow extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();

		String usuario = (String) session.getAttribute("usuario");
        if (usuario != null) {
            try (DBManager db = new DBManager()) {
				db.follow(usuario, request.getParameter("seguido"));
				response.sendRedirect("profile?profile=" + request.getParameter("seguido"));
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
			
        }
		else{
			response.sendRedirect("login");
		}
		
    }
}
