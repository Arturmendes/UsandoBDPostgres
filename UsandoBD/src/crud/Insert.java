package crud;

import java.sql.Connection;

import conexao.Conectar;

public class Insert {
	
	private Connection conexao = Conectar.getConnection();
	
	public Insert() {
		
		
	}
	
	public void gravar() {
		
		System.out.println(conexao);
		
	}
	

}
