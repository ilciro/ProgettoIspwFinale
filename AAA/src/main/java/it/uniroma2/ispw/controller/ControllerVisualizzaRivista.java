package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.RivistaDao;
import it.uniroma2.ispw.model.raccolta.Rivista;



public class ControllerVisualizzaRivista {
	
	private RivistaDao rD;
	private Rivista r;
	private static ControllerSystemState vis = ControllerSystemState.getIstance() ;
	
	public ControllerVisualizzaRivista()
	{
		rD = new RivistaDao();
	}
	public void setID(String i)
	{
		int tempIdMag;
		tempIdMag = Integer.parseInt(i) ;
		vis.setId(tempIdMag);
	}
	public int getID()
	{
		return vis.getId();
	}
	public Rivista getData(int i) throws SQLException
	{
		vis.setTypeAsMagazine();
		return  rD.getRivista(r,i);
	}
}
