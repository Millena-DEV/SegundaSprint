package br.com.millena.jdbc.questao10.emoticons;



import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmoticonsMensagens {
	
	private String mensagem;
	private String status;
	

	public EmoticonsMensagens(String simbolo) {

		String Feliz = "\\:\\-\\)";
		String Triste = "\\:\\-\\(";
		Pattern patternFeliz = Pattern.compile(Feliz);
		Pattern patternTriste = Pattern.compile(Triste);
		Matcher matcherF= patternFeliz.matcher(simbolo);
		Matcher matcherT= patternFeliz.matcher(simbolo);
		long contaTriste;
		long contaFeliz;
		contaFeliz = matcherF.results().count();
		contaTriste = matcherT.results().count();
		if (contaFeliz < contaTriste) {
			System.out.println("menor que triste");
			this.status="triste";
		}else if ( contaFeliz > contaTriste) {
			System.out.println("maior que triste");
			this.status="feliz";
		}else {
			System.out.println("neutro");
			this.status = "neutro";
		}
		this.mensagem= simbolo;
		
	}
	




	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
