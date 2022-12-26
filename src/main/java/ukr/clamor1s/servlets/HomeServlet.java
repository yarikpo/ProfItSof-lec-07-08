package ukr.clamor1s.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res) throws IOException, ServletException {

        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/home.jsp");

        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        res.setStatus(202);
        res.sendRedirect("/ProfItSoft-lec-07-08/login");
    }
}
