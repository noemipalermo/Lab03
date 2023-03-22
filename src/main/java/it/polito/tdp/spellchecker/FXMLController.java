/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FXMLController {

	private Dictionary model;
	private RichWord word;
	private String languageChoose;

	public void setModel(Dictionary model) {
		this.model = model;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private ComboBox<String> language;

    @FXML
    private TextField txtInput;

    @FXML
    private Text txtNumError;

    @FXML
    private TextArea txtOutput;

    @FXML
    private Text txtTime;

    @FXML
    void doClear(ActionEvent event) {
    	
    	this.txtInput.clear();
    	this.txtTime.setText("");;
    	this.txtOutput.clear();
    	this.model.removeDict();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	try {
    		this.languageChoose = this.language.getValue();
    	}catch(Exception e) {
    		this.txtOutput.setText("Scegli una lingua");
    	}
    	if (languageChoose == "English"){
    		model.loadDictionary("English");
    	}else if (languageChoose == "Italian") {
    		model.loadDictionary("Italian");
    	}
    	
    	if(this.txtInput.getLength()==0) {
    		this.txtOutput.appendText("Inserisci frase per controllo ortografico");
    	}
    	
    	this.txtOutput.setText("");
    	
    	String input = this.txtInput.getText().toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"?]", "");
    	
    	List<String> inputWords = new ArrayList<>();
    	String[] inputSplit = input.split("\\s");
    	
    	for(String s : inputSplit) {
    		inputWords.add(s);
    	}
    	
    	List<RichWord>ok = model.spellCheckText(inputWords);
    	
    	if(!ok.isEmpty()) {
    		int error = 0;
	    	for(RichWord o : ok) {
	    		if(!o.isCorrect()) {
	    			this.txtOutput.appendText(o.getWordInput()+"\n");
	    			error++;
	    		}
	    	}
	    	this.txtNumError.setText("The text contains "+error+" errors");
    	}
    	
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumError != null : "fx:id=\"txtNumError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

        language.getItems().add("English");
        language.getItems().add("Italian");
    }

}



