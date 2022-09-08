package it.uniroma2.ispw.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.uniroma2.ispw.controller.ControllerAddBookPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryAddBookPage implements Initializable {
	
	@FXML
	private Pane pane;
	@FXML
	private GridPane gridpane ;
	@FXML
	private TextField titoloT;
	@FXML 
	private TextField numeroPagineT;
	@FXML
	private TextField codeIsbnT;
	@FXML
	private TextField editoreT;
	@FXML
	private TextField autoreT;
	@FXML
	private TextField linguaT;
	@FXML
	private ListView<String> categoriaList ;
	@FXML
	private DatePicker dataP;
	@FXML
	private TextField recensioneT;
	@FXML 
	private TextArea descrizioneA;
	@FXML
	private CheckBox disponibilitaC;
	@FXML
	private TextField prezzoT;
	@FXML
	private TextField copieRimanentiT;
	@FXML
	private Button buttunC;
	@FXML
	private Button buttonA;
	@FXML
	private Label titoloL;
	@FXML
	private Label numeroPagineL;
	@FXML
	private Label codeIsbnL;
	@FXML
	private Label editoreL;
	@FXML
	private Label autoreL;
	@FXML
	private Label linguaL;
	@FXML
	private Label categoriaL;
	@FXML
	private Label dataL;
	@FXML
	private Label recensioneL;
	@FXML
	private Label descrizioneL;
	@FXML
	private Label disponibilitaL;
	@FXML
	private Label prezzoL;
	@FXML
	private Label copieRimanentiL;
	
	private ControllerAddBookPage cABP;
	
	protected int np;
	protected Scene scene; 
	protected float prezzo;
	protected int copie;
	private ObservableList<String> items = FXCollections.observableArrayList();
	private String[] infoGen=new String[6];
	private String[]infoCostoDisp =new String[6];

	@FXML
	private void conferma() throws SQLException
	{
		
		
		String t=titoloT.getText();
		np=Integer.parseInt(numeroPagineT.getText());
		String cod=codeIsbnT.getText();
		String ed=editoreT.getText();
		String a=autoreT.getText();
		String l=linguaT.getText();
		String c= categoriaList.getSelectionModel().getSelectedItem();
		

		LocalDate d=dataP.getValue();
		String r=recensioneT.getText();
		String desc=descrizioneA.getText();
		boolean disp=disponibilitaC.isSelected();
	
		if(disp)
		{
			infoCostoDisp[3]=String.valueOf(1);

		}
		else {
			infoCostoDisp[3]=String.valueOf(0);

		}
		prezzo=Float.parseFloat(prezzoT.getText());
		copie=Integer.parseInt(copieRimanentiT.getText());
		
		

		infoGen[0]=t;
		infoGen[2]=a;
		infoGen[3]=l;
		infoGen[4]=ed;
		infoGen[5]=c;

		infoCostoDisp[0]=String.valueOf(np);
		infoCostoDisp[1]=cod;
		infoCostoDisp[4]=String.valueOf(prezzo);
		infoCostoDisp[2]=String.valueOf(copie);// settatodi proprosito
		infoCostoDisp[5]=String.valueOf(50);//settato di proposito
		
		cABP.checkData(infoGen,r,desc,d,infoCostoDisp);
		

	}
	
	@FXML
	private void annulla() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("bookPage.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cABP=new ControllerAddBookPage();
		
		categoriaList.setItems(items);
		items.add("ADOLESCENTI_RAGAZZI");
		items.add("ARTE");
		items.add("CINEMA_FOTOGRAFIA");
		items.add("BIOGRAFIE");
		items.add("DIARI_MEMORIE");
		items.add("CALENDARI_AGENDE");
		items.add("DIRITTO");
		items.add("DIZINARI_OPERE");
		items.add("ECONOMIA");
		items.add("FAMIGLIA");
		items.add("SALUTE_BENESSERE");
		
		items.add("FANTASCIENZA_FANTASY");
		items.add("FUMETTI_MANGA");
		items.add("GIALLI_THRILLER");
		items.add("COMPUTER_GIOCHI");
		items.add("HUMOR");
		items.add("INFORMATICA");
		items.add("WEB_DIGITAL_MEDIA");
		items.add("LETTERATURA_NARRATIVA");
		items.add("LIBRI_BAMBINI");
		items.add("LIBRI_SCOLASTICI");
		items.add("LIBRI_UNIVERSITARI");
		items.add("RICETTARI_GENERALI");
		
		items.add("LINGUISTICA_SCRITTURA");
		items.add("POLITICA");
		items.add("RELIGIONE");
		items.add("ROMANZI_ROSA");
		items.add("SCIENZE");
		items.add("TECNOLOGIA_MEDICINA");
		
		
		
		
	}
	
			
}
