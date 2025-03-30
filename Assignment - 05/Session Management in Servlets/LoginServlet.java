import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        if (username == null || username.trim().isEmpty()) {
            out.println("<h3>Please enter a valid username.</h3>");
            return;
        }

        // Store username in a cookie
        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60 * 60); // Cookie expires in 1 hour
        response.addCookie(userCookie);

        // Redirect to DashboardServlet with URL Rewriting (session ID in URL)
        response.sendRedirect("DashboardServlet?sessionId=" + request.getSession().getId());
    }
}
