package br.com.millena.jdbc.ProdutoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.millena.jdbc.clas.Produto;

public class ProdutoDao  {

	private Connection connection;

	public ProdutoDao(Connection connection) {
		this.connection = connection;
	
	}

	public void salvar(Produto produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO,DESCONTO,DATA) VALUES (?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setFloat(3, produto.getDesconto());
			pstm.setString(4, produto.getData());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Produto produto = new Produto();

					produtos.add(produto);
				}
			}
		}
		return produtos;
	}

	public void excluir(Produto protudo) throws SQLException {
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();

		Integer linhasModificadas = stm.getUpdateCount();

		System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
		stm.close();
		connection.close();

	}

	public void atualizar(Produto produto) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("update de produtos");
		System.out.println("para alterar nome digita 1");
		System.out.println("para alterar descricao  digita 2");
		System.out.println("para alterar desconto  digita 3");
		System.out.println("para alterar data  digita 4");
		int opcao = sc.nextInt();
		PreparedStatement stm = connection.prepareStatement("UPDATE PRODUTO SET NOME=? WHERE ID = ? ");
	
		String sql;
		if(opcao ==1 ) {
            sql = "UPDATE PRODUTO SET NOME = ? where id = ?";
        }
        if(opcao ==2 ) {
            sql = "UPDATE PRODUTO SET DESCRIÇÃO = ? where id = ?";
        }
        if(opcao ==3 ) {
            sql = "UPDATE PRODUTO SET DESCONTO = ? where id = ?";
        }
        if(opcao ==4 ) {
            sql = "UPDATE PRODUTO SET DATA = ? where id = ?";
        }
	}
	public void listar(Produto produto) throws SQLException {

		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO,DESCONTO,DATA FROM PRODUTO");
		stm.execute();
		ResultSet rst = stm.getResultSet();
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			float desconto = rst.getFloat("DESCONTO");
			String data = rst.getString("DATA");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
			System.out.println(desconto);
			System.out.println(data);
		}
		rst.close();
		stm.close();
		connection.close();
	}	
   }

