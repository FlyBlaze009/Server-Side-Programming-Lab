import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "password".equals(password)) {
            // Create session and store user info
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.html?error=invalid_credentials");
        }
    }
}
