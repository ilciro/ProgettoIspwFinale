<%@ page import="bean.LibroBean" %>
<%@ page import="java.util.*" %>
<%@ page import="it.uniroma2.ispw.model.raccolta.Libro" %>
<%@ page import="it.uniroma2.ispw.database.LibroDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Ecco il riepilogo prima di acquistare</h1>

<table>
<tr>
<th>Nome</th>
<th>Costo</th>
<th>Disponibilita</th>
</tr>

<jsp:useBean id="AcquistaBean" scope="session" class="bean.AcquistaBean" /> 
        <jsp:setProperty name="AcquistaBean"  property="*" /> 
                <jsp:getProperty name="AcquistaBean" property="quantita" />
        

        <jsp:setProperty name="AcquistaBean"  property="quantita" value="4" /> 
        <jsp:getProperty name="AcquistaBean" property="quantita" />
        

<%
System.out.println("dsadx in acquista:"+request.getParameter("idL"));
LibroBean lB=new LibroBean();
Libro l=new Libro();
lB.setId(request.getParameter("idL"));
l.setId(Integer.parseInt(lB.getId()));
LibroDao lD=new LibroDao();
System.out.println("dsadx in acquista.jsp:"+(String)request.getAttribute("quantitaLabel"));


%>

<tr>
<td><%=lD.getNome(l) %></td>

<td><%=lD.getCosto(l) %></td>


<td><%=lD.getDisp(l) %></td>


</table>

<form action="AcquistaServlet" method="get">
<div>
<p>
<label for="quantita">Quantita</label>
<label for="quantitaLabel"></label>
<input type="text" name ="quantitaLabel" id="quantitaLabel"/>
</p>
<p>
<label for="totale">totaleAcquisto</label>
<label for="totaleLabel"></label>
<input type="text" id="totaleLabel"/>
</p>
<p>
<input type="submit" id="buttonTot" value="totale"/>
</p>
</div>
</form>

</body>
</html>