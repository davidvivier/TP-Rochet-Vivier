/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.rochetvivier.tp3;

import tp.rochetvivier.modele.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet dédiée au TP 3
 * 
 * @author dave
 */
@WebServlet(name = "ServletTP3", urlPatterns = {"/ServletTP3"})
public class ServletTP3 extends HttpServlet {
    
    private HashMap<String, User> m_users;
    
    
    public ServletTP3() {
        
        m_users = new HashMap<>();
        User user = new User("david.vivier", "dv", "David", "Vivier", 20);
        m_users.put(user.getUsername(), user);
        user = new User("valentin.rochet", "vr", "Valentin", "Rochet", 18);
        m_users.put(user.getUsername(), user);
        
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
        
            String userNameRequested = request.getParameter("username");
            String passwordRequested = request.getParameter("password");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                // on affiche la partie html commune à tous les cas
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>TP 3</title>");            
                out.println("</head>")
                        ;
                out.println("<body>");
                out.println("<div>");
                
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
                    
                out.println("<form action=\"/TP-Rochet-Vivier/tp3/auth.html\" > ");
                out.println("   <input type =\"submit\" value=\"Back\">");
                out.println("</form>");
                out.println("</div>");
                
                out.println("<hr />");
                out.println("<div>");
                out.println("<h4>TP3 :</h4>");
                out.println("Pour cet exercice, il faut passer le nom d'utilisateur et le mot de passe dans une requ&ecirc;te.");
                out.println("<br />Nous avons choisi la m&eacute;thode POST, car elle permet que le mot de passe ne soit pas visible en clair.");
                out.println("<br />  Bien s&ucirc;r, le mot de passe n'est pas prot&eacute;g&eacute; pour autant; cela est simplement une pr&eacute;caution pour &eacute;viter que quelqu'un ne puisse voir le mot de passe directement.");
                out.println("<br />  En toute rigueur, il faudrait chiffrer le mot de passe avant le transfert.");
                out.println("<br />");
                out.println("<br />De plus, l'affichage de cette page passe n&eacute;cessairement par la m&eacute;ode POST : la m&eacute;thode processRequest devient inutile.");
                out.println("<br />");
                out.println("<br />En cons&eacute;quence, on retire les m&eacute;thodes doGet et processRequest de la classe Servlet car elles sont inutiles &agrave; ce TP.");
                out.println("<br />");
                out.println("<br />Bien &eacute;videmment, les mots de passe affich&eacute;s en dessous du formulaire d'authentification sont &eacute;crits dans un but de test uniquement." );
                
                out.println("<br />");
                out.print("<br /><a href=\"/TP-Rochet-Vivier\">Retour &agrave; l'index</a>");
                out.println("</div>");
                
                out.println("</body>");
                out.println("</html>");
                
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
