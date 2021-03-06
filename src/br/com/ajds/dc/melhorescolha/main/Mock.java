package br.com.ajds.dc.melhorescolha.main;

import java.util.ArrayList;
import java.util.List;

import br.com.ajds.dc.melhorescolha.model.Analise;
import br.com.ajds.dc.melhorescolha.model.Dragon;
import br.com.ajds.dc.melhorescolha.model.Resposta;
import br.com.ajds.dc.melhorescolha.service.AnalisaVantagemService;
import br.com.ajds.dc.melhorescolha.type.Elemento;
import br.com.ajds.dc.melhorescolha.type.Raridade;

public class Mock {

	public static void main(String[] args) {
		List<Dragon> dragons = new ArrayList<Dragon>(); 
		dragons.add(new Dragon("comandante", Raridade.HEROICO,Elemento.MAR,Elemento.METAL,Elemento.NATUREZA,Elemento.LUZ));
		dragons.add(new Dragon("legado", Raridade.LENDARIO,Elemento.LENDARIO,null,null,null));
		dragons.add(new Dragon("apanhador sonhos", Raridade.RARO,Elemento.ALMA	,Elemento.SONHO,null,null));
		dragons.add(new Dragon("puro",Raridade.COMUM,Elemento.PURO,null,null,null));
		dragons.add(new Dragon("miragem", Raridade.LENDARIO,Elemento.FOGO,Elemento.GELO	,Elemento.NATUREZA,Elemento.ELETRICO));
		dragons.add(new Dragon("forja", Raridade.LENDARIO,Elemento.METAL,Elemento.TERRA	,Elemento.GELO,Elemento.FOGO));
		dragons.add(new Dragon("fevor", Raridade.LENDARIO,Elemento.GUERRA,Elemento.PURO	,Elemento.FOGO,Elemento.SOMBRIO));
		dragons.add(new Dragon("vislumbre", Raridade.MUITO_RARO	,Elemento.PRIMARIO,Elemento.PURO,null,null));
		dragons.add(new Dragon("promecio", Raridade.LENDARIO,Elemento.LUZ	,Elemento.SOMBRIO	,Elemento.NATUREZA	,Elemento.ELETRICO));
		dragons.add(new Dragon("milenio", Raridade.LENDARIO,Elemento.MAR,Elemento.GUERRA	,Elemento.TERRA	,Elemento.METAL));
		dragons.add(new Dragon("burbi", Raridade.LENDARIO,Elemento.SOMBRIO,Elemento.MAR	,Elemento.LENDARIO,Elemento.TERRA));
		dragons.add(new Dragon("super sonico", Raridade.LENDARIO,Elemento.NATUREZA,Elemento.ELETRICO,Elemento.TERRA	,Elemento.METAL));
		dragons.add(new Dragon("apocalipse", Raridade.LENDARIO,Elemento.FOGO,Elemento.GELO	,Elemento.LUZ,Elemento.SOMBRIO));
		dragons.add(new Dragon("abismo", Raridade.LENDARIO,Elemento.LUZ,Elemento.SOMBRIO,Elemento.GELO,Elemento.FOGO));
		dragons.add(new Dragon("vermelho profundo", Raridade.RARO,Elemento.FOGO,Elemento.METAL,Elemento.SOMBRIO,null));
		dragons.add(new Dragon("dragao dos elementos", Raridade.RARO,Elemento.TERRA,Elemento.FOGO,Elemento.MAR,null));
		dragons.add(new Dragon("natureza", Raridade.COMUM,Elemento.NATUREZA,null,null,null));
		dragons.add(new Dragon("dragao guerra", Raridade.COMUM,Elemento.GUERRA,null,null,null));
		dragons.add(new Dragon("rocha ardente", Raridade.COMUM,Elemento.TERRA,Elemento.FOGO,null,null));
		
		List<Dragon> dragonsRivals = new ArrayList<Dragon>(); 
			
		dragonsRivals.add(new Dragon("rival_1", Raridade.HEROICO,Elemento.PURO	,Elemento.GELO	,Elemento.LENDARIO	,Elemento.SOMBRIO));
		dragonsRivals.add(new Dragon("rival_2",Raridade.HEROICO,Elemento.PURO,Elemento.GELO,Elemento.ELETRICO,Elemento.SOMBRIO));
		dragonsRivals.add(new Dragon("rival_3", Raridade.HEROICO,Elemento.SOMBRIO	,Elemento.FOGO	,Elemento.GUERRA	,Elemento.ELETRICO));




		AnalisaVantagemService analisaVantagemService = new AnalisaVantagemService();
		
		Resposta resposta = analisaVantagemService.executa(dragons, dragonsRivals);
		
		
		resposta.getAnalises().stream().forEach(reg -> {
			if(reg.getRival() != null) {
				imprimirDragao("rival", reg.getRival().getNome(), reg.getRival().getElementos());
			}
			if(reg.getAliado() != null) {
				imprimirDragao("aliado", reg.getAliado().getNome(), reg.getAliado().getElementos());

				System.out.printf("golpe recomendado: %s\n\n",reg.getGolpeRecomendado());
			}else {
				System.out.println("aliado: não encontrado");
				if(reg.getAliadoMuitoDanoPoucaDef() != null) {
					System.out.println("\taliado somente forte sem def");
					imprimirDragao("\taliado", reg.getAliadoMuitoDanoPoucaDef().getNome(), reg.getAliadoMuitoDanoPoucaDef().getElementos());
					System.out.printf("\tgolpe recomendado: %s\n\n",reg.getGolpeRecomendadoPoucaDef());
				}
				if(reg.getAliadoMuitaDefPoucoDano() != null) {
					System.out.println("\taliado somente defensor sem dano alto");
					imprimirDragao("\taliado", reg.getAliadoMuitaDefPoucoDano().getNome(), reg.getAliadoMuitaDefPoucoDano().getElementos());
					System.out.println("");
				}
			}
		});
		
		
	}

	private static void imprimirDragao(String lado, String nome, List<Elemento> elementos) {
		System.out.printf(lado+": %s - elemento: %s \n",
				nome,
				elementos);
	}

}
