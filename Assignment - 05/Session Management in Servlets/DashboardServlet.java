import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve username from cookies
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        // Retrieve session ID from URL
        String sessionId = request.getParameter("sessionId");

        // Retrieve session and preferences
        HttpSession session = request.getSession();
        String theme = (String) session.getAttribute("theme");
        String language = (String) session.getAttribute("language");

        out.println("<html><body>");
        out.println("<h2>Welcome, " + (username != null ? username : "Guest") + "!</h2>");
        out.println("<p>Session ID (via URL Rewriting): " + sessionId + "</p>");

        // Display user preferences
        out.println("<h3>Preferences</h3>");
        out.println("<p>Theme: " + (theme != null ? theme : "Default") + "</p>");
        out.println("<p>Language: " + (language != null ? language : "English") + "</p>");

        // Provide option to update preferences
        out.println("<form action='PreferenceServlet' method='post'>");
        out.println("Select Theme: <select name='theme'>");
        out.println("<option value='Light'>Light</option>");
        out.println("<option value='Dark'>Dark</option>");
        out.println("</select><br>");

        out.println("Select Language: <select name='language'>");
        out.println("<option value='English'>English</option>");
        out.println("<option value='Spanish'>Spanish</option>");
        out.println("</select><br>");

        out.println("<input type='submit' value='Save Preferences'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}
