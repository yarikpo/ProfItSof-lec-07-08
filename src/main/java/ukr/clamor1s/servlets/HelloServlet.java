package ukr.clamor1s.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res) throws IOException {

        Cookie c = new Cookie("key", "value");
        res.addCookie(c);

        PrintWriter writer = res.getWriter();
        writer.println("Hello");
        writer.println("World");
        writer.flush();
    }

}
