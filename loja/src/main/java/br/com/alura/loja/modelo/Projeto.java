package br.com.alura.loja.modelo;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class Projeto {

	private String nome;
	
	private Long id;
	
	private int anoInicio;

	public String getNome() {
		return nome;
	}
	
	public Projeto(Long id, String nome, int anoInicio){
		this.nome = nome;
		this.id = id;
		this.anoInicio = anoInicio;
	}
	
	Projeto(){
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}
	
	public String toXML(){
		return new XStream().toXML(this);
	}

	public String toJson() {
		// TODO Auto-generated method stub
		return new Gson().toJson(this);
	}
	
}
