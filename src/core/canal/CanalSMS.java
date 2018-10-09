package core.canal;

import core.TipoCanal;

public class CanalSMS implements Canal {
	
	@Override
	public TipoCanal getTipo() {
		return TipoCanal.SMS;
	}

	@Override
	public void disparar(String mensagem) {
		System.out.println("[SMS]: " + mensagem);
	}

}
