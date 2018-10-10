package core.servico;

import core.TipoServico;
import fastmoney.ContaCorrente;

public interface Servico {
	TipoServico getTipo();
	void disparar(ContaCorrente conta);
}
