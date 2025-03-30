package filters;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*") // Apply to all requests
public class LoggingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Logging Filter Initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        String ipAddress = request.getRemoteAddr();
        String url = req.getRequestURL().toString();
        Date requestTime = new Date();

        System.out.println("LOG: " + requestTime + " - IP: " + ipAddress + " - URL: " + url);
        
        chain.doFilter(request, response); // Pass request to next filter/servlet
    }

    public void destroy() {
        System.out.println("Logging Filter Destroyed");
    }
}
