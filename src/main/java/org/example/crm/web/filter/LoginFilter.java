package org.example.crm.web.filter;

import org.example.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author qww
 * @Date 2021-02-24 14:53
 */
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getServletPath();

        if ("/settings/user/login.do".equals(path) || "/login.jsp".equals(path)) {
            chain.doFilter(request, response);
        }else {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                chain.doFilter(request, response);
            }else {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }
        }

    }
}
