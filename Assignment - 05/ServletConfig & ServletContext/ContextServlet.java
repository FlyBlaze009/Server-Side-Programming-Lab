import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving application-wide data from ServletContext
        ServletContext context = getServletContext();
        String dbURL = (String) context.getAttribute("dbURL");
        String dbUser = (String) context.getAttribute("dbUser");
        String dbPassword = (String) context.getAttribute("dbPassword");

        out.println("<html><body>");
        out.println("<h2>Application-Wide Database Configuration from ServletContext</h2>");
        out.println("<p>DB URL: " + dbURL + "</p>");
        out.println("<p>DB User: " + dbUser + "</p>");
        out.println("<p>DB Password: " + dbPassword + "</p>");
        out.println("</body></html>");
    }
}
