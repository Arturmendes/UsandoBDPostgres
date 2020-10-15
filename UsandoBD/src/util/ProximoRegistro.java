package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conectar;

public class ProximoRegistro {
	private Connection conexao;
	
	public ProximoRegistro() {
		conexao = Conectar.getConnection();
	}
	
	public int proximoRegistro() {
		int retorno = -1;
		//String sql = "select count(*) as qtd from aluno";
		String sql = "SELECT MAX(cod) as qtd FROM aluno";
		
		
		try {
			PreparedStatement consulta = conexao.prepareStatement(sql);
			ResultSet result = consulta.executeQuery();
			if(result.next()) {
				retorno = result.getInt("qtd");
			}			
			conexao.commit();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ++retorno;
		
	}
	

}
