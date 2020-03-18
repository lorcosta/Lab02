package it.polito.tdp.alien;

public class Word {
	private String alienWord;
	private String translation;
	
	public Word(String alienWord, String translation) {
		this.alienWord=alienWord;
		this.translation=translation;
	}
	
	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	/**
	 * Aggiorna la traduzione di una parola aliena ad una nuova parola
	 * @param translation
	 */
	public void aggiornaTraduzione(String translation) {
		this.translation=translation;
	}
	@Override
	public boolean equals(Object obj) {
		String parola= (String) obj;
		if(this.alienWord.compareTo(parola)==0)
			return true;
		return false;
	}
	
	
}
