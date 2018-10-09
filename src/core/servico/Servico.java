package core.servico;

import core.canal.Canal;

public interface Servico {
	public void disparar(Canal canal, String mensagem);
}
