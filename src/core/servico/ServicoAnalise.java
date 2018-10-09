package core.servico;

import core.canal.Canal;

public class ServicoAnalise implements Servico {

	@Override
	public void disparar(Canal canal, String mensagem) {
		canal.disparar(mensagem);
	}

}
