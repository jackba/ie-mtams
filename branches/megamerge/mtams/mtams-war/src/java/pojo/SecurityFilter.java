/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Badger
 */
public class SecurityFilter implements Filter {

    FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);

        String pageRequested = req.getRequestURI().toString();
        if (session.getAttribute("userID") == null && !pageRequested.contains("login.xhtml")) {
            if(pageRequested.contains("faces"))
            resp.sendRedirect("login.xhtml");
            else
                resp.sendRedirect("faces/login.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
