package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.RivistaDao;
import it.uniroma2.ispw.model.raccolta.Rivista;
import javafx.collections.ObservableList;



public class ControllerRivistaPage {
	private RivistaDao rd;
	
	public ObservableList<Rivista> getRivistaS() throws SQLException {
		return rd.getRivistaSingolo();
	}
	
	
	public ControllerRivistaPage()
	{
		rd=new RivistaDao();
	}
}
