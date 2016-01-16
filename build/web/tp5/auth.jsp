<%-- 
    Document   : auth
    Created on : Jan 4, 2016, 8:22:17 AM
    Author     : dave
--%>

<%@page import="tp.rochetvivier.modele.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification - TP 5</title>
    </head>
    <body>
        <div>
            
            <% 
                
                // on récupère les cookies existants et on regarde si celui qui nous intéresse ("session") existe
                
                Cookie cookies[] = request.getCookies();
                
                Cookie cookieSession = null;
                
                if (cookies != null) { 
                    // il y a un ou plusieurs cookies
                    
                    
                    for (Cookie c : cookies) {
                        if (c.getName().equals("session")) {
                            cookieSession = c;
                        }
                    }
                }
                if (cookieSession == null) {
                    //  notre cookie n'existe pas
                    %>
                    <h1>Authentication needed</h1>
                    <form action="../ServletTP5" method="post">
                        Username : <input type="text" name="username" />
                        <br />Password : <input type="password" name="password" />
                        <br /><input type="submit" value="Authenticate" />
                    </form>
        </div>
        <hr />
        <div>
            <br />Identifiants pour les tests :
            <ul>
                <li>username : "david.vivier" password : "dv"</li>
                <li>username : "valentin.rochet" password : "vr"</li>
            </ul>
            <br /><a href="../index.html">Retour &agrave; l'index</a>
        </div>
                    <% 
                }
                else {
                    // notre cookie existe
                    
                    User user = User.getUser(cookieSession.getValue());
                        %>
                        <h2>Welcome, <%=user.getFirstName() %>.</h2>
                        <ul>
                           <li>Username : <%=user.getUsername() %> </li>
                           <li>Password : <%=user.getPassword() %> </li>
                           <li>First name : <%=user.getFirstName() %> </li>
                           <li>Last Name : <%=user.getLastName() %> </li>
                           <li>Age : <%=user.getAge() %> </li>
                        </ul> 
                         
 
            
        </div>
        <hr>
        <div>
            <h1>TP 5</h1>
            Ce TP permet de comprendre le fonctionnement des cookies.
            <br />Nous avons tous d&eacute;j&agrave; entendu parler des cookies, nous savons maintenant exactement ce que c'est et comment on les utilise.
            <br />Pour supprimer un cookie, on peut lui attribuer une durée de vie courte  ou le supprimer manuellement en passant par les paramètres du navigateur.
            <br />
            <br />Cookie actuel
            <br />
            <% 
            // on affiche les informations du cookie
            String str = "Cookie { domain='" + cookieSession.getDomain() + "', name='" + cookieSession.getName() + "', path='" + cookieSession.getPath() + " ', value='" + cookieSession.getValue() + "'}";%>
            connect&eacute; - <%=str %> 
            
            Visualisation du cookie dans le navigateur :
            <br />
            <br /> <!-- capture d'écran montrant le cookie dans les paramètres du navigateur -->
            <img src="../ressources/cookie.png" alt="cookie \"session\" dans le navigateur">
            <br />
            <br /><a href="../index.html">Retour &agrave; l'index</a>
            <% }  %>
        </div>
    </body>
</html>
