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


@WebServlet("/profile")
public class profile extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();
		String usuario = (String) session.getAttribute("usuario");
		String profile = (String) request.getParameter("profile");
		if (profile == null){
			request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile_error.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		try (DBManager db = new DBManager()) {
			List<String> info = db.getProfile(profile);
			if (info == null){
				request.setAttribute("usuario", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile_error.jsp");
				rd.forward(request, response);
			}
			
			String aux = info.get(0);
			int user = Integer.parseInt(aux);
			int n_followers = db.followersCount(user);
			List<Tweet> tweets = db.getProfileTweet(user);

			List<Integer> rts = db.rtCountList(tweets);
			request.setAttribute("rts", rts);
			request.setAttribute("followers", n_followers);
			
			request.setAttribute("info", info);
			request.setAttribute("tweets", tweets);
			request.setAttribute("usuario", usuario);
			request.setAttribute("followed", db.checkFollow(usuario, profile));
			

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
			rd.forward(request, response);

		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.sendError(500);
		}

		
    }
}
