<!DOCTYPE html>
<html lang="it">
<head>
<title>Benvenuti nella Libreria online</title>
<meta charset="ISO-8859-1">

<link href="css//CssFile.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>  Benvenuti nella Libreria </h1>

<h2>
Inserire 0 per lista completa altrimenti id per singolo oggetto
</h2>

<br>




<form action="LibroServlet" method="post" >
<table>
<caption > TABELLA LIBRI</caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<label for="idL"></label>
<button type="submit" name="buttonI" value="buttonI">Elenco Libro totale</button>
<input type="text" name="idL" id="idL"/>
</td>
</tr>
<tr>
<td><img alt="source not found" src="immagini/libro.png_860.png" width=100  height=100 ></td>
</tr>
</table>
</form>

<br>

<form action="GiornaleServlet" method="post" >
<table>
<caption > TABELLA GIORNALI</caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<label for="idG"></label>
<button type="submit" name="buttonI" value="buttonI">Elenco Giornale totale</button>
<input type="text" name="idG" id="idG"/>
</td>
</tr>
<tr>
<td><img alt="source not found" src="immagini/newspaper-284-542534.png" width=100  height=100 ></td>
</tr>
</table>
</form>
<br>
<form action="RivistaServlet" method="post" >
<table>
<caption > TABELLA RIVISTA</caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<label for="idR"></label>
<button type="submit" name="buttonI" value="buttonI">Elenco Riviste totale</button>
<input type="text" name="idR" id="idR"/>
</td>
</tr>
<tr>
<td><img alt="source not found" src="immagini/una-rivista_318-1607.jpg" width=100  height=100 ></td>
</tr>
</table>
</form>

<br>
<form action="LoginServlet" method="post" >
<table>
<caption > TABELLA LOGIN</caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<label for="emailL">Email Utente</label>
<input type="text" name="emailL" id="emailL"/>
</td>
</tr>
<tr>
<td>
<label for="passL">Password Utente</label>
<input type="password" name="passL" id="passL"/>
</td>
</tr>
<tr>
<td>
<input type="submit" name="loginU" />
</td>
</tr>
<tr>
<td><img alt="source not found" src="immagini\vector-users-icon-png_302626.jpg" width=100  height=100 ></td>
</tr>
</table>
</form>
<br>
<br>
<form action="RivercaServlet" method="post" >
<table>
<caption > TABELLA CERCA</caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<label for="nomeC">Inserisci nome oggetto</label>
<input type="text" name="nomeC" id="nomeC"/>
</td>
</tr>
<tr>
<td>
<input type="checkbox" id="libro" name="libro" value="Libro">
<label for="libro"> LIBRO</label>
<input type="checkbox" id="giornale" name="giornale" value="Giornale">
<label for="giornale"> GIORNALE</label>
<input type="checkbox" id="rivista" name="rivista" value="Rivista">
<label for="rivista"> RIVISTA</label>
</td>
</tr>
<tr>
<td>
<input type="submit" name="cercaB" value="cerca">
</td>
</tr>
<tr>
<td><img alt="source not found" src="immagini\Search-icon-13.png" width=100  height=100 ></td>
</tr>
</table>
</form>
<br>
<form action="ModificaProfilo" method="post" >
<table>
<caption > TABELLA PROFILO</caption>
<tr>
<th scope="col"></th>
</tr>
<tr>
<td>
<input type="submit" name="profiloU" id="profiloU" value=" vai al profilo">
</td>
</tr>
<tr>
<td><img alt="source not found" src="immagini\Account-Avatar-Profile-PNG-Image.png" width=100  height=100 ></td>
</tr>
</table>
</form>




</body>
</html>