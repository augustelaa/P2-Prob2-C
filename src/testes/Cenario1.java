package testes;

import org.junit.Test;

import fastmoney.Cliente;
import fastmoney.ClientePessoaFisica;
import fastmoney.ClientePessoaJuridica;
import fastmoney.ContaCorrente;

public class Cenario1 {

	@Test
	public void test() {
		Cliente clienteA = new ClientePessoaFisica("Augusto", "47997123788", "4733289087", "10647077930");
		ContaCorrente contaAA = new ContaCorrente(1, 1);
		ContaCorrente contaAB = new ContaCorrente(1, 2);
		clienteA.addConta(contaAA);
		clienteA.addConta(contaAB);
		
		
		Cliente clienteB = new ClientePessoaJuridica("Zubizzarreta", "478896752", "4735434567", "89015683826", "zubi.com");
		ContaCorrente contaBA = new ContaCorrente(2, 1);
		ContaCorrente contaBB = new ContaCorrente(2, 2);
		clienteB.addConta(contaBA);
		clienteB.addConta(contaBB);
		
		Cliente clienteC = new ClientePessoaFisica("Ronaldinho", "4798755768", "473335876", "4242534637");
		ContaCorrente contaCA = new ContaCorrente(3, 2);
		clienteC.addConta(contaCA);
		
		
		ContaCorrente contaXA = new ContaCorrente(3, 2);

		contaAA.depositar(200);
		contaAB.depositar(500);
		
		contaBA.depositar(300);
		contaBB.depositar(700);
		
		contaCA.depositar(20);
		
		contaXA.depositar(320);
		
		contaAB.transferir(20, contaCA);
		
		contaAA.sacar(100);
	}

}
