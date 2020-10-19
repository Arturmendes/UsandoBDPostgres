package crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.Conectar;
import util.ProximoRegistro;



public class DAO {
	
	private Connection conexao = Conectar.getConnection();
	
	ProximoRegistro proximoRegistro = new ProximoRegistro();
	
	public DAO() {
		
		
		
	}
	
	public void gravar() {

		System.out.println("Insert.gravar() conexão: " + conexao);

		String sql = "insert into aluno values (" + proximoRegistro.proximoRegistro() + ", 'teste', 5)";

		try {
			Statement insert = conexao.createStatement();
			int retorno = insert.executeUpdate(sql);
			conexao.commit();

			System.out.println(retorno + " registro inserido com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
	
	

}
