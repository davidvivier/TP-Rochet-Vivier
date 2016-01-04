<%-- 
    Document   : auth
    Created on : Jan 4, 2016, 8:22:17 AM
    Author     : dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Authentication needed</h1>
            <% 
                
                Cookie cookie[] = request.getCookies();
                        
                if (cookie != null) { 
                    // il y a un cookie
                    
                    Cookie cookieSession = cookie[0];
                    String str = "Cookie { domain='" + cookieSession.getDomain() + "', name='" + cookieSession.getName() + "', path='" + cookieSession.getPath() + " ', value='" + cookieSession.getValue() + "'}";
                    %>
                    connect&eacute; - <%=str %>
            <%
                }
                else { 
                    // pas de cookie
                    %>
                    <form action="../ServletTP4" method="post">
                        Username : <input type="text" name="username" />
                        <br />Password : <input type="password" name="password" />
                        <br /><input type="submit" value="Authenticate" />
                    </form>
                    
            <%    } %>
            
        </div>
        <div>
            
        </div>
    </body>
</html>
