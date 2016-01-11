<%-- 
    Document   : lire
    Created on : 11 janv. 2016, 09:20:40
    Author     : Valentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lecture Bean</title>
        
        <!-- On instancie notre bean -->
        <jsp:useBean id="myUser" scope="session" class="tp.rochetvivier.modele.UserBean">
            <!-- On initialise la bean -->
            <jsp:setProperty name="myUser" property="name" value="none" />
            <jsp:setProperty name="myUser" property="surname" value="none" />
            <jsp:setProperty name="myUser" property="age" value="0" />
            <jsp:setProperty name="myUser" property="preference" value="EVERYTHING IS GOOD" />
        </jsp:useBean>
        
        <!-- On met à jour les valeurs de la bean en fonction des valeurs retournées du formulaire -->
        <jsp:setProperty name="myUser" property="name" />
        <jsp:setProperty name="myUser" property="surname" />
        
        
     </head>
    <body>
        <h1>Lecture de la bean</h1> <br/>
        
        <!-- On affiche les différentes valeurs de la bean -->
        Current name : <jsp:getProperty name="myUser" property="name" /><br/>
        Current surname : <jsp:getProperty name="myUser" property="surname" /><br/>
        Current age : <jsp:getProperty name="myUser" property="age" /><br/>
        Current preference : <jsp:getProperty name="myUser" property="preference" /><br/>
        
        <br/><a href="enregistrer.jsp">Retour</a>
        
        <br/><br/>
        <hr />
        <div>
            Erreur rencontrée : nous avions d'abord instancié la bean dans "register.jsp",
            en pensant que la page "lire.jsp" pourrait récupérer la bean. Cela ne marche pas.
            <br/><br/>
            Remarque : si le formulaire est vide, les valeurs affichées pour "name" et "surname" sont les dernières
            valeurs rentrées de la session, et non valeur nulle.
        </div>
    </body>
</html>
