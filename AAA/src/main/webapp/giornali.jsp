<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang=en-it>
<head>
<meta charset="ISO-8859-1">
<title>Elenco dei giornali</title>
</head>
<link rel="stylesheet" href="css//CssFile.css">
<body>
<h1> Elenco dei giornali</h1>

<table>
<caption>
</caption>
<tr>
<th scope="col">
titolo
</th>
<th>
tipologia
</th>
<th>
lingua
</th>
<th>
editore
</th>
<th>
data pubblicazione
</th>
<th>
copie rimanenti
</th>
<th>
disponibilita
</th>
<th>
prezzo
</th>
<th>
id
</th>
</tr>


<c:forEach items="#{bean.miaListaG }" var="lista">

<!--  
<c:choose>
<c:when test="${lista.getDisponibilita()==0 }">
<link rel="stylesheet" href="css//tableError.css">
</c:when>
<c:when test="${lista.getDisponibilita()==1 }">
<link rel="stylesheet" href="css//tableRight.css">
</c:when>
</c:choose>
-->

<tr>

<td>${lista.getTitolo() }</td>
<td>${lista.getTipologia() }</td>
<td>${lista.getLingua() }</td>
<td>${lista.getEditore() }</td>
<td>${lista.getDataPubb() }</td>
<td>${lista.getCopieRimanenti() }</td>
<td>${lista.getDisponibilita() }</td>
<td>${lista.getPrezzo() }</td>
<td>${lista.getId() }</td>
</tr>


</c:forEach>

</table>

<br>
<form action="AcquistaServlet" method="post">
<table>
<caption>
</caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<label for="idL" ></label>
</td>
<td>
<button type="submit" name="buttonI" value="buttonI">Inserire nr oggetto scelto</button>
<input type="text" name="idL" id="idL">
</td>
</tr>
</table>
</form>

<br>
<br>
<form action="AcquistaServlet" method="post">
<table>
<caption>
</caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<button type="submit" name="buttonG" value="buttonG">
genera lista
</button>
</td>
</tr>
</table>
</form>


</body>
</html>