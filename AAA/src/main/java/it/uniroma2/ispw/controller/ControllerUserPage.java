package it.uniroma2.ispw.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

import it.uniroma2.ispw.database.UsersDao;
import it.uniroma2.ispw.model.Log;

public class ControllerUserPage {
	
	public void getUtenti() throws IOException, SQLException  {
		 UsersDao.getListaUtenti();
	}
	
	public ControllerUserPage()
	{
		Log.LOGGER.log(Level.INFO,"ControllerUserPage");
	}
	

}
