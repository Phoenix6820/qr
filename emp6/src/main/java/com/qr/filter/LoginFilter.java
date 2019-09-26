package com.qr.filter;

import com.qr.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/emp","/dep","/ddd"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session=((HttpServletRequest)servletRequest).getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            (  (HttpServletResponse)servletResponse).sendRedirect("user");
        }else
        {
            filterChain.doFilter(servletRequest,servletResponse);

        }
    }
}
