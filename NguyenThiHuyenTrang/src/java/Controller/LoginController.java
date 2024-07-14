package Controller;

import dal.UserContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
   
    private static final long serialVersionUID = 1L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // No need to output HTML in the servlet, handle in JSP
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (Exception ex) {
            // Handle any exceptions gracefully
            request.setAttribute("error", "An error occurred: " + ex.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserContext userContext = new UserContext();
        User user = userContext.authenticateUser(username, password);
        
        if (user == null) {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return; // Stop further execution
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", true);
        session.setAttribute("role", user.getRole());
        session.setAttribute("User", user);
        
        // Redirect based on user role
        if ("lecturer".equals(user.getRole())) {
            request.getRequestDispatcher("lecturedashbroad.jsp").forward(request, response);
        } else if ("admin".equals(user.getRole())) {
            request.getRequestDispatcher("admindashbroad.jsp").forward(request, response);
        } else {
            response.sendRedirect("/NguyenThiHuyenTrang/studentcourse");
        }
    }

    @Override
    public String getServletInfo() {
        return "Login Controller Servlet";
    }
}
