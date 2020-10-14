package crud;

import java.sql.Connection;

import conexao.Conectar;

public class Insert {
	
	private Connection conexao;
	
	public Insert() {
		Conectar con = new Conectar();
		conexao = con.getConnection();
		
	}
	
	public void gravar() {
		
		System.out.println(conexao);
		
	}
	

}
