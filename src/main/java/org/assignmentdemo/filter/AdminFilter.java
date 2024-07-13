package org.assignmentdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getRequestURI();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        if (path.equals("/admin/dashboard/students") && session.getAttribute("role") != null && session.getAttribute("role").equals("lecturer")) {
            chain.doFilter(request, response);
        }

        if (session != null && session.getAttribute("role") != null && session.getAttribute("role").equals("admin")) {
            chain.doFilter(request, response);
        }

        httpResponse.sendRedirect("/view/access-denied.jsp");
    }
}
