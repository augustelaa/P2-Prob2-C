package core.servico;

import core.TipoServico;
import fastmoney.ContaCorrente;
import fastmoney.Operacao;
import fastmoney.TipoOperacao;

public class ServicoInvestimento implements Servico {
	
	@Override
	public void disparar(ContaCorrente conta) {
		Operacao ultima = conta.getUltimaOperacao();
		if (ultima.getTipo().equals(TipoOperacao.ENTRADA)) {
			System.out.println(ultima.toString() + "- Serviço de investimento.");
		}
	}

	@Override
	public TipoServico getTipo() {
		return TipoServico.INVESTIMENTO;
	}

}
