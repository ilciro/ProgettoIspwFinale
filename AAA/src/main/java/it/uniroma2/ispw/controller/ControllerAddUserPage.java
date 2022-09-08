package it.uniroma2.ispw.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;

import it.uniroma2.ispw.database.UsersDao;
import it.uniroma2.ispw.model.Log;
import it.uniroma2.ispw.model.User;


public class ControllerAddUserPage {
	private  User u=User.getInstance();
	
	public ControllerAddUserPage()
	{
		Log.LOGGER.log(Level.INFO,"ControllerAddUserPage");
	}

	public void insUtente(String nome, String cognome, String email, String pwd, String desc, LocalDate data) throws SQLException
	{
		//azzero per crearlo
		u.setIdRuolo("");
		u.setNome(nome);
		u.setCognome(cognome);
		u.setEmail(email);
		u.setPassword(pwd);
		u.setDescrizione(desc);
		u.setDataDiNascita(data);
		

		UsersDao.createUser(u);
	}
}
