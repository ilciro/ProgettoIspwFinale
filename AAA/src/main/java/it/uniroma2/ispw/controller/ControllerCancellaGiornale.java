package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.GiornaleDao;
import it.uniroma2.ispw.model.raccolta.Giornale;

public class ControllerCancellaGiornale {
	private Giornale g;
	private GiornaleDao gD;
	
	public void cancella(int id) throws SQLException {
		g.setId(id);
		gD.cancella(g);

	}
	
	
	
	public ControllerCancellaGiornale()
	{
		g=new Giornale();
		gD=new GiornaleDao();
	}

}
