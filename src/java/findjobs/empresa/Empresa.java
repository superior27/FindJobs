/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.empresa;

import findjobs.Estado;
import findjobs.vaga.Vaga;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
//import java.lang.String;
//import java.lang.Long;


@Entity
@Table
public class Empresa implements Serializable{
    
    
    private long codigoEmpresa;
    private String nomeEmpresa;
    private String enderecoEmpresa;
    private String telefoneEmpresa;
    private String cnpj;
    private String cargoOfertado;
    private List<Vaga> vaga;
    private Estado estadoEmpresa;
    private String cidadeEmpresa;
    private String senhaEmpresa;
    
    private List<Estado> listaEstados;

    @Transient
    public List<Estado> getListaEstados() {
        return Arrays.asList(Estado.values());
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }
    public Empresa(){
    }

    public Empresa(long codigoEmpresa, String nomeEmpresa, String enderecoEmpresa, String telefoneEmpresa, String cnpj, List<Vaga> vaga, String cargoOfertado, Estado estadoEmpresa, String cidade, String senhaEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.enderecoEmpresa = enderecoEmpresa;
        this.telefoneEmpresa = telefoneEmpresa;
        this.cnpj = cnpj;
        this.vaga = vaga;
        this.cargoOfertado = cargoOfertado;
        this.estadoEmpresa = estadoEmpresa;
        this.cidadeEmpresa = cidadeEmpresa;
        this.senhaEmpresa = senhaEmpresa;
    }
    
    
    public void set(Empresa empresa){
        
        this.nomeEmpresa = empresa.nomeEmpresa;
        this.enderecoEmpresa = empresa.enderecoEmpresa;
        this.telefoneEmpresa = empresa.telefoneEmpresa;
        this.cnpj = empresa.cnpj;
        this.vaga = empresa.vaga;
        this.cargoOfertado = empresa.cargoOfertado;
        this.estadoEmpresa = empresa.estadoEmpresa;
        this.cidadeEmpresa = empresa.cidadeEmpresa;
        this.senhaEmpresa = empresa.senhaEmpresa;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getCodigoEmpresa() {
        return this.codigoEmpresa;
    }

    public void setCodigoEmpresa(long codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }
    
    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEnderecoEmpresa() {
        return this.enderecoEmpresa;
    }

    public void setEnderecoEmpresa(String enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public String getTelefoneEmpresa() {
        return this.telefoneEmpresa;
    }

    public void setTelefoneEmpresa(String telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    @OneToMany
    public List<Vaga> getVaga() {
        return vaga;
    }

    public void setVaga(List<Vaga> vaga) {
        this.vaga = vaga;
    }

    public String getCargoOfertado() {
        return cargoOfertado;
    }

    public void setCargoOfertado(String cargoOfertado) {
        this.cargoOfertado = cargoOfertado;
    }

    @Enumerated(EnumType.STRING)
    public Estado getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(Estado estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    public String getCidadeEmpresa() {
        return cidadeEmpresa;
    }

    public void setCidadeEmpresa(String cidadeEmpresa) {
        this.cidadeEmpresa = cidadeEmpresa;
    }

    public String getSenhaEmpresa() {
        return senhaEmpresa;
    }

    public void setSenhaEmpresa(String senhaEmpresa) {
        this.senhaEmpresa = senhaEmpresa;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (this.codigoEmpresa != other.codigoEmpresa) {
            return false;
        }
        if (!Objects.equals(this.nomeEmpresa, other.nomeEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.enderecoEmpresa, other.enderecoEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.telefoneEmpresa, other.telefoneEmpresa)) {
            return false;
        }
        if (this.cnpj != other.cnpj) {
            return false;
        }
        if (!Objects.equals(this.vaga, other.vaga)) {
            return false;
        }
        if (!Objects.equals(this.cargoOfertado, other.cargoOfertado)) {
            return false;
        }
        if (!Objects.equals(this.estadoEmpresa, other.estadoEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.cidadeEmpresa, other.cidadeEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.senhaEmpresa, other.senhaEmpresa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "codigoEmpresa=" + this.getCodigoEmpresa() + ", nomeEmpresa=" + this.getNomeEmpresa() + ", enderecoEmpresa=" + this.getEnderecoEmpresa() + ", telefoneEmpresa=" + this.getTelefoneEmpresa() + "Vagas:" + this.getVaga()+"Cargo Ofertado:"+this.getCargoOfertado()+"Estado:"+this.getEstadoEmpresa()+"Cidade:"+this.getCidadeEmpresa()+'}';
    }
    
   
    
    
}

