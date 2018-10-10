package fastmoney;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.TipoServico;
import core.canal.Canal;
import core.servico.Servico;

/*
 * Esta classe oferece as funcionalidades bÃ¡sicas para atender ao Problema 2.
 */

/**
 *
 * @author marcel
 */
public class ContaCorrente {
    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo = 0;
    private List<Operacao> operacoes = new ArrayList<Operacao>();
    private List<Servico> servicos;
    private List<Canal> canais;

    public ContaCorrente(int numero, int agencia) {
        this.setNumero(numero);
        this.setAgencia(agencia);
        this.servicos = new ArrayList<Servico>();
        this.canais = new ArrayList<Canal>();
    }

    public String getChave(){
        return String.valueOf(agencia)+"-"+String.valueOf(numero);
    }
    
    public void addServico(Servico ss) {
    	if (canais.isEmpty() && ss.getTipo().equals(TipoServico.NOTIFICACAO)) {
    		throw new IllegalArgumentException("Nenhum canal foi definido para o serviço de notificação.");
    	}
    	servicos.add(ss);
    }
    
    public void removeServico(Servico ss) {
    	if (servicos.contains(ss)) {
    		servicos.remove(ss);
    	} else {
    		throw new IllegalArgumentException("Serviço não encontrado.");
    	}
    }
    
    public void addCanal(Canal canal) {
    	if (!getCliente().getTiposDisponiveis().contains(canal.getTipo())) {
    		throw new IllegalArgumentException("Canal não disponível para o cliente.");
    	}
    	canais.add(canal);
    }
    
    public void removeCanal(Canal canal) {
    	if (canais.contains(canal)) {
    		canais.remove(canal);
    	} else {
    		throw new IllegalArgumentException("Canal não encontrado.");
    	}
    }
    
    public void sacar(double valor){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this);
        operacoes.add(oper);
        this.saldo -= valor;
        executaServicos();
    }
    
    public Operacao getUltimaOperacao() {
    	return operacoes.get(operacoes.size()-1);
    }
    
    private void executaServicos() {
    	for (Servico servico : servicos) {
			servico.disparar(this);
        }
    }
    
    public void depositar(double valor){
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this);
        operacoes.add(oper);
        this.saldo += valor;
        executaServicos();
    }    
    
    public void transferir(double valor, ContaCorrente destino){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }        
        destino.receberTransferencia(valor, this);
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this,destino);
        operacoes.add(oper);
        this.saldo -= valor;
        executaServicos();
    }   
    
    private void receberTransferencia(double valor, ContaCorrente origem){    
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this,origem);
        operacoes.add(oper);
        this.saldo += valor;
        executaServicos();
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public List<Canal> getCanais() {
		return canais;
	}

	@Override
    public String toString(){
        return this.getChave();
    }
}
