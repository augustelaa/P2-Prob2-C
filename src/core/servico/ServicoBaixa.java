package core.servico;

import fastmoney.ContaCorrente;

public class ServicoBaixa implements Servico {
	
	@Override
	public void disparar(ContaCorrente conta) {
		System.out.println(conta.getUltimaOperacao().toString() + "- Serviço de baixa");
	}

}
