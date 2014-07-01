/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.perfil;

import findjobs.Categoria;
import findjobs.usuario.Usuario;
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


@Entity
@Table
public class Perfil implements Serializable{
    
    private Categoria categoria;
    private int horasTrabalho;
    private double remuneracao;
    private long codigoPerfil;
    private List<Vaga> vagas;
    private Vaga vaga;
    private Perfil perfil;
    private Usuario usuario;
    private List<Categoria> listaCategoria;
     
    
    public Perfil(){
    }

    public Perfil(Categoria categoria, int horasTrabalho, double remuneracao, long codigoPerfil, String nomeUsuario, String cpf, String enderecoUsuario, String telefoneUsuario, long codigoUsuario, List<Vaga> vagas, Vaga vaga, Perfil perfil, Usuario usuario) {
        this.categoria = categoria;
        this.horasTrabalho = horasTrabalho;
        this.remuneracao = remuneracao;
        this.codigoPerfil = codigoPerfil;
        this.vagas = vagas;
        this.vaga=vaga;
        this.perfil=perfil;
        this.usuario=usuario;
    }
    
    public void set(Perfil p){
        this.categoria = p.categoria;
        this.horasTrabalho = p.horasTrabalho;
        this.remuneracao = p.remuneracao;
        this.vagas = p.vagas;
        this.vaga=p.vaga;
        this.perfil=p.perfil;
        this.usuario=p.usuario;
        
    }
    
    @Transient
    public List<Categoria> getListaCategoria() {
        return Arrays.asList(Categoria.values());
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

   @Enumerated(EnumType.STRING)
    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getCodigoPerfil() {
        return this.codigoPerfil;
    }

    public void setCodigoPerfil(long codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }
    @OneToMany
    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Perfil other = (Perfil) obj;
        if (this.categoria != other.categoria) {
            return false;
        }
        if (this.horasTrabalho != other.horasTrabalho) {
            return false;
        }
        if (Double.doubleToLongBits(this.remuneracao) != Double.doubleToLongBits(other.remuneracao)) {
            return false;
        }
        if (this.codigoPerfil != other.codigoPerfil) {
            return false;
        }
        if (!Objects.equals(this.vagas, other.vagas)) {
            return false;
        }
        if (!Objects.equals(this.vaga, other.vaga)) {
            return false;
        }
        if (!Objects.equals(this.perfil, other.perfil)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Perfil{" + "categoria=" + this.getCategoria() +  ", horasTrabalho=" + this.getHorasTrabalho() + ", remuneracao=" + this.getRemuneracao() + ", codigoPerfil=" + this.getCodigoPerfil() + "Vagas:" + this.getVagas()+"Vaga:"+this.getVaga()+"Perfil:"+this.getPerfil()+"Usuario"+this.getUsuario()+'}';
    }
    
    
}

