package it.polito.tdp.spellchecker.model;

import java.util.ArrayList;
import java.util.List;

public class RichWord {

	private String wordInput = "";
	private boolean isCorrect = false;
	
	public RichWord(String wordInput, boolean isCorrect) {
		this.wordInput=wordInput;
		this.isCorrect = isCorrect;
	}

	public String getWordInput() {
		return wordInput;
	}

	public void setWordInput(String wordInput) {
		this.wordInput = wordInput;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	
	
}
