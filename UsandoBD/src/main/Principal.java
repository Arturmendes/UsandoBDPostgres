package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Principal {
	
	private String banco = "jdbc:postgresql://127.0.0.1:5432/bd?autoReconnect=true";
	private String user = "artur";
	private String password = "2468";
	private static Connection connection = null;
	
	
	public void conectar() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();			
		}
		
		try {
			connection = DriverManager.getConnection(banco, user, password);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			
			System.out.println("Erro: " + e.getMessage());
			//e.printStackTrace();
		}
		
		System.out.println("Conexão ok.");
		
		
		//return connection;
	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		
		principal.conectar();
		
		
		
		
		

	}

}
