import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet que simplemente muestra un mensaje
 * de ¡Hola Mundo!
 *
 */
@WebServlet("/hola")
public class HolaMundo extends HttpServlet {

    /**
     * Método del servlet que responde a una petición GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        // establece ContentType y sistema de codificación de caracteres
        response.setContentType("text/html; charset=UTF-8");

        // obtiene un PrintWriter para escribir la respuesta
        PrintWriter out = response.getWriter();

        // escribe un documento HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>¡Hola Mundo!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>¡Hola Mundo!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
