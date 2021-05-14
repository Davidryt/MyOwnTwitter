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


@WebServlet("/publish")
public class publish extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();

		String usuario = (String) session.getAttribute("usuario");
		int responde_a = Integer.parseInt(request.getParameter("responde_a"));
        if (usuario != null) {
            try (DBManager db = new DBManager()) {
				if(responde_a == 0){
					db.publicarTweet(usuario, request.getParameter("mensaje"));
					response.sendRedirect("timeline");
				}else{
					db.publicarTweet(usuario, request.getParameter("mensaje"),responde_a);
					response.sendRedirect("conversacion?id_msg="+responde_a);
				}
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
