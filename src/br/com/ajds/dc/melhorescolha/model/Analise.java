package br.com.ajds.dc.melhorescolha.model;

import br.com.ajds.dc.melhorescolha.type.Elemento;

public class Analise {

	Dragon rival;
	Dragon aliado;
	Elemento golpeRecomendado;
	Dragon aliadoMuitoDanoPoucaDef;
	Dragon aliadoMuitaDefPoucoDano;
	
	
	public Dragon getRival() {
		return rival;
	}
	public void setRival(Dragon rival) {
		this.rival = rival;
	}
	public Dragon getAliado() {
		return aliado;
	}
	public void setAliado(Dragon aliado) {
		this.aliado = aliado;
	}
	public Elemento getGolpeRecomendado() {
		return golpeRecomendado;
	}
	public void setGolpeRecomendado(Elemento golpeRecomendado) {
		this.golpeRecomendado = golpeRecomendado;
	}
	public Dragon getAliadoMuitoDanoPoucaDef() {
		return aliadoMuitoDanoPoucaDef;
	}
	public void setAliadoMuitoDanoPoucaDef(Dragon aliadoMuitoDanoPoucaDef) {
		this.aliadoMuitoDanoPoucaDef = aliadoMuitoDanoPoucaDef;
	}
	public Dragon getAliadoMuitaDefPoucoDano() {
		return aliadoMuitaDefPoucoDano;
	}
	public void setAliadoMuitaDefPoucoDano(Dragon aliadoMuitaDefPoucoDano) {
		this.aliadoMuitaDefPoucoDano = aliadoMuitaDefPoucoDano;
	}
	
}
