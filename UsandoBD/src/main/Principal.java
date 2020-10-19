package main;


import crud.DAO;
import util.ProximoRegistro;

public class Principal {
	
	

	public static void main(String[] args) {
		
		DAO dao = new DAO();		
		dao.gravar("Felipe Teste", 1);
		//dao.update();
		//dao.delete();
		dao.consulta();
		dao.gravar("outro Teste", 1);
		
		ProximoRegistro testeProximoRegistro = new ProximoRegistro();
		
		System.out.println(testeProximoRegistro.proximoRegistro());
		
		
		
	}

}
