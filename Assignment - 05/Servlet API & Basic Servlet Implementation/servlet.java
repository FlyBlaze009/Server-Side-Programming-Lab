import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class WelcomeServlet extends HttpServlet {

    // Handling GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to HTML
        response.setContentType("text/html");

        // Get the PrintWriter to write the response
        PrintWriter out = response.getWriter();

        // Write the HTTP response (welcome message)
        out.println("<html><body>");
        out.println("<h2>Welcome to the Java Servlet!</h2>");

        // Retrieving query parameters from the URL
        String name = request.getParameter("name");
        if (name != null) {
            out.println("<p>Hello, " + name + "!</p>");
        } else {
            out.println("<p>Hello, Guest!</p>");
        }

        // Display client request details
        String clientIP = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        out.println("<h3>Client Details:</h3>");
        out.println("<p>IP Address: " + clientIP + "</p>");
        out.println("<p>User-Agent: " + userAgent + "</p>");

        out.println("</body></html>");
    }

    // Handling POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to HTML
        response.setContentType("text/html");

        // Get the PrintWriter to write the response
        PrintWriter out = response.getWriter();

        // Get parameters from POST request
        String name = request.getParameter("name");
        if (name != null) {
            out.println("<html><body>");
            out.println("<h2>Welcome, " + name + "!</h2>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Please provide a name in the POST request.</h2>");
            out.println("</body></html>");
        }
    }

    @Override
    public void init() throws ServletException {
        // This method will be called when the servlet is first loaded
        System.out.println("WelcomeServlet has been initialized.");
    }

    @Override
    public void destroy() {
        // This method is called when the servlet is destroyed
        System.out.println("WelcomeServlet is being destroyed.");
    }
}
