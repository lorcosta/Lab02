package it.polito.tdp.alien;

import java.util.ArrayList;

public class WordEnhanced extends Word{

	private ArrayList<String> tradMultiple= new ArrayList<>();
	
	public WordEnhanced(String alienWord, String translation) {
		super(alienWord, translation);
	}
	
	public void aggiungiTraduzioni(String traduzione) {
		tradMultiple.add(traduzione);
	}

	public ArrayList<String> getTradMultiple() {
		return tradMultiple;
	}
	
}
