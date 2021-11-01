<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Jeu de carte</title>
 	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>


<div>Ordre des couleurs pour le trie :</div>
<c:forEach var="color" items="${colors}" > 
<img src="resources/img/${color}-AS.gif" />
</c:forEach>

<div>Ordre des valeurs pour le trie :</div>
<c:forEach var="value" items="${values}" > 
<img src="resources/img/${value}.gif" />
</c:forEach>
<br/>

<div>Cartes non triées dans la main du joueur :</div>
<c:forEach var="card" items="${hand}" > 
<img src="resources/img/${card}.gif" />
</c:forEach>
<br/>

<div>Cartes triées dans la main du joueur :</div>
<c:forEach var="card" items="${handOrdered}" > 
<img src="resources/img/${card}.gif" />
</c:forEach>
<br/>

<button type="button" onClick="window.location.reload();">Recommencer</button>
</body>
</html>