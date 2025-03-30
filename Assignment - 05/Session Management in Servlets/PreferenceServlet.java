import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/PreferenceServlet")
public class PreferenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Store user preferences in session
        String theme = request.getParameter("theme");
        String language = request.getParameter("language");

        session.setAttribute("theme", theme);
        session.setAttribute("language", language);

        // Redirect back to Dashboard
        response.sendRedirect("DashboardServlet?sessionId=" + session.getId());
    }
}
