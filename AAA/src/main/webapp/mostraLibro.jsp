<%@ page import="bean.LibroBean" %>
<%@ page import="java.util.*" %>
<%@ page import="it.uniroma2.ispw.model.raccolta.Libro" %>
<%@ page import="it.uniroma2.ispw.database.LibroDao" %>

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
<th>Titolo</th>
<th>Numero pagine</th>
<th>Codice Isbn</th>
<th>Editore</th>
<th>Autore</th>
<th>Lingua</th>
<th>Categoria</th>
<th>DataPubblicazione</th>
<th>Recensione</th>
<th>CopieVendute</th>
<th>Descrizione</th>
<th>Disponibilita</th>
<th>Prezzo</th>
<th>Copie Rimanenti</th>
<th>idProdotto</th>
</tr>
<%
LibroBean lB=new LibroBean();
LibroDao lD=new LibroDao();
Libro libro=new Libro();
lB.setId(request.getParameter("idL"));
libro.setId(Integer.parseInt(lB.getId()));
lB.setMiaLista(lD.getLibriSingoloByIdLista(libro));

List<Libro> l=new ArrayList<Libro>();
l.addAll(lB.getMiaLista());
Iterator<Libro> it=null;

it=l.iterator();
int i=0;
while (it.hasNext() && i<l.size()) {
%>
<tr>
<td><%=l.get(i).getTitolo()%></td>
<td><%=l.get(i).getNumeroPagine()%></td>
<td><%=l.get(i).getCodIsbn()%></td>
<td><%=l.get(i).getEditore()%></td>
<td><%=l.get(i).getAutore() %></td>
<td><%=l.get(i).getLingua()%></td>
<td><%=l.get(i).getCategoria() %></td>
<td><%=l.get(i).getDataPubb() %></td>
<td><%=l.get(i).getRecensione() %></td>
<td><%=l.get(i).getNrCopie() %></td>
<td><%=l.get(i).getDesc() %></td>
<td><%=l.get(i).getDisponibilita() %></td>
<td><%=l.get(i).getPrezzo() %></td>
<td><%=l.get(i).getNrCopie() %></td>
<td><%=l.get(i).getId() %></td>
</tr>

<%	
i++;
}
%>

</table>


<form action="LibroServlet" method="post">
<div>
<p>
<label for="mostraL">Acquista Libro n</label>
<label for="idL" ></label>
<input type=text name="idL" id="idL">
<button type="submit" name="buttonI" value="buttonI">Invia</button>
</p>
</div>
</form>
<p>
<a href="libri.html">torna indietro</a>
</p>
</body>
</html>