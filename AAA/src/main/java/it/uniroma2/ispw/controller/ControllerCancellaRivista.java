package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.RivistaDao;
import it.uniroma2.ispw.model.raccolta.Rivista;

public class ControllerCancellaRivista {
	private Rivista r;
	private RivistaDao rd;

	public void cancella(int id) throws  SQLException {
		r.setId(id);
		rd.cancella(r);
	}

	public ControllerCancellaRivista()
	{
		r=new Rivista();
		rd=new RivistaDao();
	}

}
