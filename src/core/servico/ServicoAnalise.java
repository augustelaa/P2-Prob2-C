package core.servico;

import fastmoney.ContaCorrente;

public class ServicoAnalise implements Servico {

	@Override
	public void disparar(ContaCorrente conta) {
		System.out.println(conta.getUltimaOperacao().toString() + " - Servi�o de an�lise");
	}

}
