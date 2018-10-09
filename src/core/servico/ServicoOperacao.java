package core.servico;

import core.canal.Canal;

public class ServicoOperacao implements Servico {
	@Override
	public void disparar(Canal canal, String mensagem) {
		canal.disparar(mensagem);
	}

}
