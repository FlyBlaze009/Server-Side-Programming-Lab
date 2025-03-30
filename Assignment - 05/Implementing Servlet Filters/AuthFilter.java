package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/WelcomeServlet") // Protects WelcomeServlet
public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Authentication Filter Initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            // User is logged in, proceed
            chain.doFilter(request, response);
        } else {
            // User is not logged in, redirect to login page
            res.sendRedirect("index.html?error=not_logged_in");
        }
    }

    public void destroy() {
        System.out.println("Authentication Filter Destroyed");
    }
}
