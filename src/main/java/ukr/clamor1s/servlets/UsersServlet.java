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
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<User> users = UserDao.getAll();
        req.setAttribute("users", users);

        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/users.jsp");

        rd.forward(req, res);
    }
}
