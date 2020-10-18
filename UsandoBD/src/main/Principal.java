package main;

import conexao.Conectar;
import crud.Insert;
import util.ProximoRegistro;

public class Principal {
	
	

	public static void main(String[] args) {
		
		Insert gravar = new Insert();		
		gravar.gravar();
		
		ProximoRegistro testeProximoRegistro = new ProximoRegistro();
		
		System.out.println(testeProximoRegistro.proximoRegistro());
		
		
		
	}

}
