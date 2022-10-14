package bean;

import java.time.LocalDate;




public class UserBean {
	
	enum RuoliB {
		ADMIN,
		UTENTE,
		SCRITTORE,
		EDITORE;
 }
	private int id;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String descrizione;
	private LocalDate dataDiNascita;
	private String r;
	private String via;
	private String com;
	
	//istanza per il patter singleton
	private static UserBean userInstance ;

	private UserBean() {

	}

	public static UserBean getInstance() {
		if (userInstance == null)
		{
			userInstance = new UserBean();
			return userInstance; 
		}
		return userInstance;
	} 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	public String getIdRuolo()  {
		
		return r;
	}



	public void setIdRuolo(String ruolo) {

		 switch (ruolo){
			case "ADMIN":
				r = RuoliB.ADMIN.toString();
				break;				
			case "EDITORE":
				r = RuoliB.EDITORE.toString();
				break;
			case "SCRITTORE":
				r = RuoliB.SCRITTORE.toString();
				break;
			case "UTENTE":
				r = RuoliB.UTENTE.toString();
				break;	
			case "W":
				r = RuoliB.SCRITTORE.toString();
				break;
			case "E":
				r = RuoliB.EDITORE.toString();
				break;	
			case "A":
				r = RuoliB.ADMIN.toString();
				break;
				
			default:
				r= RuoliB.UTENTE.toString();
				break;
			}
		

	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}






}
