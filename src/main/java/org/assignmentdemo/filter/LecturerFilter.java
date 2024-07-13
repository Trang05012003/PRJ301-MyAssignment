package org.assignmentdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "LecturerFilter", urlPatterns = {"/lecturer/*"})
public class LecturerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        if (session != null && session.getAttribute("role") != null) {
            String role = session.getAttribute("role").toString();
            if ("lecturer".equals(role) || "admin".equals(role)) {
                chain.doFilter(request, response);
                return;
            }
        }

        httpResponse.sendRedirect("/view/access-denied.jsp");
    }
}
