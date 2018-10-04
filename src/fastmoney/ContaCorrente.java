package fastmoney;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.Servico;
import core.TipoCanal;

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
    private List<TipoCanal> canais;

    public ContaCorrente(int numero, int agencia) {
        this.setNumero(numero);
        this.setAgencia(agencia);
        this.servicos = new ArrayList<Servico>();
        this.canais = new ArrayList<TipoCanal>();
    }

    public String getChave(){
        return String.valueOf(agencia)+"-"+String.valueOf(numero);
    }
    
    public void addServico(Servico ss) {
    	if (canais.isEmpty()) {
    		throw new IllegalArgumentException("Nenhum canal foi definido para os serviços.");
    	}
    	servicos.add(ss);
    }
    
    public void addCanal(TipoCanal canal) {
    	if (!getCliente().getTiposDisponiveis().contains(canal)) {
    		throw new IllegalArgumentException("Canal não disponível para o cliente.");
    	}
    	canais.add(canal);
    }
    
    public void sacar(double valor){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this);
        operacoes.add(oper);
        this.saldo -= valor;
        executaServicos("Cliente "+getCliente().getNome()+", Conta "+getNumero()+ "-" +getAgencia()+", Saque de " + valor);
    }
    
    private void executaServicos(String mensagem) {
    	for (Servico servico : servicos) {
    		for (TipoCanal canal: canais) {
    			servico.disparar(canal, mensagem);
    		}
        }
    }
    
    public void depositar(double valor){
        Operacao oper = new Operacao(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this);
        operacoes.add(oper);
        this.saldo += valor;
        executaServicos("Cliente "+getCliente().getNome()+", Conta "+getNumero()+ "-" +getAgencia()+", Deposito de " + valor);
    }    
    
    public void transferir(double valor, ContaCorrente destino){
        if (valor > this.getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para transferÃªncia");
        }        
        destino.receberTransferencia(valor, this);
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.SAIDA,new Date(),this,destino);
        operacoes.add(oper);
        this.saldo -= valor;
        executaServicos("Cliente "+getCliente().getNome()+", Conta "+getNumero()+ "-" +getAgencia()+
        		" para cliente "+destino.getCliente().getNome()+", Conta "+destino.getNumero()+ "-" +destino.getAgencia()+        		
        		", Transferencia de " + valor);
    }   
    
    private void receberTransferencia(double valor, ContaCorrente origem){    
        Operacao oper = new OperacaoTransferencia(valor,this.getSaldo(),TipoOperacao.ENTRADA,new Date(),this,origem);
        operacoes.add(oper);
        this.saldo += valor;
        executaServicos("Cliente "+origem.getCliente().getNome()+", Conta "+origem.getNumero()+ "-" +origem.getAgencia()+
        		" para cliente "+getCliente().getNome()+", Conta "+getNumero()+ "-" +getAgencia()+        		
        		", Recebimento da transferencia de " + valor);
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
    
    @Override
    public String toString(){
        return this.getChave();
    }
}
