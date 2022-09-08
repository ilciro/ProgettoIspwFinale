package it.uniroma2.ispw.controller;

import java.io.IOException;
import java.sql.SQLException;

import it.uniroma2.ispw.database.RivistaDao;


public class ControllerReportRiviste {
	private RivistaDao rd;
	
	
	public void generaReportRiviste () throws IOException, SQLException
	{
		rd.generaReport();
		
	}
	
	
	public ControllerReportRiviste()
	{
		rd=new RivistaDao();
	}

}
