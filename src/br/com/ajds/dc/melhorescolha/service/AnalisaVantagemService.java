package br.com.ajds.dc.melhorescolha.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ajds.dc.melhorescolha.model.Analise;
import br.com.ajds.dc.melhorescolha.model.Dragon;
import br.com.ajds.dc.melhorescolha.model.Resposta;
import br.com.ajds.dc.melhorescolha.type.Elemento;

public class AnalisaVantagemService {

	public Resposta executa(List<Dragon> aliados, List<Dragon> rivais) {
		Resposta resposta = new Resposta();
		resposta.setAnalises(new ArrayList<Analise>());

		rivais.stream().forEach(rival -> {
			Analise analise = new Analise();
			analise.setRival(rival);

			Dragon resistenteForte = buscarDragonComAdvantage(rival, aliados, analise);
			analise.setAliado(resistenteForte);
			if(resistenteForte == null ) {
//				Dragon muitoDanoPoucaDef = buscarDragonSomenteForte(rival, aliados, analise);
//				Dragon muitaDefPoucoDano = buscarDragonSomenteDef(rival, aliados, analise);
//				analise.setAliadoMuitaDefPoucoDano(muitaDefPoucoDano);
//				analise.setAliadoMuitoDanoPoucaDef(muitoDanoPoucaDef);
				
			}		
			resposta.getAnalises().add(analise);

		});
		return resposta;
	}

	private Dragon buscarDragonComAdvantage(Dragon rival, List<Dragon> aliados, Analise analise) {
		for (Dragon dragon : aliados) {

			if (verificarDragonResistente(dragon.getTipoPrimario(), rival.getElementos())
					&& verificarDragonForte(dragon.getElementos(), rival.getTipoPrimario(), analise)) {
				aliados.remove(dragon);
				return dragon;
			}
		}
		return null;
	}

	private boolean verificarDragonResistente(Elemento tipoPrimario, List<Elemento> elementos) {
		for (Elemento ele : elementos) {
			if (ele != null && tipoPrimario.vuneravel(ele)) {
				return false;
			}
		}
		return true;
	}

	private boolean verificarDragonForte(List<Elemento> elementos, Elemento tipoPrimario, Analise analise) {
		for (Elemento ele : elementos) {
			if (ele != null && ele.vantagem(tipoPrimario)) {
				analise.setGolpeRecomendado(ele);
				return true;
			}
		}
		return false;
	}

	private Dragon buscarDragonSomenteForte(Dragon rival, List<Dragon> aliados, Analise analise) {
		for (Dragon dragon : aliados) {

			if (verificarDragonResistente(dragon.getTipoPrimario(), rival.getElementos())
					&& verificarDragonForte(dragon.getElementos(), rival.getTipoPrimario(), analise)) {
				aliados.remove(dragon);
				return dragon;
			}
		}
		return null;
	}

	private Dragon buscarDragonSomenteDef(Dragon rival, List<Dragon> aliados, Analise analise) {
		for (Dragon dragon : aliados) {

			if (verificarDragonResistente(dragon.getTipoPrimario(), rival.getElementos())
					&& verificarDragonForte(dragon.getElementos(), rival.getTipoPrimario(), analise)) {
				aliados.remove(dragon);
				return dragon;
			}
		}
		return null;
	}



}
