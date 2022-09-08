package it.uniroma2.ispw.controller;

import java.io.IOException;
import java.sql.SQLException;

import it.uniroma2.ispw.database.GiornaleDao;

public class ControllerReportGiornali {
	private GiornaleDao gd;
	
	public void generaReportGiornali () throws IOException, SQLException 
	{
		gd.generaReport();
		
	}
	
	
	public ControllerReportGiornali()
	{
		gd=new GiornaleDao();
	}

}
