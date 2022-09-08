package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.UsersDao;
import it.uniroma2.ispw.model.TempUser;
 

public class ControllerCancUser {
	private static TempUser u=TempUser.getInstance();
	

	public void cancellaUtente(int id) throws SQLException
	{
		u.setId(id);
		UsersDao.deleteTempUser(u);
	}
	
	
}
