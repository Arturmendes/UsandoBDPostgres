package main;


import crud.DAO;
import util.ProximoRegistro;

public class Principal {
	
	

	public static void main(String[] args) {
		
		DAO gravar = new DAO();		
		gravar.gravar();
		
		ProximoRegistro testeProximoRegistro = new ProximoRegistro();
		
		System.out.println(testeProximoRegistro.proximoRegistro());
		
		
		
	}

}
