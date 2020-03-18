package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private ArrayList<Word> words;//mappa che contiene nella chiave le parole aliene 
	
	/**
	 * Aggiunge al dizionario alieno una nuova traduzione
	 * @param alienWord
	 * @param translation
	 */
	public void addWord(String alienWord, String translation) {
		Word w= new Word(alienWord,translation);
		if(words.contains(alienWord)) {
			int i=words.indexOf(w);
			words.get(i).setTranslation(translation);;
			return;
		}
		words.add(w);
	}
	/**
	 * Restituisce la traduzione di una parola aliena o null se la parola cercata non è nel dizionario
	 * @param alienWord
	 * @return translatedWord
	 */
	public String translateWord(String alienWord) {
		for(Word w:words) {
			if(w.getAlienWord().compareTo(alienWord)==0)
				return alienWord;
		}
		return null;
	}
}
