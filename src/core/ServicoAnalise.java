package core;

public class ServicoAnalise implements Servico {

	@Override
	public void disparar(TipoCanal canal) {
		System.out.println("Iniciou servi�o de analise."  + canal);
	}

}
