package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.GiornaleDao;
import it.uniroma2.ispw.model.raccolta.Giornale;



public class ControllerVisualizzaGiornale {

	private GiornaleDao gD;
	private Giornale g;

	public ControllerVisualizzaGiornale()
	{
		gD = new GiornaleDao();
	}

	public void setID(String i)
	{		
		int tempIdGior;

		tempIdGior = Integer.parseInt(i) ;
		ControllerSystemState.getIstance().setId(tempIdGior);
	}
	public int getID()
	{
		return ControllerSystemState.getIstance().getId();
	}
	public Giornale getData(int i) throws SQLException 
	{
		// imposto che è un giornale nel controller
		ControllerSystemState.getIstance().setTypeAsDaily();
		return  gD.getGiornale(g,i);
	}

}
