<%-- 
    Document   : newjsp
    Created on : Dec 14, 2015, 10:47:07 AM
    Author     : dave
--%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="tp.rochetvivier.modele.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../style/table.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affichage d'une liste d'utilisateurs</title>
    </head>
    <body>
        <h1>Liste des Utilisateurs</h1>
        
         
         <!-- Première partie : On affiche les utilisateurs dans un tableau. Celui-ci est formaté dans style.css -->
         <table>
             <tr><th>Pr&eacute;nom</th><th>Nom</th><th>&Acirc;ge</th><th>Mot de passe</th></tr>
         <%
             List<User> users = User.getListUser();
             for (User u : users) {
                 %><tr><td><%= u.getFirstName()%></td>
                     <td><%=u.getLastName()%></td>
                     <td><%=u.getAge()%></td>
                     <td><%=u.getPassword()%></td>
                 </tr>
                <%}%>
         </table>
         
         <br />
         <hr />
         
         <!-- Deuxième partie : Affichage d'un utilisateur tiré au hasard -->
         
         <% User u = User.getRandomUser();%>
         Utilisateur au hasard : 
         <ul>
             <li>Pr&eacute;nom : <%=u.getFirstName()%></li>
             <li>Nom : <%=u.getLastName()%></li>
             <li>&Acirc;ge : <%=u.getAge()%></li>
             <li>Mot de passe : <%=u.getPassword()%></li>
         </ul>
         
         <hr />
        
         <h4>TP4 :</h4>
         <br />Dans les TP 2 et 3, nous avions du HTML inclus dans du Java.
         <br />Ici c'est l'inverse : on pars&egrave;me du code Java dans une page HTML.
         <br />
         <br />Cela est un peu perturbant car sur une m&ecirc;me ligne on retrouve une alternance entre du Java et du HTML intercal&eacute;s.
         
         <br />Construire la page de cette mani&egrave;re ressemble un peu au PHP, que l'on peut inclut avec la balise &lt;?php ... ?&gt; dans du code HTML.
         
         <br />
         <br /> 
         <br /><a href="../index.html">Retour &agrave; l'index</a>
    </body>
</html>
