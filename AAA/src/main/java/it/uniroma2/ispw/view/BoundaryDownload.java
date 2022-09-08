package it.uniroma2.ispw.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;

import com.itextpdf.text.DocumentException;

import it.uniroma2.ispw.controller.ControllerDownload;
import it.uniroma2.ispw.controller.ControllerSystemState;
import it.uniroma2.ispw.model.Log;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BoundaryDownload implements Initializable {
	@FXML
	private SplitPane split;
	@FXML
	private AnchorPane ap1;
	@FXML
	private Label header;
	@FXML
	private AnchorPane ap2;
	@FXML
	private ImageView image;
	@FXML
	private Button buttonI;
	@FXML
	private Button buttonA;

	private ControllerDownload cD;
	private ControllerSystemState vis = ControllerSystemState.getIstance() ;
	protected Alert a;
	protected Scene scene;

	@FXML
	private void scarica() throws IOException, DocumentException {
		
		a = new Alert(Alert.AlertType.CONFIRMATION);
		a.setTitle("Download effettuato");
		a.setHeaderText("Premere ok per scaricarlo e leggerlo\n");
		Optional<ButtonType> result = a.showAndWait();
		
		
		 if ((result.isPresent()) && (result.get() == ButtonType.OK))
	        	
	        {
	            Log.LOGGER.log(Level.INFO,"ALL OK..!");
	            //passo 0 per evitare il NullPointer
            	cD.scaricaLibro();
	            Stage stage;
				Parent root;
				stage = (Stage) buttonA.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();

	        }
	}

	@FXML
	private void pulisci() throws IOException, SQLException {
		cD.annullaOrdine();
		if( vis.getIsLogged()) 
		{
			Stage stage;
			Parent root;
			stage = (Stage) buttonA.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("homePageAfterLogin.fxml"));
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else
		{
			Stage stage;
			Parent root;
			stage = (Stage) buttonA.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
				cD = new ControllerDownload();

	}

}
