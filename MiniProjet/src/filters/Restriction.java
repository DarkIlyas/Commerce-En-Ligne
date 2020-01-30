package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Restriction implements Filter {
    private static final String ATT_SESSION_USER = "userSession";
    private static final String VUE_PUBLIC = "/acces_public.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();

        if(session.getAttribute(ATT_SESSION_USER) == null){
            resp.sendRedirect(req.getContextPath()+VUE_PUBLIC);
        } else {
            filterChain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
