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
            <% String str = "Cookie { domain='" + cookieSession.getDomain() + "', name='" + cookieSession.getName() + "', path='" + cookieSession.getPath() + " ', value='" + cookieSession.getValue() + "'}";%>
            connect&eacute; - <%=str %> 

            Cookie dans le navigateur :
            <br />
            <br />
            <img src="cookie.png" alt="cookie \"session\" dans le navigateur">
            <br />
            <br /><a href="../index.html">Retour &agrave; l'index</a>
            <% }  %>
        </div>
    </body>
</html>
