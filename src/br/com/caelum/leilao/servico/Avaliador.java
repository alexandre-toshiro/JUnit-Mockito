package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorDeTodos = Double.MIN_VALUE;
	private double menorDeTodos = Double.MAX_VALUE;
	private double media = 0;

	public void avalia(Leilao leilao) {
		double total = 0;
		for (Lance lance : leilao.getLances()) {

			if (lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			}
			if (lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
			total += lance.getValor();
		}
		if (total == 0) {
			media = 0;
			return;
		}

		media = total / leilao.getLances().size();
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}

	public double getMedia() {
		return media;
	}

}
