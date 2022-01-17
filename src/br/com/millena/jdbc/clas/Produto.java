package br.com.millena.jdbc.clas;

import java.util.Scanner;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private float desconto;
	private String data;

	public Produto() {
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite o id");
		int id = sc.nextInt();
		System.out.println("Digite o nome");
		String nome = sc.next();
		System.out.println("Digite o descricao");
		String descricao = sc.next();
		System.out.println("Digite o desconto");
		float desconto = sc.nextFloat();
		System.out.println("Digite a data");
		String data = sc.next();
		this.id= id;
		this.nome=nome;
		this.desconto= desconto;
		this.descricao=descricao;
		this.data=data;
		
		

	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
