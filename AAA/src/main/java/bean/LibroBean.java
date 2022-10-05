package bean;

import java.time.LocalDate;
import java.util.List;

import it.uniroma2.ispw.model.raccolta.Libro;

public class LibroBean {
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
	

}
