package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.Conectar;
import util.ProximoRegistro;



public class DAO {
	
	private Connection conexao = Conectar.getConnection();
	
	ProximoRegistro proximoRegistro = new ProximoRegistro();
	
	public DAO() {
		
		
		
	}
	
	public void gravar(String nome, int codCidade) {

		System.out.println("DAO.gravar() conexão: " + conexao);

		String sql = "insert into aluno values (" + proximoRegistro.proximoRegistro() + ", '" + nome + "', " + codCidade + ")";

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
		System.out.println("DAO.update() conexão: " + conexao);

		String sql = "update aluno set nome = 'Artur Mendes', codcidade = 5 where cod = 1";

		try {
			Statement update = conexao.createStatement();
			int retorno = update.executeUpdate(sql);
			conexao.commit();

			System.out.println(retorno + " registro atualizado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		System.out.println("DAO.delete() conexão: " + conexao);

		String sql = "delete from aluno where cod = 3";

		try {
			Statement delete = conexao.createStatement();
			int retorno = delete.executeUpdate(sql);
			conexao.commit();

			System.out.println(retorno + " registro deletado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void consulta() {
		Statement consulta = null;
		ResultSet resultado = null;
		
		System.out.println("DAO.consulta() conexão: " + conexao);

		String sql = "select * from aluno order by cod";

		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			conexao.commit();	
			
			while(resultado.next()) {
				int cod = resultado.getInt("cod");
				String nome = resultado.getString("nome");
				int codCidade = resultado.getInt("codcidade");
				
				System.out.println("Cod: " + cod + "\n" + 
									"Nome: " + nome + "\n" +
									"CodCidade: " + codCidade + "\n" +
									"---------------------------------------------");
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultado.close();
				consulta.close();
				//conexao.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
	public void consultaGeral() {
		Statement consulta = null;
		ResultSet resultado = null;
		
		System.out.println("DAO.consultaGeral() conexão: " + conexao);

		String sql = "select * from aluno order by cod";

		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			conexao.commit();	
			
			while(resultado.next()) {
				int cod = resultado.getInt("cod");
				String nome = resultado.getString("nome");
				int codCidade = resultado.getInt("codcidade");
				
				System.out.println("Cod: " + cod + "\n" + 
									"Nome: " + nome + "\n" +
									"CodCidade: " + codCidade + "\n" +
									"Cidade: " + getNomeCidadeByCod(codCidade) + "\n" +
									"Estado: " + getEstadoByCod(codCidade) + "\n" +
									"---------------------------------------------");
				
				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultado.close();
				consulta.close();
				//conexao.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	
	private String getNomeCidadeByCod(int codCidade) {
		
		Statement consulta = null;
		ResultSet resultado = null;
		
		System.out.println("DAO.getNomeCidadeByCod conexão: " + conexao);

		String sql = "select * from cidade where cod = " + codCidade;
		
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			conexao.commit();	
			
			if(resultado.next()) {
				return resultado.getString("nomeCidade");
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultado.close();
				consulta.close();
				//conexao.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		return null;		
	}
	
private String getEstadoByCod(int codCidade) {
		
		Statement consulta = null;
		ResultSet resultado = null;
		
		System.out.println("DAO.getEstadoByCod() conexão: " + conexao);

		String sql = "select * from cidade where cod = " + codCidade;
		
		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			conexao.commit();	
			
			if(resultado.next()) {
				return resultado.getString("estado");
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultado.close();
				consulta.close();
				//conexao.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		return null;		
	}
	
	

}
