package ukr.clamor1s.filters;

import ukr.clamor1s.User;
import ukr.clamor1s.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (((HttpServletRequest)req).getSession().getAttribute("error") == null) {
            ((HttpServletRequest)req).getSession().setAttribute("error", "");
        }

        User user = (User) ((HttpServletRequest)req).getSession().getAttribute("user");
        // if authorized, than not allowed to go further
        if (user == null || !user.getPassword().equals(UserDao.getByLogin(user.getLogin()).getPassword())) {
            chain.doFilter(req, res);
            return;
        }
        ((HttpServletResponse)res).sendRedirect("/ProfItSoft-lec-07-08/home");
    }

    @Override
    public void destroy() {}
}
