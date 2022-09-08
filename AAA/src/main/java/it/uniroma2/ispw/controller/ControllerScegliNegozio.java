package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.NegozioDao;
import it.uniroma2.ispw.model.Negozio;
import javafx.collections.ObservableList;

public class ControllerScegliNegozio {
	
	private NegozioDao nD;
	public Negozio getN() {
		return n;
	}

	public void setN(Negozio n) {
		this.n = n;
	}

	private Negozio n;
	private ControllerSystemState vis = ControllerSystemState.getIstance() ;

	
	public ControllerScegliNegozio()
	{
		nD = new NegozioDao();
		n = new Negozio(); 
	}
	
	public ObservableList<Negozio> getNegozi() throws SQLException
	{
		ObservableList<Negozio>listOfNegozi;
		listOfNegozi = nD.getNegozi();
		return listOfNegozi;
	}
	
	public boolean isLogged()
	{
		return vis.getIsLogged();
	}
}