package it.uniroma2.ispw.view;

import java.io.IOException;
import java.util.logging.Level;

import it.uniroma2.ispw.controller.ControllerHomePageAfterLogin;
import it.uniroma2.ispw.controller.ControllerSystemState;
import it.uniroma2.ispw.exception.LogoutException;
import it.uniroma2.ispw.model.Log;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryHomePageAfterLogin
{
@FXML
private Pane pane;
@FXML
private GridPane grid;
@FXML
private Label header;
@FXML
private Button buttonL;
@FXML
private Button buttonG;
@FXML
private Button buttonR;
@FXML
private ImageView imageL;
@FXML
private ImageView imageG;
@FXML
private ImageView imageR;
@FXML
private ImageView imageU;
@FXML
private Button buttonLogin;
@FXML
private Button buttonLogout;
@FXML
private Button buttonC;

protected String message;
protected Scene scene;


@FXML
private void getListaGiornali() throws IOException {
	ControllerSystemState.getIstance().setIsSearch(false);
	ControllerSystemState.getIstance().setTypeAsDaily();
	Stage stage;
	Parent root;
	stage = (Stage) buttonL.getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("compravenditaGiornali.fxml"));
	stage.setTitle("Benvenuto nella schermata del riepilogo dei giornali");
	scene = new Scene(root);
	stage.setScene(scene);

	stage.show();
}

@FXML
private void getListaRiviste() throws IOException {
	ControllerSystemState.getIstance().setIsSearch(false);
	ControllerSystemState.getIstance().setTypeAsMagazine();
	Stage stage;
	Parent root;
	stage = (Stage) buttonL.getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("compravenditaRivista.fxml"));
	stage.setTitle("Benvenuto nella schermata del riepilogo delle riviste");
	scene = new Scene(root);
	stage.setScene(scene);

	stage.show();
}

@FXML
private void getListaLibri() throws IOException {
	ControllerSystemState.getIstance().setIsSearch(false);
	ControllerSystemState.getIstance().setTypeAsBook();
	Stage stage;
	Parent root;
	stage = (Stage) buttonL.getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("compravenditaLibri.fxml"));
	stage.setTitle("Benvenuto nella schermata del riepilogo dei libri");
	scene = new Scene(root);
	stage.setScene(scene);

	stage.show();

}

@FXML
private void profile() throws IOException {
	// specificare controller logico
	/*
	 */
	Stage stage;
	Parent root;
	stage = (Stage) buttonL.getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("visualizzaProfilo.fxml"));
	stage.setTitle("Benvenuto nel tuo profilo qui puoi visualizzare le tue informazioni");
	scene = new Scene(root);
	stage.setScene(scene);

	stage.show();
	
	message = "Sto nel terzo caso d'urso lode";		
	Log.LOGGER.log(Level.INFO,"-> {0}",message);
}

@FXML
private void logout() throws IOException, LogoutException 
{
	
	if (ControllerHomePageAfterLogin.logout())
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonLogout.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);

		stage.show();
	}
	else
	{
		Log.LOGGER.log(Level.SEVERE,"Error in logout");


	}

} 

@FXML
private void cerca() throws IOException {
	ControllerSystemState.getIstance().setIsSearch(true);
	Stage stage;
	Parent root;
	stage = (Stage) buttonC.getScene().getWindow();
	root = FXMLLoader.load(getClass().getResource("ricercaPerTipo.fxml"));
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();

}
}
