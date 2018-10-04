package fastmoney;

import java.util.ArrayList;
import java.util.List;

import core.TipoCanal;

/**
 *
 * @author marcel
 */
public class ClientePessoaJuridica extends Cliente{
    private String cnpj;
    private String servidorJMS;

    public ClientePessoaJuridica(String nome, String telCelular, String telFixo, String cnpj, String servidorJMS) {
        super(nome, telCelular, telFixo);
        this.setCnpj(cnpj);
        this.setServidorJMS(servidorJMS);
    }    
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getServidorJMS() {
        return servidorJMS;
    }

    public void setServidorJMS(String servidorJMS) {
        this.servidorJMS = servidorJMS;
    }
    
    @Override
    public List<TipoCanal> getTiposDisponiveis() {
    	List<TipoCanal> retorno = new ArrayList<TipoCanal>();
    	retorno.add(TipoCanal.SMS);
    	retorno.add(TipoCanal.WHATSAPP);
    	retorno.add(TipoCanal.JMS);
    	return retorno;
    }
    
}
