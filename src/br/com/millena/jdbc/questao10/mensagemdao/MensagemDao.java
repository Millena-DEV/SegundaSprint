package br.com.millena.jdbc.questao10.mensagemdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.millena.jdbc.questao10.emoticons.EmoticonsMensagens;

public class MensagemDao {

	private Connection connection;

	public MensagemDao(Connection connection) {
		this.connection = connection;

	}

	public void salvar(EmoticonsMensagens mensagens) throws SQLException {
		String sql = "INSERT INTO mensagens (M) VALUES (?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, mensagens.getMensagem());
			pstm.setString(2, mensagens.getStatus());

			pstm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
