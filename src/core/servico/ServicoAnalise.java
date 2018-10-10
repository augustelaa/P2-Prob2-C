package core.servico;

import core.TipoServico;
import fastmoney.ContaCorrente;

public class ServicoAnalise implements Servico {

	@Override
	public void disparar(ContaCorrente conta) {
		System.out.println(conta.getUltimaOperacao().toString() + " - Servi�o de an�lise");
	}

	@Override
	public TipoServico getTipo() {
		return TipoServico.ANALISE;
	}

}
