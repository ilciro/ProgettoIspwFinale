package bean;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import it.uniroma2.ispw.model.Log;
import it.uniroma2.ispw.model.raccolta.CategorieLibro;
import it.uniroma2.ispw.model.raccolta.Libro;
import it.uniroma2.ispw.model.raccolta.Raccolta;
import it.uniroma2.ispw.utilities.ConnToDb;

public class LibroBean implements Raccolta {
	private String titolo;
	private String codIsbn;
	private String editore;
	private String autore;
	private String lingua;
	private String categoria;
	private LocalDate dataPubb;
	private String recensione;
	private int nrCopie; // numero copie vendute
	private String desc;
	private int disponibilita;
	private float prezzo;
	private int copieRim;
	private String[] infoGenerali=new String[6];
	private String[] infoCostiDisp=new String[6];
	private int numeroPagine;
	private String tipologia;
	private String id;
	private String url="C:\\libriScaricati";
	private List<Libro> miaLista;
	private String listaCategorie;
	private java.sql.Date date;
	Statement stmt=null;
	public List<Libro> getMiaLista() {
		return miaLista;
	}
	public void setMiaLista(List<Libro> miaLista) {
		this.miaLista = miaLista;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getCodIsbn() {
		return codIsbn;
	}
	public void setCodIsbn(String codIsbn) {
		this.codIsbn = codIsbn;
	}
	public String getEditore() {
		return editore;
	}
	public void setEditore(String editore) {
		this.editore = editore;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getLingua() {
		return lingua;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		switch (categoria){
		case "ADOLESCENTI_RAGAZZI": 
			this.categoria = CategorieLibro.ADOLESCENTI_RAGAZZI.toString();  
			break;
		case "ARTE": 
			this.categoria = CategorieLibro.ARTE.toString();  
			break;
		case "CINEMA_FOTOGRAFIA" : 
			this.categoria = CategorieLibro.CINEMA_FOTOGRAFIA.toString();  
			break;
		case "BIOGRAFIE" : 
			this.categoria = CategorieLibro.BIOGRAFIE.toString();  
			break;
		case "DIARI_MEMORIE" : 
			this.categoria = CategorieLibro.DIARI_MEMORIE.toString();  
			break;
		case "CALENDARI_AGENDE" : 
			this.categoria = CategorieLibro.CALENDARI_AGENDE.toString();  
			break;
		case "DIRITTO" : 
			this.categoria = CategorieLibro.DIRITTO.toString();  
			break;
		case "DIZINARI_OPERE" : 
			this.categoria = CategorieLibro.DIZINARI_OPERE.toString();  
			break;
		case "ECONOMIA" : 
			this.categoria = CategorieLibro.ECONOMIA.toString();  
			break;
		case "FAMIGLIA" : 
			this.categoria = CategorieLibro.FAMIGLIA.toString();  
			break;
		case "SALUTE_BENESSERE" : 
			this.categoria = CategorieLibro.SALUTE_BENESSERE.toString();  
			break;
		case "FANTASCIENZA_FANTASY" : 
			this.categoria = CategorieLibro.FANTASCIENZA_FANTASY.toString();  
			break;
		case "FUMETTI_MANGA" : 
			this.categoria = CategorieLibro.FUMETTI_MANGA.toString();  
			break;
		case "GIALLI_THRILLER" : 
			this.categoria = CategorieLibro.GIALLI_THRILLER.toString();  
			break;		
		case "COMPUTER_GIOCHI" : 
			this.categoria = CategorieLibro.COMPUTER_GIOCHI.toString();  
			break;
		case "HUMOR" : 
			this.categoria = CategorieLibro.HUMOR.toString();  
			break;
		case "INFORMATICA" : 
			this.categoria = CategorieLibro.INFORMATICA.toString();  
			break;		
		case "WEB_DIGITAL_MEDIA" : 
			this.categoria = CategorieLibro.WEB_DIGITAL_MEDIA.toString();  
			break;		
		case "LETTERATURA_NARRATIVA" : 
			this.categoria = CategorieLibro.LETTERATURA_NARRATIVA.toString();  
			break;		
		case "LIBRI_BAMBINI" : 
			this.categoria = CategorieLibro.LIBRI_BAMBINI.toString();  
			break;		
		case "LIBRI_SCOLASTICI" : 
			this.categoria = CategorieLibro.LIBRI_SCOLASTICI.toString();  
			break;
		case "LIBRI_UNIVERSITARI" : 
			this.categoria = CategorieLibro.LIBRI_UNIVERSITARI.toString();  
			break;			
		case "RICETTARI_GENERALI" : 
			this.categoria = CategorieLibro.RICETTARI_GENERALI.toString();  
			break;	
		case "LINGUISTICA_SCRITTURA" : 
			this.categoria = CategorieLibro.LINGUISTICA_SCRITTURA.toString();  
			break;
		case "POLITICA" : 
			this.categoria = CategorieLibro.POLITICA.toString();  
			break;
		case "RELIGIONE" : 
			this.categoria = CategorieLibro.RELIGIONE.toString();  
			break;
		case "ROMANZI_ROSA" : 
			this.categoria = CategorieLibro.ROMANZI_ROSA.toString();  
			break;		
		case "SCIENZE" : 
			this.categoria = CategorieLibro.SCIENZE.toString();  
			break;		
		case "TECNOLOGIA_MEDICINA" : 
			this.categoria = CategorieLibro.TECNOLOGIA_MEDICINA.toString();  
			break;
		
		default :
			this.categoria = null;
			break;
		}
	}
	public LocalDate getDataPubb() {
		return dataPubb;
	}
	public void setDataPubb(LocalDate dataPubb) {
		this.dataPubb = dataPubb;
	}
	public String getRecensione() {
		return recensione;
	}
	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}
	public int getNrCopie() {
		return nrCopie;
	}
	public void setNrCopie(int nrCopie) {
		this.nrCopie = nrCopie;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public int getCopieRim() {
		return copieRim;
	}
	public void setCopieRim(int copieRim) {
		this.copieRim = copieRim;
	}
	public String[] getInfoGenerali() {
		return infoGenerali;
	}
	public void setInfoGenerali(String[] infoGenerali) {
		this.infoGenerali = infoGenerali;
	}
	public String[] getInfoCostiDisp() {
		return infoCostiDisp;
	}
	public void setInfoCostiDisp(String[] infoCostiDisp) {
		this.infoCostiDisp = infoCostiDisp;
	}
	public int getNumeroPagine() {
		return numeroPagine;
	}
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public LibroBean()
	{
		
	}
	@Override
	public void scarica() throws DocumentException, IOException {
		File file=null;
		File dirToOpen=null;
		file = new File(url);
		Desktop desktop=null;
		file.mkdir();


		desktop = Desktop.getDesktop();
		
			dirToOpen = new File(url);

			desktop.open(dirToOpen);

		
	}
	@Override
	public void leggi(int i) throws IOException, DocumentException {
		Document document=null;
		File file;
		
		if(i==1)
		{
	   		document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Alessandro Coppola - Apocalypse Town.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Alessandro Coppola - Apocalypse Town.pdf");
	        Desktop.getDesktop().open(file);
	     }
		if (i==2)
		{
			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Andrea Baranes - �Dobbiamo restituire.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Andrea Baranes - �Dobbiamo restituire.pdf");
	        Desktop.getDesktop().open(file);
		}
		if (i==3)
		{

			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Ariel Toaff, Elio Toaff - Zohar. Il libro dello splendore.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Ariel Toaff, Elio Toaff - Zohar. Il libro dello splendore.pdf");
	        Desktop.getDesktop().open(file);
					
		}
		if(i==4)
		{

			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Come i servizi segreti usano i media - Aldo Giannuli.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Come i servizi segreti usano i media - Aldo Giannuli.pdf");
	        Desktop.getDesktop().open(file);
					
		}
		if(i==5)
		{
			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Donald Davidson - Sulla verit� (2006).pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Donald Davidson - Sulla verit� (2006).pdf");
	        Desktop.getDesktop().open(file);
		}
		if(i==6)
		{

			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\eragon.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\eragon.pdf");
	        Desktop.getDesktop().open(file);
		}
		if(i==8)
		{
			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Gershom Scholem - Alchimia E Kabbalah.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Gershom Scholem - Alchimia E Kabbalah.pdf");
	        Desktop.getDesktop().open(file);
		}
		if (i==9)
		{
			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Excell - Giampietro Lanzanova.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Excell - Giampietro Lanzanova.pdf");
	        Desktop.getDesktop().open(file);
		}
		if (i==10)
		{
			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Giocatore5.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Giocatore5.pdf");
	        Desktop.getDesktop().open(file);
		}
		if (i==11)
		{
			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Grammatica italiana-Garzanti(le garzantine)(2012).pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Grammatica italiana-Garzanti(le garzantine)(2012).pdf");
	        Desktop.getDesktop().open(file);
		}
		else {
			document = new Document();
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Anteprima Non Disponibile"+i+".pdf"));
   			document.open();	

   			document.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur feugiat ornare dictum. Donec semper pellentesque risus, quis pulvinar nisl efficitur nec. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vivamus nisl mi, ullamcorper cursus pulvinar ut, pretium ut quam. Proin felis mauris, pretium non scelerisque vitae, posuere vel risus. Sed tortor enim, sollicitudin et eros at, fermentum suscipit urna. Sed at nisi quis libero hendrerit interdum at sodales dui. Nullam nec mattis urna. Quisque rhoncus pharetra malesuada. Etiam porttitor ligula consequat nisi luctus scelerisque. Sed purus purus, gravida ac orci sit amet, faucibus euismod diam. In dignissim enim sed nisl euismod, in vulputate odio facilisis. Sed venenatis facilisis massa, ac condimentum ante rutrum blandit. Vivamus efficitur eros quis diam semper, nec porttitor lectus vehicula. Fusce turpis ipsum, mollis vel nunc vitae, blandit molestie nunc. Nunc sit amet feugiat lacus.\r\n"
   					+ "\r\n"
   					+ "Aenean sollicitudin id dolor eu luctus. Proin tincidunt semper lobortis. Nunc nec odio lorem. Praesent consectetur, nunc sed egestas elementum, orci ligula dictum ligula, ut vehicula augue nibh sit amet quam. Nam nec massa lorem. Donec sed elit massa. Praesent neque ante, suscipit nec ornare id, bibendum non dolor. Donec sem ex, placerat ac hendrerit quis, ullamcorper nec quam. Morbi tempus tellus at porta fermentum. Donec vitae dolor orci. Vivamus fermentum faucibus eros, et cursus lorem aliquet in. Integer vitae ipsum eu nulla sodales porta.\r\n"
   					+ "\r\n"
   					+ "Donec et purus aliquam, sagittis est eget, molestie dui. In porttitor maximus dui, a mattis urna faucibus ut. Fusce vulputate nisi dolor, sed hendrerit urna placerat quis. In hac habitasse platea dictumst. Aliquam a tempus eros. Aenean at augue quam. Vestibulum lectus enim, mollis sed pulvinar quis, porta vel lorem. Mauris vel eleifend dui. Sed venenatis ullamcorper mollis.\r\n"
   					+ "\r\n"
   					+ "Proin non ullamcorper ex, quis bibendum diam. Aliquam eleifend efficitur diam ut porta. Morbi ipsum sapien, vehicula sit amet felis nec, vulputate malesuada tortor. Sed finibus, augue at auctor ornare, ligula nunc venenatis nunc, sit amet mollis est dolor sed erat. Integer fermentum gravida tellus, mattis finibus turpis fringilla et. Nam sed aliquet nunc. Pellentesque nec urna metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque rhoncus condimentum ornare. Curabitur pellentesque lacinia scelerisque. Curabitur faucibus et purus fermentum venenatis. Quisque sed tempor augue, non mattis massa. Vivamus vestibulum pulvinar elit id iaculis. Proin tincidunt eros nisi, et volutpat lorem rutrum ut. Phasellus convallis metus fermentum nisi molestie, sit amet rhoncus mauris laoreet.\r\n"
   					+ "\r\n"
   					+ "Vestibulum aliquet nisi sit amet tristique consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a fringilla libero. Fusce pharetra purus eu tortor dapibus laoreet. Quisque mattis justo et lacus fringilla mattis. Cras sit amet elementum ipsum. Sed varius congue dolor ac placerat. Integer cursus nulla at lectus sollicitudin hendrerit. Suspendisse sit amet tincidunt nunc, at volutpat nisi."));
			
   			document.close();
		

		}
		
	}
	public String getListaCategorie() {
		return listaCategorie;
	}
	public void setListaCategorie(String listaCategorie) {
		this.listaCategorie = listaCategorie;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	
	public void aggiornaData(Libro l,java.sql.Date dataSql) throws SQLException
	{

			Connection conn=null;
			PreparedStatement prepQ=null;
		
			conn = ConnToDb.generalConnection();
			prepQ= conn.prepareStatement("update ispw.libro set dataPubblicazione= ? where Cod_isbn='"+l.getCodIsbn()+"'");
			prepQ.setDate(1, dataSql);
			prepQ.executeUpdate();

		conn.close();


	}
	
	public int aggiornaLibro(Libro l) throws SQLException,NullPointerException
	{


		int rowAffected=0;
		Connection conn=null;
		PreparedStatement prepQ=null;
		

		conn = ConnToDb.generalConnection();
		 stmt = conn.createStatement();


		

		 String query=" UPDATE libro "
				+ "SET "
				+ " `titolo` =?,"
				+ " `numeroPagine` = ?,"
				+ " `Cod_isbn` = ?,"
				+ " `editore` = ?,"
				+ " `autore` = ?,"
				+ " `lingua` = ?,"
				+ " `categoria` = ?,"
				+ " `dataPubblicazione` = ?,"
				+ " `recensione` = ?,"
				+ " `copieVendute` = ?,"
				+ " `breveDescrizione` =?,"
				+ " `disp` = ?,"
				+ " `prezzo` = ?,"
				+ " `copieRimanenti` =?"
				+ " WHERE `idProd` ="+l.getId()+";";
		prepQ=conn.prepareStatement(query);

		prepQ.setString(1,l.getTitolo());
		prepQ.setInt(2,l.getNumeroPagine());
		prepQ.setString(3,l.getCodIsbn());
		prepQ.setString(4,l.getEditore());
		prepQ.setString(5,l.getAutore());
		prepQ.setString(6,l.getLingua());
		prepQ.setString(7,l.getCategoria());
		prepQ.setString(8, l.getDataPubb().toString());
		prepQ.setString(9,l.getRecensione());
		prepQ.setInt(10,l.getNrCopie());
		prepQ.setString(11,l.getDesc());
		prepQ.setInt(12,l.getDisponibilita());
		prepQ.setFloat(13,l.getPrezzo());
		prepQ.setInt(14,l.getCopieRim());


		rowAffected = prepQ.executeUpdate();
		prepQ.close();

		Log.LOGGER.log(Level.INFO, "row affected .{0}", rowAffected);
		return rowAffected;

	}	

	public int cancella(Libro l) throws SQLException {
		
		int row=0;
		Connection conn=null;
		PreparedStatement prepQ=null;
		
			conn = ConnToDb.generalConnection();
			
			prepQ=conn.prepareStatement("delete  FROM ispw.libro where idProd = "+l.getId()+" ;");
			row=prepQ.executeUpdate();
		
	conn.close();

	Log.LOGGER.log(Level.INFO,"Libro cancellato : .{0}",row);
	return row;
		}
}
