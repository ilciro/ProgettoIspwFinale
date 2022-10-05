<%@ page import="bean.LibroBean" %>
<%@ page import="java.util.*" %>
<%@ page import="it.uniroma2.ispw.model.raccolta.Libro" %>
<%@ page import="it.uniroma2.ispw.database.LibroDao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Riepilogo Libro</title>
<link href="CssFile.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Ecco il riepilogo del libro scelto</h1>

<table>
<caption>Riepilogo libro</caption>
<tr>
<th>
Titolo
</th>
<th>
Numero pagine
</th>
<th>
Codice Isbn
</th>
<th>
Editore
</th>
<th>
Autore
</th>
<th>
Lingua
</th>
<th>
Categoria
</th>
<th>
DataPubblicazione
</th>
<th>
Recensione
</th>
<th>
CopieVendute
</th>
<th>
Descrizione
</th>
<th>
Disponibilita
</th>
<th>
Prezzo
</th>
<th>
Copie Rimanenti
</th>
<th>
idProdotto
</th>
</tr>

<c:forEach items="#{bean.miaLista}" var="lista">

<tr>
<td>${ lista.getTitolo() }</td>
<td>${ lista.getNumeroPagine() }</td>
<td>${ lista.getCodIsbn() }</td>
<td>${ lista.getEditore() }</td>
<td>${ lista.getAutore() }</td>
<td>${ lista.getLingua() }</td>
<td>${ lista.getCategoria()}</td>
<td>${ lista.getDataPubb()}</td>
<td>${ lista.getRecensione() }</td>
<td>${ lista.getNrCopie() }</td>
<td>${ lista.getDesc() }</td>
<td>${ lista.getDisponibilita() }</td>
<td>${ lista.getPrezzo() }</td>
<td>${ lista.getNrCopie() }</td>
<td>${ lista.getId()}</td>
</tr>
</c:forEach>

</table>




</body>
</html>