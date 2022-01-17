package br.com.millena.jdbc.questao10;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.millena.jdbc.factory.ConnectionFactory;
import br.com.millena.jdbc.questao10.emoticons.EmoticonsMensagens;
import br.com.millena.jdbc.questao10.mensagemdao.MensagemDao;

public class Executavel {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite uma mensagem com simbolos  ");
		String  simbolo = sc.nextLine();
		EmoticonsMensagens ms =new  EmoticonsMensagens(simbolo );
		
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			MensagemDao msg = new MensagemDao(connection);
	
			msg.salvar(ms);
		}
		
	}

}
