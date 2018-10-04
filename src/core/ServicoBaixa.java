package core;

public class ServicoBaixa implements Servico {
	
	@Override
	public void disparar(TipoCanal canal) {
		System.out.println("Iniciou serviço de baixa."  + canal);
	}

}
