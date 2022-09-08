
<%@ page import="bean.LibroBean" %>
<%@ page import="java.util.*" %>
<%@ page import="it.uniroma2.ispw.model.raccolta.Libro" %>
<%@ page import="it.uniroma2.ispw.database.LibroDao" %>



   

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>

<html lang=en>
<head>
<!-- Copyright 2013 SonarSource SA -->
<link rel="stylesheet" href="CssFile.css">

<meta charset="ISO-8859-1">
<title>Pagina libri</title>
<link rel="" />
</head>
<body>


<!--  
<jsp:useBean id="LibroBean" class="bean.LibroBean" />
<jsp:getProperty name="LibroBean" property="miaLista" />

-->




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
System.out.println("dsadx in libri.jsp:"+request.getParameter("idL"));//stampa nr digitato
lB.setMiaLista(lD.getLibriSingoloList());

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
<form action="AcquistaServlet" method="post">
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
<a href="index.html" >indietro</a>
</p>

</body>
</html>