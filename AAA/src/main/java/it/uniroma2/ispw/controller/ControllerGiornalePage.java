package it.uniroma2.ispw.controller;


import java.sql.SQLException;

import it.uniroma2.ispw.database.GiornaleDao;
import it.uniroma2.ispw.model.raccolta.Giornale;
import javafx.collections.ObservableList;



public class ControllerGiornalePage {

	private GiornaleDao gD;
	
	public ObservableList<Giornale> getGiornaliS() throws SQLException  {
		return gD.getGiornaleSingolo();
	}
	
	
	public ControllerGiornalePage() {
		gD=new GiornaleDao();
	}
}
