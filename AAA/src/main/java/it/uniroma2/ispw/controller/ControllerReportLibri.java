package it.uniroma2.ispw.controller;

import java.io.IOException;
import java.sql.SQLException;

import it.uniroma2.ispw.database.LibroDao;

public class ControllerReportLibri {
	private LibroDao ld;
	
	public void generaReportLibri () throws IOException, SQLException
	{
		ld.generaReport();
		
	}
	
	public ControllerReportLibri()
	{
		ld=new LibroDao();
	}
	

}
