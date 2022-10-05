<!DOCTYPE html>
<html lang=en-it>
<head>
<meta charset="ISO-8859-1">
<title>Credenziali carta di credito</title>
<link href="cartaCredito.css" rel="stylesheet" type="text/css">

</head>
<body>

<h1>Inserire credenziali di carta credito</h1>
<form action="" method="get">
<table>
<caption></caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
nome
</td>
<td>
<label for="nomeU"></label>
<input type="text" id="nomeU">
</td>
</tr>
<tr>
<td>
cognome
</td>
<td>
<label for="cognomeU"></label>
<input type="text" id="cognomeU">
</td>
</tr>
<tr>
<td>
codice (xxxx-xxxx-xxxx-xxxx)
</td>
<td>
<label for="codiceU"></label>
<input type="text" id="codiceU">
</td>
<td>
<input type="submit" name="paga" value="procedi">
</td>
</tr>
<tr>
<td>
scadenza (yyyy-mm-dd)
</td>
<td>
<label for="scadU"></label>
<input type="text" id="scadU">
</td>
</tr>
<tr>
<td>
pin (xyz)
</td>
<td>
<label for="pinU"></label>
<input type="text" id="pinU">
</td>
</tr>
</table>
</form>


<br>
<br>
<h2> Elenco carte possedute</h2>
<table>
<caption> elenco carte :</caption>
<tr>
<th scope="col">
codice carta
</th>
</tr>
<!-- prendere codice carte da vedee -->
</table>

<br>
<table>
<caption></caption>
<tr>
<th scope="col">
</th>
</tr>
<tr>
<td>
nome utente
</td>
<td>
<input type="submit" name="prendiDatiU" value="prendi dati">
</td>
</table>

<br>
<br>
<table>
<caption></caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<input type="submit" name="pagaB" value="conferma">
</td>
</tr>
</table>

<br>
<br>
<table>
<caption></caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<a href="index.html">
<button>
indietro
</button>
</a>
</td>
</tr>
</table>





</body>
</html>