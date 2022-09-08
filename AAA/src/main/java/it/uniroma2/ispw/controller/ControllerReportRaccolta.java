package it.uniroma2.ispw.controller;

import it.uniroma2.ispw.model.User;

public class ControllerReportRaccolta {
	private static User u=User.getInstance();
	
	public String getTipo()
	{
		return u.getIdRuolo();
	}

}
