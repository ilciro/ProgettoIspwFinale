package it.uniroma2.ispw.controller;

import java.util.logging.Level;

import it.uniroma2.ispw.exception.LogoutException;
import it.uniroma2.ispw.model.Log;
import it.uniroma2.ispw.model.User;

public class ControllerHomePageAfterLoginSE {
	private static User u = User.getInstance();
	private static ControllerSystemState vis = ControllerSystemState.getIstance() ;

	// qui ci va la funzione di logout

	public static boolean logout() throws   SecurityException, IllegalArgumentException, LogoutException
	{	
			
			String n = u.getNome();
			if(n==null)
				throw new LogoutException("Errore Logout");
			else {
			Log.LOGGER.log(Level.INFO,"Stai sloggando con il nome di : {0}", n );
			u.setId(-1);
			u.setNome(null);
			u.setCognome(null);
			u.setDataDiNascita(null);
			u.setDescrizione(null);
			u.setEmail(null);
			u.setPassword(null);
			

				Log.LOGGER.log(Level.INFO,"Logout  utente {0}", u.getEmail());
				vis.setIsLogged(false);
				return true;
			}

		

	}
	private ControllerHomePageAfterLoginSE()
	{
		
	}

}
