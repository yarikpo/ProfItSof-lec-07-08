package ukr.clamor1s.servlets;

import ukr.clamor1s.User;
import ukr.clamor1s.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res) throws IOException, ServletException {

        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/loginForm.jsp");

        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse res) throws IOException, ServletException {

        System.out.println(req.getParameter("login"));
        User user = UserDao.getByLogin(req.getParameter("login"));
        System.out.println(user);
        if (user == null || !user.getPassword().equals(req.getParameter("password"))) {
            System.out.println("user is incorrect");
            res.setStatus(401);
            res.sendRedirect("/ProfItSoft-lec-07-08/login");
            return;
        }

        System.out.println("OK");

        req.getSession().setAttribute("user", user);
        res.setStatus(202);
        res.sendRedirect("/ProfItSoft-lec-07-08/home");

    }



}
