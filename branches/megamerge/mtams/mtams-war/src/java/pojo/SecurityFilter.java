/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        if (session.getAttribute("userID") == null && !pageRequested.contains("login.xhtml") && !pageRequested.contains(".css") && !pageRequested.contains(".png")) {
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
//        try {
//            String text = "bob";
//            text.getBytes("UTF8");
//            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
//    byte[] salt = new byte[12];
//    rand.nextBytes(salt);
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            
//            md.
//            
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(SecurityFilter.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    
}
