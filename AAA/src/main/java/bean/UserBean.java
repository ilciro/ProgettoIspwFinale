package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.regex.Pattern;

import it.uniroma2.ispw.model.User;
import it.uniroma2.ispw.utilities.ConnToDb;

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
	private java.util.Date date;
	Statement st;

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

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	
	public boolean checkEmail(String email)
	{
		 Pattern pattern;

		String emailRegex;
		emailRegex= "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; 
                  
		pattern = Pattern.compile(emailRegex); 
		if (email == null) 
			return false; 
		return pattern.matcher(email).matches();
	}
	public  int aggiornaUtente(User u) throws SQLException
	{

		LocalDate d=u.getDataDiNascita();
		Connection conn=null;
		PreparedStatement prepQ=null;
		
		int row=0;
		
			conn = ConnToDb.generalConnection();
			 st=conn.createStatement();
			
			String query="UPDATE ispw.users set idRuolo=?,Nome=?,Cognome=?,Email=?,pwd=?,descrizione=?,DataDiNascita=? where idUser="+u.getId()+"";



			prepQ = conn.prepareStatement(query);

			// setto i vari dati 
			prepQ.setString(1,u.getIdRuolo().substring(0,1));
			prepQ.setString(2,u.getNome() );
			prepQ.setString(3, u.getCognome());
			prepQ.setString(4, u.getEmail());
			prepQ.setString(5,u.getPassword());
			prepQ.setString(6, u.getDescrizione());
			prepQ.setString(7,d.toString());




			row=prepQ.executeUpdate();







		
			conn.close();
		
		return row;
	}
	
	public  boolean deleteUser(User user) throws SQLException
	{
		int id=user.getId();
		
		
			/*
			 * Levo if multipli e cancello in base ad email 
			 */
			
		Connection conn=null;
		PreparedStatement prepQ=null;
		boolean state=false;
		
				conn = ConnToDb.generalConnection();
				
				String query="DELETE FROM ispw.users WHERE idUser=?";
				prepQ=conn.prepareStatement(query);
				prepQ.setInt(1,id);
				prepQ.executeUpdate();
				state= true;

			

			

		
				conn.close();
		
		return state ;
		
	}

}
