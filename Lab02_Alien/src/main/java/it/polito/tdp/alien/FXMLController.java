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
   
   private AlienDictionary ad= new AlienDictionary();

   /**
    * Traduco o inserisco nel dizionario le parole
    * @param event
    * @return valori di testo nelle caselle
    */
    @FXML
    void doTranslate(ActionEvent event) {
    	//Acquisisco il testo in una stringa
    	String text= txtParole.getText();
    	text=text.toLowerCase();
    	char [] c=text.toCharArray();
    	for(Character i:c) {
    		if(Character.isDigit(i)) {
    			txtRisultati.setText("I numeri non sono ammessi nel dizionario");
    			return;
    		}
    	}
    	//Controllo il testo: è formato da una o da due parole? 
    	String[] parole=text.split(" ");
    	String alienWord= parole[0];
    	//Chiamo i metodi necessari
    	if(parole.length==1) {
    		//chiamo metodo di traduzione
    		String parolaTradotta=ad.translateWord(alienWord);
    		if(parolaTradotta==null) {
    			txtRisultati.setText("La parola cercata ("+parolaTradotta+") non ha ancora una traduzione");
    		}
    		txtRisultati.setText("La traduzione della parola cercata e': "+parolaTradotta);
    		return;
    	}else if(parole.length==2) {
    		//chiamo metodo di aggiunta parola al dizionario
    		String traduzione=parole[1];
    		ad.addWord(alienWord, traduzione);
    		txtRisultati.setText("Aggiunta parola al dizionario");
    	}else {
    		//le parole non sono ne 2 e ne 1 perciò il formato inserito è sbagliato, lanciare un errore
    		txtRisultati.setText("Scegliere tra:\n 1)'parola aliena' 'traduzione'-->Memorizza nel dizionario la traduzione della parola"
    				+ "\n2)'parola aliena'-->Restituisce la traduzione della parola aliena cercata");
    		txtParole.clear();
    		return;
    		
    	}
    	//Ripulisco casella di testo
    	txtParole.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtRisultati.clear();
    	txtParole.clear();
    }
    
    
    @FXML
    void initialize() {

    }
}