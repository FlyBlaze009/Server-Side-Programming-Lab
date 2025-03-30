import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded credentials (can be replaced with DB validation)
        if ("admin".equals(username) && "password".equals(password)) {
            // Forward to WelcomeServlet
            RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
            dispatcher.forward(request, response);
        } else {
            // Redirect back to login page with error message
            response.sendRedirect("index.html?error=1");
        }
    }
}
