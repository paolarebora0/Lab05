package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	AnagrammaDAO dao = new AnagrammaDAO();
	
	public Set<String> calcolaAnagrammi(String parola) {
		Set<String> anagrammi = new HashSet<String>();
		String parziale = "";
		calcola(parziale,parola,0,anagrammi);
		return anagrammi;
	}
	
	public boolean isCorrect(String anagramma) {
		return dao.isCorrect(anagramma);
	}
	
	public void calcola(String parziale, String parola, int passo, Set<String> anagrammi) {
		
		if(passo == parola.length()) {
			anagrammi.add(parziale);
		}
		
		for(int i = 0; i<parola.length(); i++) {
			if(charCounter(parziale, parola.charAt(i)) < charCounter(parola, parola.charAt(i))) {
				parziale += parola.charAt(i);
				calcola(parziale, parola, passo+1, anagrammi);
				parziale = parziale.substring(0, parziale.length()-1);
			}
		}
	}
	
	public static int charCounter(String string, char c) {
		int count = 0;
		for(int i=0; i<string.length(); i++) {
			
			if(string.charAt(i) == c)
				count++;
		}
		return count;
	}
}
