package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Dictionary {

	List<String> parole = new ArrayList<>();

	
	public void loadDictionary(String language) {
		
		try {
			FileReader fr = new FileReader("src/main/resources/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				parole.add(word);
			 }
			br.close();

		} catch (IOException e){
			System.out.println("Errore nella lettura del file: "+language+".txt");
		} 
	
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord> checkList = new ArrayList<>();
		boolean isCorrect= false;
		for(String i : inputTextList) {
			if(parole.contains(i)) {
				isCorrect=true;
			}
			RichWord checked = new RichWord(i, isCorrect);
			checkList.add(checked);
		}
		
		return checkList;
	}
	
//	public List<RichWord> spellCheckTextDichotomic(List<String> inputTextList){
//		List<RichWord> checkList = new ArrayList<>();
//		boolean isCorrect = false;
//		
//		for(String i: inputTextList) {
//			for(int index = ((parole.size())/2); index<(parole.size()); index++) {
//				
//				if(parole.get(index).equals(i)) {
//					isCorrect=true;
//				}else {
//					System.out.println("Parola non trovata nella prima metà di dizionario");
//				}
//			}
//		}
//		
//		return checkList;
//	}
	
	public void removeDict() {
		parole.clear();
	}
	
	public String stampaDizionario() {
		return parole.toString();
	}
	
}
