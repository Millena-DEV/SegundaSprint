package br.com.millena.jdbc.executavel;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.millena.jdbc.clas.Produto;
import br.com.millena.jdbc.clas.ProdutoMetodos;

public class Executavel {

	public static void main(String[] args) throws SQLException {
	 
		Produto produto = new Produto();
	   ProdutoMetodos pm= new ProdutoMetodos(null);
	  pm.iniciar();
		

		
	}
}
