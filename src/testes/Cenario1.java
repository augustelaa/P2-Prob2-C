package testes;

import org.junit.Test;

import core.canal.Canal;
import core.canal.CanalJMS;
import core.canal.CanalSMS;
import core.canal.CanalWhatsApp;
import core.servico.Servico;
import core.servico.ServicoAnalise;
import core.servico.ServicoBaixa;
import core.servico.ServicoOperacao;
import fastmoney.Cliente;
import fastmoney.ClientePessoaFisica;
import fastmoney.ClientePessoaJuridica;
import fastmoney.ContaCorrente;

/**
 * @author grupo
 *
 */
public class Cenario1 {

	@Test
	public void test() {
		
		Servico servicoOperacao = new ServicoOperacao();
		Servico servicoAnalise = new ServicoAnalise();
		Servico servicoBaixa = new ServicoBaixa();
		
		Canal canalWhatsApp = new CanalWhatsApp();
		Canal canalJMS = new CanalJMS();
		Canal canalSMS = new CanalSMS();
		
		Cliente clienteA = new ClientePessoaFisica("Augusto", "47997123788", "4733289087", "10647077930");
		ContaCorrente contaAA = new ContaCorrente(1, 1);
		ContaCorrente contaAB = new ContaCorrente(1, 2);
		clienteA.addConta(contaAA);
		clienteA.addConta(contaAB);
		
		contaAB.addCanal(canalWhatsApp);
		contaAA.addCanal(canalSMS);
		contaAA.addServico(servicoOperacao);
		contaAA.addServico(servicoAnalise);
		contaAB.addServico(servicoOperacao);
		
		
		Cliente clienteB = new ClientePessoaJuridica("Zubizzarreta", "478896752", "4735434567", "89015683826", "zubi.com");
		ContaCorrente contaBA = new ContaCorrente(2, 1);
		ContaCorrente contaBB = new ContaCorrente(2, 2);
		clienteB.addConta(contaBA);
		clienteB.addConta(contaBB);
		contaBB.addCanal(canalJMS);
		contaBB.addCanal(canalWhatsApp);
		contaBB.addServico(servicoBaixa);
		
		Cliente clienteC = new ClientePessoaFisica("Ronaldinho", "4798755768", "473335876", "4242534637");
		ContaCorrente contaCA = new ContaCorrente(3, 2);
		clienteC.addConta(contaCA);
		
		contaCA.addCanal(canalSMS);
		contaCA.addServico(servicoOperacao);	
		contaCA.addServico(servicoBaixa);
		

		contaAA.depositar(200);
		contaAB.depositar(500);
		
		contaBA.depositar(300);
		contaBB.depositar(700);
		
		contaCA.depositar(20);
		
		
		contaAB.transferir(20, contaCA);
		
		contaAA.sacar(100);
	}

}
