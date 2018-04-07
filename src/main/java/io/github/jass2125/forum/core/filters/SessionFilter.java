/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.filters;

import io.github.jass2125.forum.core.entity.UserPrincipal;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Mar 19, 2018 9:49:26 PM
 */
@WebFilter(filterName = "sessionFilter", urlPatterns = "/user/*")
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = ((HttpServletRequest) request);
        HttpSession session = req.getSession();
        HttpServletResponse resp = ((HttpServletResponse) response);
        String contextPath = req.getContextPath();
        UserPrincipal user = (UserPrincipal) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect(contextPath + "/signin.xhtml");
            chain.doFilter(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
