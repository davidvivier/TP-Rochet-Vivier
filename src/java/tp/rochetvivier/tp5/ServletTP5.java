/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.rochetvivier.tp5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tp.rochetvivier.modele.User;

/**
 *
 * @author dave
 */
@WebServlet(name = "ServletTP5", urlPatterns = {"/ServletTP5"})
public class ServletTP5 extends HttpServlet {

    private HashMap<String, User> m_users;
    
    public ServletTP5() {
        
        m_users = new HashMap<>();
        User user = new User("david.vivier", "dv", "David", "Vivier", 20);
        m_users.put(user.getUsername(), user);
        user = new User("valentin.rochet", "vr", "Valentin", "Rochet", 18);
        m_users.put(user.getUsername(), user);
        
    }

    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletTP5</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletTP5 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String userNameRequested = request.getParameter("username");
        String passwordRequested = request.getParameter("password");
        
        try (PrintWriter out = response.getWriter()) {
        
                User user = m_users.get(userNameRequested);
                if (userNameRequested.equals("")) {
                    out.write("<h2>Authentication Failure</h2>");
                    out.write("Please provide a username and password to login.");
                    out.write("");
                }else if (user == null) {
                    out.write("<h2>Authentication Failure</h2>");
                    out.write("username '" + userNameRequested + "' does not exist");
                }
                else {
                    // the user exists
                    if (user.getPassword().equals(passwordRequested)) {
                        // passwords does match
                        
                        Cookie cokkie[] = request.getCookies();
                        
                        if (cokkie == null) { 
                            // il n'y avait pas de cookie
                            Cookie cookieSession = new Cookie("session", user.getUsername());
                            response.addCookie(cookieSession);
                        }
                        else {
                            Cookie cookieSession = cokkie[0];
                            out.println("Cookie { domain='" + cookieSession.getDomain() + "', name='" + cookieSession.getName() + "', path='" + cookieSession.getPath() + " ', value='" + cookieSession.getValue() + "'}");
                        }
                        out.println("<h2>Welcome back, " + user.getFirstName() + ".</h2>");
                        out.println("<ul>");
                        out.println("   <li>Username : " + user.getUsername() + "</li>");
                        out.println("   <li>Password : " + user.getPassword() + "</li>");
                        out.println("   <li>First name : " + user.getFirstName() + "</li>");
                        out.println("   <li>Last Name : " + user.getLastName() + "</li>");
                        out.println("   <li>Age : " + user.getAge() + "</li>");
                        out.println("</ul>");
                        
                    }
                    else {
                        // passwords does not match
                        out.println("<h2>Authentication Failure</h2>");
                        out.println("The password isn't correct");
                    }
                    
                }
                    
                out.println("<form action=\"/TP-Rochet-Vivier/tp5/auth.html\" > ");
                out.println("   <input type =\"submit\" value=\"Back\">");
                out.println("</form>");
                out.println("</div>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
