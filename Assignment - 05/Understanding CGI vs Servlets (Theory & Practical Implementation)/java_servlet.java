import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet('/hello')
public class javaServlet extends HttpServlet(){
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType('html/text')
        PrintWriter out = response.getWriter()

        String name = "Anando"
        String html = String.format(""" 
        <html>
        <head> <title> Java Servlet </title> </head>
        <body> Hello, %s Welcome to the Java Servlet </body>
        </html>
        """, name)
        out.println(html)
    }
}