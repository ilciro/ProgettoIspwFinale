package bean;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import it.uniroma2.ispw.model.raccolta.Libro;
import it.uniroma2.ispw.model.raccolta.Raccolta;

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
		this.categoria = categoria;
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
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Andrea Baranes - «Dobbiamo restituire.pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Andrea Baranes - «Dobbiamo restituire.pdf");
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
   			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\Donald Davidson - Sulla verità (2006).pdf"));
   			document.open();	   		
			file=new File("C:\\Users\\dani\\git\\ProgettoIspwFinale\\AAA\\libriPerSito\\Donald Davidson - Sulla verità (2006).pdf");
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
	

}
