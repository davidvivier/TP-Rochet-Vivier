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


    
    


    /**
     * Récupère une requête utilisant la méthode POST
     *
     * @param request la requête reçue
     * @param response la réponse qui sera renvoyée
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userNameRequested = request.getParameter("username");
        String passwordRequested = request.getParameter("password");
        
        try (PrintWriter out = response.getWriter()) {
            
                out.write("<!DOCTYPE html>" +
                            "<html>\n" +
                            "    <head>\n" +
                            "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                            "        <title>Authentication</title>\n" +
                            "    </head>\n" +
                            "    <body>");
            
                User user = User.getUser(userNameRequested);
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
                        
                        Cookie cookie = new Cookie("session", user.getUsername());
                        cookie.setMaxAge(60);
                        response.addCookie(cookie);
                        
                        out.println("<h2>Welcome, " + user.getFirstName() + ".</h2>");
                        out.println("<ul>");
                        out.println("   <li>Username : " + user.getUsername() + "</li>");
                        out.println("   <li>Password : " + user.getPassword() + "</li>");
                        out.println("   <li>First name : " + user.getFirstName() + "</li>");
                        out.println("   <li>Last Name : " + user.getLastName() + "</li>");
                        out.println("   <li>Age : " + user.getAge() + "</li>");
                        out.println("</ul>");
                        
                        out.println("<br /> Vous serez automatiquement d&eacute;connect&eacute; dans 60 secondes.");
                    }
                    else {
                        // passwords does not match
                        out.println("<h2>Authentication Failure</h2>");
                        out.println("The password isn't correct");
                    }
                    
                }
                    
                out.println("<form action=\"/TP-Rochet-Vivier/tp5/auth.jsp\" > ");
                out.println("   <input type =\"submit\" value=\"Back\">");
                out.println("</form>");
                out.println("</div>");
                out.println("</html>");
        }
    }


}
