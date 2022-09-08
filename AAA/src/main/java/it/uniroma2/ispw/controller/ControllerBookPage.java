package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.model.raccolta.Libro;
import javafx.collections.ObservableList;

public class ControllerBookPage {
	private LibroDao lD;
	
	public ObservableList<Libro> getLibriS() throws SQLException {
		return lD.getLibriSingolo();
	}
	
	public ControllerBookPage()
	{
		lD=new LibroDao();
	}
	

}
