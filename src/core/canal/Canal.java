package core.canal;

import core.TipoCanal;

public interface Canal {
	TipoCanal getTipo();
	void disparar(String mensagem);
}
