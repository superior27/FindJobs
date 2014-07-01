/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.vaga;
import findjobs.Categoria;
import findjobs.Estado;
import findjobs.empresa.Empresa;
import findjobs.perfil.Perfil;
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
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Vaga implements Serializable{
    
    private Categoria categoria;
    private String nomeVaga;
    private int vagasDisponiveis;
    private int horasTrabalho;
    private double remuneracao;
    private String requisitos;
    private long codigoVaga;
    private Empresa empresa;
    private Perfil perfil;
    private Estado estado;
    private String cidade;
    private List<Categoria> listaCategoria;
    private List<Estado> listaEstados;
    
    
    public Vaga(){
    }

    public Vaga(Categoria categoria, String nomeVaga, int vagasDisponiveis, int horasTrabalho, double remuneracao, String requisitos, long codigoVaga, Empresa empresa, Perfil perfil, Estado estado, String cidade, List<Categoria> listaCategoria, List<Estado> listaEstados) {
        this.categoria = categoria;
        this.nomeVaga = nomeVaga;
        this.vagasDisponiveis = vagasDisponiveis;
        this.horasTrabalho = horasTrabalho;
        this.remuneracao = remuneracao;
        this.requisitos = requisitos;
        this.codigoVaga = codigoVaga;
        this.empresa = empresa;
        this.perfil = perfil;
        this.estado = estado;
        this.cidade = cidade;
        this.listaCategoria = listaCategoria;
        this.listaEstados = listaEstados;
    }

    
    
    public void set(Vaga v){
        this.categoria = v.categoria;
        this.nomeVaga = v.nomeVaga;
        this.vagasDisponiveis = v.vagasDisponiveis;
        this.horasTrabalho = v.horasTrabalho;
        this.remuneracao = v.remuneracao;
        this.requisitos = v.requisitos;
        this.cidade=v.cidade;
        
    }

    @Transient
    public List<Categoria> getListaCategoria() {
        return Arrays.asList(Categoria.values());
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    
    @Transient
    public List<Estado> getListaEstados() {
        return Arrays.asList(Estado.values());
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }
    
    
    @Enumerated(EnumType.STRING)
    public Categoria getCategoria() {

        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNomeVaga() {
        return this.nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public int getVagasDisponiveis() {
        return this.vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }


    public int getHorasTrabalho() {
        return this.horasTrabalho;
    }

    public void setHorasTrabalho(int horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }

    public double getRemuneracao() {
        return this.remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public String getRequisitos() {
        return this.requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getCodigoVaga() {
        return this.codigoVaga;
    }

    public void setCodigoVaga(long codigoVaga) {
        this.codigoVaga = codigoVaga;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    

    
    @Enumerated(EnumType.STRING)
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vaga other = (Vaga) obj;
        if (this.categoria != other.categoria) {
            return false;
        }
        if (!Objects.equals(this.nomeVaga, other.nomeVaga)) {
            return false;
        }
        if (this.vagasDisponiveis != other.vagasDisponiveis) {
            return false;
        }
        if (this.horasTrabalho != other.horasTrabalho) {
            return false;
        }
        if (Double.doubleToLongBits(this.remuneracao) != Double.doubleToLongBits(other.remuneracao)) {
            return false;
        }
        if (!Objects.equals(this.requisitos, other.requisitos)) {
            return false;
        }
        if (this.codigoVaga != other.codigoVaga) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.perfil, other.perfil)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }
    

    
    
    

    @Override
    public String toString() {
        return "Vaga{" + "categoria=" + this.getCategoria() + " nomeVaga=" + this.getNomeVaga() + " vagasDisponiveis=" + this.getVagasDisponiveis() +  " horasTrabalho=" + this.getHorasTrabalho() + " remuneracao=" + this.getRemuneracao() + " requisitos=" + this.getRequisitos() + " codigoVaga=" + this.getCodigoVaga() + "Empresa" + this.getEmpresa() + "Perfil"+ this.getPerfil()+"Cidade:"+this.getCidade()+"Estado:"+this.getEstado()+'}';
    }

    
    
}

