package core.servico;

import core.canal.Canal;

public class ServicoBaixa implements Servico {
	
	@Override
	public void disparar(Canal canal, String mensagem) {
		canal.disparar(mensagem);
	}

}
