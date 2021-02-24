package org.example.crm.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author qww
 * @Date 2021-02-24 14:10
 */
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }
}
