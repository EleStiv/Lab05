package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DizionarioDAO {
	
	public List<String> getDizionario() {
		
		LinkedList<String> dizionario = new LinkedList(); 
		
		final String sql = "SELECT nome\r "
				+ "FROM parola; "; 
		
		try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql); 
		
		ResultSet rs = st.executeQuery(); 
		
		while(rs.next()) {
			String par = rs.getString("nome"); 
			dizionario.add(par); 
		}
		rs.close();
		conn.close();
		
		return dizionario; 
		
		
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("problemi in DizionarioDAO");
			return null; 
		}
		
	}
	

}
