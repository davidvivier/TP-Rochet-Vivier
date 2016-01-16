<%-- 
    Document   : auth
    Created on : Jan 4, 2016, 11:33:34 AM
    Author     : dave
--%>

<%@page import="tp.rochetvivier.modele.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification - TP 6</title>
    </head>
    <body>
        <div>

            <%
                
                // on récupère les cookies existants et on regarde si celui qui nous intéresse ("session") existe
                Cookie cookies[] = request.getCookies();

                Cookie cookieSession = null;
                
                String str = "";

                if (cookies != null) {
                    // il y a un ou plusieurs cookies

                    for (Cookie c : cookies) {
                        if (c.getName().equals("session")) {
                            cookieSession = c;
                        }
                    }
                } 
            
                boolean sessionExiste = false;
                
                if (session.getAttribute("USER_VALUE") != null) {
                    sessionExiste = true;
                }
            
            
            %>
                <%
                if (cookieSession == null) {
                    //  notre cookie n'existe pas

                    if (!sessionExiste) {
                        // pas de session
                        // Cas n°1 : pas de cookie et pas de session
            %>
                        
                        <h1>Authentication needed</h1>
                        <form action="../ServletTP6" method="post">
                            Username : <input type="text" name="username" />
                            <br />Password : <input type="password" name="password" />
                            <br /><input type="submit" value="Authenticate" />
                        </form>
                        <br />Cookie n'existe pas, session n'existe pas 
                        <%
                        } else {
                            // il y a une session
                            // Cas n° 3 : pas de cookie + session

                            // affichage des infos de la session
                            User user = (User) session.getAttribute("USER_VALUE");
                            if (user != null)
                                str = "Session  { id=" + session.getId() + ", user = " + user.toString() + "}";
                            
                        %> 
                        <br />Cookie n'existe pas, session existe
                        <br /> <%=str %>
                    <%    }
                } else {// notre cookie existe
                    if (!sessionExiste) {

                    // Pas de session
                    // Cas n°2 : cookie et pas de session
                    User user = User.getUser(cookieSession.getValue());
                %>
                <h2>Welcome, <%=user.getFirstName()%>.</h2>
                <ul>
                    <li>Username : <%=user.getUsername()%> </li>
                    <li>Password : <%=user.getPassword()%> </li>
                    <li>First name : <%=user.getFirstName()%> </li>
                    <li>Last Name : <%=user.getLastName()%> </li>
                    <li>Age : <%=user.getAge()%> </li>
                </ul> 
                <br />
                 
                <%  str = "Cookie { domain='" + cookieSession.getDomain() + "', name='" + cookieSession.getName() + "', path='" + cookieSession.getPath() + " ', value='" + cookieSession.getValue() + "'}";
                %>  Cookie existe, session n'existe pas
                    <br /><%=str %> 
                <%  } else {
                    // La session existe
                    // Cas n°4 : cookies et session

                    // affichage des infos du cookie
                    str = "Cookie { domain='" + cookieSession.getDomain() + "', name='" + cookieSession.getName() + "', path='" + cookieSession.getPath() + " ', value='" + cookieSession.getValue() + "'}";
                    %><br /> Cookie et session existent
                      <br /><%=str %> 
                    <%
                    // affichage des infos de la session
                    User user = (User) session.getAttribute("USER_VALUE");
                    str = "Session  { id=" + session.getId() + " user : " + user.toString() + "}";
                    %> <br /> <%=str %> 
                <% }  %>
            <% }%>


        </div>
                    
        <hr>
        <div>
            <div>
                <br />Identifiants pour les tests :
                <ul>
                    <li>username : "david.vivier" password : "dv"</li>
                    <li>username : "valentin.rochet" password : "vr"</li>
                </ul>
            </div>
            <h2>TP 6</h2>
            Ce TP est utile pour comprendre comment fonctionnent les sessions, (les cookies sont déjà vus au TP 5), et la différence entre cookie et session.
            <br />
            <br />La distinction des 4 cas (cookie existant ou non / session existant ou non) permet de mieux saisir la différence.
            <br />Il faut aussi garder à l'esprit que c'est le cookie JSESSIONID qui fait le lien entre la session de la servlet et la machine de l'utilisateur.
            <br />
            
            <br /><a href="../index.html">Retour &agrave; l'index</a>
            
        </div>
    </body>
</html>

