package core.servico;

import core.TipoServico;
import fastmoney.ContaCorrente;
import fastmoney.Operacao;
import fastmoney.TipoOperacao;

public class ServicoFinanciamento implements Servico {
	
	@Override
	public void disparar(ContaCorrente conta) {
		Operacao ultima = conta.getUltimaOperacao();
		if (ultima.getTipo().equals(TipoOperacao.SAIDA)) {
			System.out.println(ultima.toString() + "- Serviço de financiamento");
		}
	}

	@Override
	public TipoServico getTipo() {
		return TipoServico.FINANCIAMENTO;
	}

}
