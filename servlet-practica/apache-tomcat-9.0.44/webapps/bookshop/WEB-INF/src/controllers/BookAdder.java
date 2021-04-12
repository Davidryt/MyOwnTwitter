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

import bookshop.Book;
import bookshop.DBManager;

import javax.naming.NamingException;
import java.sql.SQLException;


@WebServlet("/add")
public class BookAdder extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Obtiene el carro de la compra desde la sesión. Lo crea si no existe.
        HttpSession session = request.getSession();
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Book>();
            session.setAttribute("cart", cart);
        }

		String[] params = request.getParameterValues("book");
		Book b;
		
		try (DBManager db = new DBManager()) {

			if(params != null){
				for(String p: params){
					b = db.searchBook(Integer.parseInt(p));
					cart.add(b);
				}
			}

			session.setAttribute("cart", cart);

			response.sendRedirect("cart");
		}catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.sendError(500);
		}
		
    }
}
