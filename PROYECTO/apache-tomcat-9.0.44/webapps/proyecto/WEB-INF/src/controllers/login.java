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


@WebServlet("/login")
public class login extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();

		String usuario = (String) session.getAttribute("usuario");
        if (usuario != null) {
            response.sendRedirect("timeline");
        }
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
		}
		
    }
}
