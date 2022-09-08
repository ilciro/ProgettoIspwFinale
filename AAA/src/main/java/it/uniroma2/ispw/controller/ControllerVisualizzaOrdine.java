package it.uniroma2.ispw.controller;

import java.sql.SQLException;

import it.uniroma2.ispw.database.PagamentoDao;
import it.uniroma2.ispw.model.Pagamento;
import javafx.collections.ObservableList;

public class ControllerVisualizzaOrdine {
	
	private PagamentoDao pD;
	
	public ObservableList<Pagamento> getDati() throws SQLException  {
		
		return pD.getPagamenti();
		}
	
	public ControllerVisualizzaOrdine()
	{
		pD=new PagamentoDao();
		
	}

}
