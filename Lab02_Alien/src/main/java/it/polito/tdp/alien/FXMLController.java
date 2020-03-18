package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;
  
   @FXML
   private TextField txtParole;
   
   @FXML
   private TextArea txtRisultati;
   
   AlienDictionary ad;

    @FXML
    void doTranslate(ActionEvent event) {
    	//Acquisisco il testo in una stringa
    	String text= txtParole.getText();
    	//Controllo il testo: è formato da una o da due parole? 
    	String[] parole=text.split(" ");
    	String alienWord= parole[0];
    	String traduzione=parole[1];
    	//Chiamo i metodi necessari
    	if(parole.length==1) {
    		//chiamo metodo di traduzione
    		String parolaTradotta=ad.translateWord(alienWord);
    	}else if(parole.length==2) {
    		//chiamo metodo di aggiunta parola al dizionario
    		ad.addWord(alienWord, traduzione);
    	}else {
    		//le parole non sono ne 2 e ne 1 perciò il formato inserito è sbagliato, lanciare un errore
    		
    	}
    	
    	//Ripulisco casella di testo
    	txtParole.clear();
    	txtRisultati.setText("Aggiunta parola al dizionario");
    	  	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	// TODO - add the button and complete this 
    }
    
    
    @FXML
    void initialize() {

    }
}