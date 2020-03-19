package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	//private ArrayList<Word> words;
	private ArrayList<WordEnhanced> we= new ArrayList<>();
	
	public AlienDictionary() {
	}
	/**
	 * Aggiunge al dizionario alieno una nuova traduzione
	 * @param alienWord
	 * @param translation
	 */
	public void addWord(String alienWord, String translation) {
		WordEnhanced w= new WordEnhanced(alienWord,translation);
		/*if(words.contains(w)) {//se la parola è già presente nel dizionario la aggiorno
			int i=words.indexOf(w);
			words.get(i).setTranslation(translation);;
			return;
		}*/
		for(WordEnhanced word:we) {
			if(word.getAlienWord().compareTo(alienWord)==0) {
				word.aggiungiTraduzioni(translation);
				return;
			}
		}
		w.aggiungiTraduzioni(translation);
		we.add(w);
	}
	/**
	 * Restituisce la traduzione di una parola aliena o null se la parola cercata non è nel dizionario
	 * @param alienWord
	 * @return translatedWord
	 */
	public String translateWord(String alienWord) {
		String returno=null;
		for(WordEnhanced w:we) {
			if(w.getAlienWord().compareTo(alienWord)==0) {
				for(String s:w.getTradMultiple()) {
					if(returno==null)
						returno=s;
					else returno+=", "+s;
				}
			}
		}
		return returno;
	}
}
