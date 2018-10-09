package core.canal;

import core.TipoCanal;

public class CanalWhatsApp implements Canal {
	
	@Override
	public TipoCanal getTipo() {
		return TipoCanal.WHATSAPP;
	}

	@Override
	public void disparar(String mensagem) {
		System.out.println("[WhatsApp]: " + mensagem);
	}

}
