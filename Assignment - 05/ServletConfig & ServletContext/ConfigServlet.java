import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigServlet extends HttpServlet {

    private String dbURL;
    private String dbUser;
    private String dbPassword;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Always call super.init(config) when overriding init()!

        // Reading init parameters from web.xml
        dbURL = config.getInitParameter("dbURL");
        dbUser = config.getInitParameter("dbUser");
        dbPassword = config.getInitParameter("dbPassword");

        // Storing database connection settings in ServletContext
        ServletContext context = getServletContext();
        context.setAttribute("dbURL", dbURL);
        context.setAttribute("dbUser", dbUser);
        context.setAttribute("dbPassword", dbPassword);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Database Configuration Read from ServletConfig</h2>");
        out.println("<p>DB URL: " + dbURL + "</p>");
        out.println("<p>DB User: " + dbUser + "</p>");
        out.println("<p>DB Password: " + dbPassword + "</p>");
        out.println("<p><a href='ContextServlet'>Check Application-Wide Data</a></p>");
        out.println("</body></html>");
    }
}
