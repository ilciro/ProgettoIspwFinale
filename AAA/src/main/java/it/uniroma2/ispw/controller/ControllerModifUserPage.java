package it.uniroma2.ispw.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;

import it.uniroma2.ispw.database.UsersDao;
import it.uniroma2.ispw.model.Log;
import it.uniroma2.ispw.model.TempUser;

public class ControllerModifUserPage {
	private static TempUser uT=TempUser.getInstance();
	
	
	
	public ControllerModifUserPage()
	{
		Log.LOGGER.log(Level.INFO,"ControllerModifUserPage");
	}



	public TempUser prendiLista(int id) throws SQLException  {
		
		uT.setId(id);
		
		return UsersDao.getTempUserSingolo(uT);
		
		
	}
	
	public int  prendiIdMax() throws SQLException 
	{
		return UsersDao.maxIdUSer();
	}



	public void aggiornaUtenteByAdmin(String n, String c, String e, String p, String d, LocalDate data, String r) throws NullPointerException, SQLException {
		
		uT.setNome(n);
		uT.setCognome(c);
		uT.setEmail(e);
		uT.setPassword(p);
		uT.setDescrizione(d);
		uT.setDataDiNascita(data);
		TempUser.getInstance().setIdRuolo(r);
		

		
		UsersDao.aggiornaUtenteTemp(uT);
		
		
	}
	
	
}
