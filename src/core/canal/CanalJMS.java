package core.canal;

import core.TipoCanal;

public class CanalJMS implements Canal {
	
	@Override
	public TipoCanal getTipo() {
		return TipoCanal.JMS;
	}

	@Override
	public void disparar(String mensagem) {
		System.out.println("[JMS]: " + mensagem);
	}

}
