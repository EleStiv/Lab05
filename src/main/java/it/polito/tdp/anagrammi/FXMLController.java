package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model modello = new Model(); 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAnagramma;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private TextField txtParola;
    
    @FXML
    private TextField txtNumeroAnagrammi;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	String parola = this.txtParola.getText(); 
    	
    	List<String> dizionario = this.modello.getDizionario(); 
    	List<String> anagrammi = this.modello.anagrammi(parola); 
    	
    	for(String anagramma: anagrammi) {
    		if(dizionario.contains(anagramma))
    			this.txtAnagrammiCorretti.appendText(anagramma + "\n");
    		else
    			this.txtAnagrammiErrati.appendText(anagramma+ "\n");
    	}
    	
    	this.txtNumeroAnagrammi.setText(""+ anagrammi.size());

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    	this.txtNumeroAnagrammi.clear();
    	this.txtParola.clear();

    }

    @FXML
    void initialize() {
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumeroAnagrammi != null : "fx:id=\"txtNumeroAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
