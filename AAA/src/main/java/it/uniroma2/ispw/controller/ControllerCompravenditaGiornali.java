package it.uniroma2.ispw.controller;


import java.sql.SQLException;

import it.uniroma2.ispw.database.GiornaleDao;
import it.uniroma2.ispw.model.User;
import it.uniroma2.ispw.model.raccolta.Giornale;
import it.uniroma2.ispw.model.raccolta.Raccolta;
import javafx.collections.ObservableList;




public class ControllerCompravenditaGiornali {
	private GiornaleDao gD;
	private Giornale g;
	private User u=User.getInstance();
	

	public ControllerCompravenditaGiornali() {
		gD = new GiornaleDao();
		g = new Giornale();

	}

	public ObservableList<Raccolta> getGiornali() throws SQLException  {
		
		return gD.getGiornali();

	}

	public boolean disponibilitaGiornale(String i ) throws SQLException  {
		int id=0;
		id= Integer.parseInt(i);
		return gD.checkDisp(g,id);
	}
	
	public void setTipoUser(String ruolo)
	{
		u.setIdRuolo(ruolo);
	}

	public String retTipoUser()
	{
		return u.getIdRuolo();
	}
	/*
	 * Resource	Date	Description
ControllerCompravenditaGiornali.java	6 days ago	Define a constant instead of duplicating this literal "SCRITTORE" 4 times. [+4 locations]

	 */

}
