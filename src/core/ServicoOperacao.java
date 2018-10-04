package core;

public class ServicoOperacao implements Servico {
	@Override
	public void disparar(TipoCanal canal, String mensagem) {
		System.out.println(mensagem + canal);
	}

}
