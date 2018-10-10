package core.servico;

import core.TipoServico;
import fastmoney.ContaCorrente;

public class ServicoBaixa implements Servico {
	
	@Override
	public void disparar(ContaCorrente conta) {
		System.out.println(conta.getUltimaOperacao().toString() + "- Serviço de baixa");
	}

	@Override
	public TipoServico getTipo() {
		return TipoServico.BAIXA;
	}

}
