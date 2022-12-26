package ukr.clamor1s.filters;

import ukr.clamor1s.User;
import ukr.clamor1s.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/home")
public class HomeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        User user = (User) ((HttpServletRequest)req).getSession().getAttribute("user");

        if (user == null || !user.getPassword().equals(UserDao.getByLogin(user.getLogin()).getPassword())) {
            ((HttpServletResponse)res).sendRedirect("/ProfItSoft-lec-07-08/login");
            return;
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {}
}
