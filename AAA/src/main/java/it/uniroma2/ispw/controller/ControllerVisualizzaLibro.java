package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.model.raccolta.Libro;



public class ControllerVisualizzaLibro {
	
	private LibroDao ld;
	private Libro b;
	private ControllerSystemState vis = ControllerSystemState.getIstance() ;
	
	public ControllerVisualizzaLibro()
	{
		ld = new LibroDao();
	}
	public void setID(String i)
	{		 int tempIdLib;
	
		tempIdLib = Integer.parseInt(i) ;
		vis.setId(tempIdLib);
	}
	public int getID()
	{
		return vis.getId();
	}
	public Libro getData(int i) throws SQLException
	{
		// imposto che e' un libro nel controller
		vis.setTypeAsBook();
		return ld.getLibro(b,i);
	}
}