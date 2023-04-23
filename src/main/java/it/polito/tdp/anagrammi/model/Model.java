package it.polito.tdp.anagrammi.model;
import java.util.*;

import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class Model {
	
	private Ricorsione r; 
	private DizionarioDAO d; 
	
	public Model() {
		r = new Ricorsione(); 
		d = new DizionarioDAO(); 
	}
	
	public List<String> anagrammi(String parola){
		return r.anagrammi(parola); 
	}
	
	public List<String> getDizionario(){
		return d.getDizionario(); 
	}

}
