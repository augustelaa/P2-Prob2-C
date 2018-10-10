package core.servico;

import core.TipoServico;
import core.canal.Canal;
import fastmoney.ContaCorrente;
import fastmoney.Operacao;

public class ServicoNotificacao implements Servico {
	@Override
	public void disparar(ContaCorrente conta) {
		Operacao ultima = conta.getUltimaOperacao();
		for (Canal canal : conta.getCanais()) {
			canal.disparar(ultima.toString());
		}
	}

	@Override
	public TipoServico getTipo() {
		return TipoServico.NOTIFICACAO;
	}

}
