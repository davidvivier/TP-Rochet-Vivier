<%-- 
    Document   : enregistrer
    Created on : 11 janv. 2016, 09:11:26
    Author     : Valentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        
        <!-- On n'instancie pas la bean ici, mais dans "lire.jsp" -->
    </head>
    <body>
        <h1>Registration</h1>
        <form action="lire.jsp" method="post">
            <!-- On crée un formulaire qu'on envoie à "lire.jsp" -->
            <label for="name">Name : </label><input type="text" name="name" />
            <br /><label for="surname">Surname : </label><input type="text" name="surname" />
            <br /><input type="submit" value="Register" />
        </form>
    </body>
</html>
