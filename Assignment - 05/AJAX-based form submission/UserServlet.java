import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet("/ajax-login")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        JSONObject jsonResponse = new JSONObject();
        if (userDAO.validateUser(username, password)) {
            jsonResponse.put("status", "success");
            jsonResponse.put("message", "Login successful");
        } else {
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "Invalid credentials");
        }

        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());
    }
}
