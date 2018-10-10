package core.servico;

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

}
