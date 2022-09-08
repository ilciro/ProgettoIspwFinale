package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.model.User;
import it.uniroma2.ispw.model.raccolta.Raccolta;
import javafx.collections.ObservableList;



public class ControllerCompravenditaLibri {
	private LibroDao lD;
	User u=User.getInstance();



	public  boolean disponibilitaLibro(String i ) throws SQLException {
	
		boolean status=false;
		 int id;
		
		
		
		
		
			 id = Integer.parseInt(i);
			 status=lD.checkDisp(id);
			 return status;
				
	}

	public ControllerCompravenditaLibri() {
		lD = new LibroDao();
	}

	public ObservableList<Raccolta> getLibri() throws SQLException {
		return lD.getLibri();
	}
	
	/*
	 * Metodo udato per tornare tipo utente in base a se � loggato o no

	 */
	public String retTipoUser()
	{
		return u.getIdRuolo();
	}
	//usato nel caso se non � loggato-> "utente"
	public void setTipoUser(String ruolo)
	{
		u.setIdRuolo(ruolo);	
	}



	
}
