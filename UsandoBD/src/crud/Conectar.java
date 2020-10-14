package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
	private String banco = "jdbc:postgresql://127.0.0.1:5432/bd?autoReconnect=true";
	private String user = "artur";
	private String password = "2468";
	private Connection connection = null;
	
	public Conectar() {
		
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
		
		
	}
	
	public Connection getConnection() {
		return connection;
	}
		
		
	
		
		

}
