package br.com.millena.jdbc.clas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.millena.jdbc.ProdutoDao.ProdutoDao;
import br.com.millena.jdbc.factory.ConnectionFactory;



public class ProdutoMetodos  {
	
	private Connection connection;



	public ProdutoMetodos(Connection connection) {
		this.connection = connection;
	
	}

	

	public void iniciar() throws SQLException{
		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor, insira o numero da opcao que deseja:\n");
		System.out.println("1 - Cadastrar ofertas\n");
		System.out.println("2 - Atualizar oferta\n");
		System.out.println("3 -Excluir oferta\n");
		System.out.println("4 -Listar produtos\n");
		System.out.println("0 - Sair");

		int opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.println(" Cadastrando ofertas\n");
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			ProdutoDao produtodao = new ProdutoDao(connection);
			Produto produto = new Produto();
			produtodao.salvar(produto);
		}
			break;
		case 2:
			System.out.println("atualizando ofertas\n");
			try(Connection connection = new ConnectionFactory().recuperaConexao()){
				ProdutoDao produtodao = new ProdutoDao(connection);
				Produto produto = new Produto();
				produtodao.atualizar(produto);
			break;
		}
		case 3:
			System.out.println("excluindo ofertas\n");
			try(Connection connection = new ConnectionFactory().recuperaConexao()){
				ProdutoDao produtodao = new ProdutoDao(connection);
				Produto produto = new Produto();
				produtodao.excluir(produto);
			break;
		
	}
		case 4:
			System.out.println("listando ofertas\n");
			try(Connection connection = new ConnectionFactory().recuperaConexao()){
				ProdutoDao produtodao = new ProdutoDao(connection);
				Produto produto = new Produto();
				produtodao.listar(produto);
			break;
			
	}
		case 0:
			System.out.println("Fechando");
			System.exit(0);
}
}
}