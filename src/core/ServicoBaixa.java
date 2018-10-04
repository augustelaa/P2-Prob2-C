package core;

public class ServicoBaixa implements Servico {
	
	@Override
	public void disparar(TipoCanal canal, String mensagem) {
		System.out.println(mensagem + canal);
	}

}
