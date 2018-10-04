package core;

public class ServicoOperacao implements Servico {
	@Override
	public void disparar(TipoCanal canal) {
		System.out.println("Iniciou serviço de operação." + canal);
	}

}
