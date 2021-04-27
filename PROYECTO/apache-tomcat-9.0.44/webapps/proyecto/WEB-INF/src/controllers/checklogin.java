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


@WebServlet("/checklogin")
public class checklogin extends HttpServlet {
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

		try (DBManager db = new DBManager()) {
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			boolean checked = db.checkCredentials(user, pass);
			if(checked){
				session.setAttribute("usuario",user);
				response.sendRedirect("timeline");
			}else{
				response.sendRedirect("login?ERROR=1");
			}
			
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.sendError(500);
		}
		
    }
}
