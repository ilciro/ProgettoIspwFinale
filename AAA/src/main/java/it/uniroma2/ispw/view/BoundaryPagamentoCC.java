package it.uniroma2.ispw.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;

import it.uniroma2.ispw.controller.ControllerPagamentoCC;
import it.uniroma2.ispw.controller.ControllerSystemState;
import it.uniroma2.ispw.model.CartaDiCredito;
import it.uniroma2.ispw.model.Log;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryPagamentoCC implements Initializable {

	@FXML
	private Pane panel;
	@FXML
	private GridPane grid;
	@FXML
	private Label header;
	@FXML
	private Label labelN;
	@FXML
	private Label labelC;
	@FXML
	private Label cartaC;
	@FXML
	private Label labelS;
	@FXML
	private TextField nomeTF;
	@FXML
	private TextField cognomeTF;
	@FXML
	private TextField codiceTF;
	@FXML
	private TextField scadTF;
	@FXML
	private Button buttonI;
	@FXML
	private Button buttonA;

	@FXML
	private Label labelCiv;
	@FXML
	private Button buttonReg;

	@FXML
	private TextField nomeInput;
	@FXML
	private RadioButton buttonPrendi;

	@FXML
	private PasswordField codiceTFCiv;

	@FXML
	private TableView<CartaDiCredito> tableCC;
	@FXML
	private TableColumn<CartaDiCredito, SimpleStringProperty> codiceCC = new TableColumn<>("CodiceCarta");
	@FXML
	private Label labelNU;

	private ControllerPagamentoCC cPCC;
	protected Boolean esito;
	protected Scene scene;
	
	private static ControllerSystemState vis = ControllerSystemState.getIstance();

	@FXML
	private void procediCC() throws IOException, SQLException {
		vis.setMetodoP("cCredito");

		String cod = codiceTF.getText();
		String civ=codiceTFCiv.getText();
		
		
		esito = cPCC.controllaPag(scadTF.getText(),cod,civ);
		   
		
		if (Boolean.TRUE.equals(esito)) {
			//insrrire pagamento cc
			//vedasi inserimento fattura
			cPCC.pagamentoCC(nomeTF.getText());
			if(vis.getIsPickup()) 
			{
				Stage stage;
				Parent root;
				stage = (Stage) buttonI.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("scegliNegozio.fxml"));
				stage.setTitle("Benvenuto nella schermata per il download");
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();	
			}
			else
			{
				 
			Stage stage;
			Parent root;
			stage = (Stage) buttonI.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("download.fxml"));
			stage.setTitle("Benvenuto nella schermata per il download");
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}
		} else {
			Log.LOGGER.log(Level.INFO,"riprovare");
			Stage stage;
			Parent root;
			stage = (Stage) buttonI.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("PagamentoCC.fxml"));

			stage.setTitle("Benvenuto nella schermata per il pagamento");

			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		

	}

	@FXML
	private void annullaCC() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("acquista.fxml"));
		stage.setTitle("benvenuto nella schermata del riepilogo ordine");

		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public BoundaryPagamentoCC()  {
		try {
			cPCC = new ControllerPagamentoCC();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@FXML
	public void registraCC() throws java.text.ParseException, SQLException {
		

		String nome = nomeTF.getText();

		String cognome = cognomeTF.getText();
		String codice = codiceTF.getText();
		String d = scadTF.getText();
		String civ=codiceTFCiv.getText();
		
		Date sqlDate = null;
		java.util.Date utilDate;
		//qui passo stringa per comodita..
		
		
		 SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		    try {
		         utilDate = format.parse(d);
		         sqlDate = new java.sql.Date(utilDate.getTime());
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		cPCC.aggiungiCartaDB(nome, cognome, codice, sqlDate, civ, (float) 0.0);
		
		 
		 
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		codiceCC.setCellValueFactory(new PropertyValueFactory<>("numeroCC"));
		if(!vis.getIsLogged())
		{
			buttonPrendi.setDisable(true);
			buttonReg.setDisable(true);
		}


	}

	@FXML
	private void popolaTabella() throws SQLException {
		try {

			String nomeUt = nomeInput.getText();
			if (nomeUt.equals("")) {
				buttonPrendi.setDisable(true);
				throw new IOException();
			}
			else {
				buttonPrendi.setDisable(false);
				tableCC.setItems(cPCC.ritornaElencoCC(nomeUt));
			}
		} catch (IOException e) {
			e.getMessage();
		}
		buttonPrendi.setDisable(false);
	}

	@FXML
	private void prova() throws SQLException
	{
		nomeTF.setText(cPCC.tornaDalDb(tableCC.getSelectionModel().getSelectedItem().getNumeroCC()).getNomeUser());
		cognomeTF.setText(cPCC.tornaDalDb(tableCC.getSelectionModel().getSelectedItem().getNumeroCC()).getCognomeUser());
		codiceTF.setText(cPCC.tornaDalDb(tableCC.getSelectionModel().getSelectedItem().getNumeroCC()).getNumeroCC());
		scadTF.setText(cPCC.tornaDalDb(tableCC.getSelectionModel().getSelectedItem().getNumeroCC()).getScadenza().toString());


	}
}
