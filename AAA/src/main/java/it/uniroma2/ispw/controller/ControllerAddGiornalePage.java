package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.GiornaleDao;
import it.uniroma2.ispw.model.raccolta.Giornale;


public class ControllerAddGiornalePage {
	private GiornaleDao gD;
	private boolean status = false;


	public boolean checkData(Giornale giornale) throws SQLException 
	{
		if(giornale.getDataPubb()==null )
		{
			return status;
		}
		else
		{
			gD.creaGiornale(giornale);
			status = true;
			return status;
		}
	}

	public ControllerAddGiornalePage()
	{
		gD=new GiornaleDao();
	}

}
