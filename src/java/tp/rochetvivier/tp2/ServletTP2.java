/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.rochetvivier.tp2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Servlet dédiée au TP n°2
 * 
 * @author dave
 */
@WebServlet(name = "ServletTP2", urlPatterns = {"/ServletTP2"})
public class ServletTP2 extends HttpServlet {

    /**
     * 
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
            out.println("<title>TP 2 </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>TP 2</h1>");
            out.println("<h3>Liste des param&egrave;tres pass&eacute;s en m&eacute;thode GET</h3>");
            out.println("<ul>");
            Map<String, String[]> parameters = request.getParameterMap();
            
            for (Map.Entry<String, String[]> param : parameters.entrySet()){
                out.print("<li>");
                out.print(param.getKey() + " = {");
                int nbParam = param.getValue().length;
                for (int i = 0; i < nbParam - 1; i++) {
                    out.print(param.getValue()[i] + ",");
                }
                out.print(param.getValue()[nbParam-1]);
                out.println("} </li>");
            }
            out.print("</ul>");
            
            out.println("<hr />");
            out.println("<h2>Informations contextuelles</h2>");
            out.print("<br />");
            out.println("Remote IP : " + request.getRemoteAddr() + "  --  l'adresse ip depuis laquelle le client acc&egrave;de &agrave; la servlet <br />");
            out.println("Local Port : " + request.getLocalPort() + "  -- le port auquel le client se connecte<br />");
            out.println("Context Path : " + request.getContextPath() + " -- Le chemin de travail de la servlet <br />");
            out.println("Protocol : " + request.getProtocol() + "  -- le protocole utilis&eacute; pour la requ&ecirc;te effectu&eacute;e par le client<br />"); 
            out.println("Current URI : " + request.getRequestURL() + "  -- l'URL utilis&eacute;e pour acc&eacute;der &agrave; la page courante, sans les param&egrave;tres GET<br />");
            out.print("<br />");
            
            out.println("<hr />");
            
            out.print("<br />");
            out.println("<h4>TP2 :</h4>");
            out.println("Le TP 2 concerne uniquement la m&eacute;thode GET, il n'utilise pas de requ&ecirc;te POST.");
            out.println("<br />Par cons&eacute;quent on peut retirer la m&eacute;thode doPost() pr&eacute;sente par d&eacute;faut dans la classe Servlet.");
            out.println("<br />");
            out.println("<br />Pour passer plusieurs valeurs pour un m&ecirc;me param&egrave;tre d'une m&eacute;thode GET, il y a deux solutions:");
            out.println("<ul>");
            out.println("   <li>Les s&eacute;parer par une virgule (param2) </li>");
            out.println("   <li>Renseigner plusieurs fois le m&ecirc;me param&egrave;tre (param3) ");
            out.println("</ul>");
            out.print("<br />");
            out.print("<br /><a href=\"index.html\">Retour &agrave; l'index</a>");
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
        processRequest(request, response);
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
