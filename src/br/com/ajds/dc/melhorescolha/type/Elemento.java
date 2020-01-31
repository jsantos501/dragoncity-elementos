package br.com.ajds.dc.melhorescolha.type;

import java.util.ArrayList;
import java.util.List;

public enum Elemento {
	
	
	//elemento (imunidade, dobro dano)
	TERRA("TERRA","ELETRICO", "SOMBRIO"),
	FOGO("FOGO","NATUREZA", "GELO"),
	MAR("MAR","FOGO", "GUERRA"),
	NATUREZA("NATUREZA", "MAR", "LUZ"),
	ELETRICO("ELETRICO", "MAR", "METAL"),
	GELO("GELO", "NATUREZA", "GUERRA"),
	METAL("METAL", "TERRA", "GELO"),
	SOMBRIO("SOMBRIO", "METAL", "LUZ"),
	LUZ("LUZ", "ELETRICO", "SOMBRIO"),
	GUERRA("GUERRA", "TERRA", "FOGO"),
	PURO("", "LENDARIO",""),
	LENDARIO("","PRIMARIO",""),
	PRIMARIO("","PURO",""),
	VENTO("","VENTO",""),
	ALMA("","",""),
	SONHO("","","");
	
	private String primeiraFraqueza = "";
	private String segundaFraqueza = "";
	private String imune = "";

	Elemento(String imunidade, String fraqueza_um, String fraqueza_dois){
		primeiraFraqueza = fraqueza_um;
		segundaFraqueza = fraqueza_dois;
		imune = imunidade;
		
	}

	public boolean vuneravel(Elemento elemento) {
		return this.name().equals(elemento.primeiraFraqueza) || this.name().equals(elemento.segundaFraqueza);
	}
	
	public boolean vantagem(Elemento elemento) {
		
		return this.primeiraFraqueza.equals(elemento.name()) || this.segundaFraqueza.equals(elemento.name());
	}
}
