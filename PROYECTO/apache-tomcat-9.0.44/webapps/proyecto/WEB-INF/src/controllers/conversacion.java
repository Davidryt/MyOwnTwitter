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
import twitter.Tweet;

import javax.naming.NamingException;
import java.sql.SQLException;


@WebServlet("/conversacion")
public class conversacion extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();
		
		int id_msg = Integer.parseInt(request.getParameter("id_msg"));
		String usuario = (String) session.getAttribute("usuario");
		if (id_msg == 0){

			request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/conversacion_error.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		try (DBManager db = new DBManager()) {

			Tweet original = db.getTweet(id_msg);
			if(original != null){
				request.setAttribute("original", original);
				
				if (original.getResponde_a()==0){

					List<Tweet> answers = db.getAnswers(id_msg);
					request.setAttribute("answers", answers);
					request.setAttribute("usuario", usuario);

					int rts_original = db.rtCount(original);
					request.setAttribute("rts_original", rts_original);		

					List<Integer> rts = db.rtCountList(answers);
					request.setAttribute("rts", rts);				

					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/conversacion.jsp");
					rd.forward(request, response);
				
				}else{
					response.sendRedirect("conversacion?id_msg="+original.getResponde_a());
				}
			}else{
				request.setAttribute("usuario", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/conversacion_error.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.sendError(500);
		}

		
    }
}
