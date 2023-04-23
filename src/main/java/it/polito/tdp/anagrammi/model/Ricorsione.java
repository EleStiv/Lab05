package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class Ricorsione {
	
	public List<String> anagrammi(String parola){
		// decompongo estraendo una letteea per  volta della stringa data 
		// i sottoproblemi sono tanti quante le lettere della parola 
		//System.out.println(parola);
		
		if (parola.length()==1) {
			List<String> risultato =new  LinkedList<String>(); 
			risultato.add(parola); 
			return risultato; 
		}else {
			List<String> risultato = new LinkedList<String>(); 
			
			for(int pos = 0; pos< parola.length(); pos ++) {
				
				char lettera = parola.charAt(pos); 
				String restanti = parola.substring(0, pos) + parola.substring(pos + 1); 
				
				List<String> anagrammiRestanti = anagrammi(restanti);
				for(String sol : anagrammiRestanti) {
					risultato.add(lettera+sol);  // ad ogni iterazione avro una lista di sol possibili 
				}
			}
			return risultato; 
		}
		
	}

}
