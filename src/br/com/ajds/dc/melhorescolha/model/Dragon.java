package br.com.ajds.dc.melhorescolha.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ajds.dc.melhorescolha.type.Elemento;
import br.com.ajds.dc.melhorescolha.type.Raridade;

public class Dragon {

	private String nome;
	private Raridade raridade;
	private Elemento tipoPrimario;
	private List<Elemento> elementos;
	
	public Dragon() {
	}
	
	public Dragon(String nome, Raridade raridade, Elemento primario,Elemento segundario,Elemento terciario,Elemento quartenario) {
		this.nome = nome;
		this.raridade = raridade;
		this.tipoPrimario = primario;
		
		this.elementos = new ArrayList<Elemento>();
		elementos.add(primario);
		elementos.add(segundario);
		elementos.add(terciario);
		elementos.add(quartenario);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Raridade getRaridade() {
		return raridade;
	}
	public void setRaridade(Raridade raridade) {
		this.raridade = raridade;
	}
	public Elemento getTipoPrimario() {
		return tipoPrimario;
	}
	public void setTipoPrimario(Elemento tipoPrimario) {
		this.tipoPrimario = tipoPrimario;
	}
	public List<Elemento> getElementos() {
		return elementos;
	}
	public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	}
	
	
}
