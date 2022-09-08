package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.LibroDao;
import it.uniroma2.ispw.model.raccolta.Libro;

public class ControllerCancLibro {

	private LibroDao lD;
	private Libro l;

	public void cancella(int id) throws SQLException {
		l.setId(id);
		lD.cancella(l);

	}

	public ControllerCancLibro()
	{
		lD=new LibroDao();
		l=new Libro();
	}


}
