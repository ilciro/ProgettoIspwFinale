package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.GiornaleDao;
import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.database.RivistaDao;
import it.uniroma2.ispw.model.raccolta.Raccolta;
import javafx.collections.ObservableList;


public class ControllerRicercaPage {
	
	private LibroDao lD;
	private GiornaleDao gD;
	private RivistaDao rD;
	public ControllerRicercaPage()
	{
		lD = new LibroDao();
		gD = new GiornaleDao();
		rD =new RivistaDao();
		ControllerSystemState.getIstance().setIsSearch(true);
		
	}
	
	public ObservableList<Raccolta> cercaPerTipo (String s) throws SQLException
	{
		ObservableList<Raccolta> r = null;
		if(ControllerSystemState.getIstance().getType().equals("libro"))
		{
			//serach in libro dao
			r= lD.getLibriByName(s);
		}
		else if(ControllerSystemState.getIstance().getType().equals("giornale"))
		{
			//search in giornale dao
			r=  gD.getGiornaliByName(s);
		}
		else if(ControllerSystemState.getIstance().getType().equals("rivista"))
		{
			//search in rivista dao
			r= rD.getRivisteByName(s);
		}
		
		return r;
		
	}
	
	public String returnType()
	{
		return ControllerSystemState.getIstance().getType();
	}
	
	
}
