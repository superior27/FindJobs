/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.usuario;
import findjobs.Estado;
import findjobs.Sexo;
import findjobs.perfil.Perfil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Saara Lima
 */
@Entity
@Table
public class Usuario implements Serializable{
    
    private String nomeUsuario;
    private String cpf;
    private String enderecoUsuario;
    private String telefoneUsuario; 
    private long codigoUsuario;
    private Perfil perfil;
    private Date dataNascimento;
    private Sexo sexo;
    private Estado estadoUsuario;
    private String cidadeUsuario;
    private String senhaUsuario;
    
   // private List<Sexo> listaSexo;
    //private List<Estado> listaEstados;

    /*@Transient
    public List<Estado> getListaEstados() {
    return Arrays.asList(Estado.values());
    }
    
    public void setListaEstados(List<Estado> listaEstados) {
    this.listaEstados = listaEstados;
    }
    
    @Transient
    public List<Sexo> getListaSexo() {
    return Arrays.asList(Sexo.values());
    }
    
    public void setListaSexo(List<Sexo> listaSexo) {
    this.listaSexo = listaSexo;
    }*/
    
    
    public Usuario(){
    }

    public Usuario(String nomeUsuario, String cpf, String enderecoUsuario, String telefoneUsuario, long codigoUsuario, Perfil perfil, Date dataNascimento, Sexo sexo, Estado estadoUsuario, String cidadeUsuario, String senhaUsuario/*, List<Sexo> listaSexo, List<Estado> listaEstados*/) {
        this.nomeUsuario = nomeUsuario;
        this.cpf = cpf;
        this.enderecoUsuario = enderecoUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.codigoUsuario = codigoUsuario;
        this.perfil = perfil;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.estadoUsuario = estadoUsuario;
        this.cidadeUsuario = cidadeUsuario;
        this.senhaUsuario = senhaUsuario;
        //this.listaSexo = listaSexo;
       // this.listaEstados = listaEstados;
    }

    
    
    public void set(Usuario u){
        this.nomeUsuario = u.nomeUsuario;
        this.cpf = u.cpf;
        this.enderecoUsuario = u.enderecoUsuario;
        this.telefoneUsuario = u.telefoneUsuario;
        this.dataNascimento = u.dataNascimento;
        this.sexo = u.sexo;
        this.perfil = u.perfil;
        this.cidadeUsuario = u.cidadeUsuario;
        this.estadoUsuario = u.estadoUsuario;
        this.senhaUsuario = u.senhaUsuario;
        
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnderecoUsuario() {
        return this.enderecoUsuario;
    }

    public void setEnderecoUsuario(String enderecoUsuario) {
        this.enderecoUsuario = enderecoUsuario;
    }

    public String getTelefoneUsuario() {
        return this.telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @OneToOne
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    //@Enumerated(EnumType.STRING)
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    
    //@Enumerated(EnumType.STRING)
    public Estado getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Estado estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getCidadeUsuario() {
        return cidadeUsuario;
    }

    public void setCidadeUsuario(String cidadeUsuario) {
        this.cidadeUsuario = cidadeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.enderecoUsuario, other.enderecoUsuario)) {
            return false;
        }
        if (!Objects.equals(this.telefoneUsuario, other.telefoneUsuario)) {
            return false;
        }
        if (this.codigoUsuario != other.codigoUsuario) {
            return false;
        }
        if (!Objects.equals(this.perfil, other.perfil)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.cidadeUsuario, other.cidadeUsuario)) {
            return false;
        }
        if (!Objects.equals(this.estadoUsuario, other.estadoUsuario)) {
            return false;
        }
        if(!Objects.equals(this.senhaUsuario, other.senhaUsuario)){
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Usuario{" + "nomeUsuario=" + this.getNomeUsuario() + ", cpf=" + this.getCpf() + ", enderecoUsuario=" + this.getEnderecoUsuario() + ", telefoneUsuario=" + this.getTelefoneUsuario() + ", codigoUsuario=" + this.getCodigoUsuario() + "Sexo:" + this.getSexo()+"Perfil" + this.getPerfil()+"EstadoUsuario:"+this.getEstadoUsuario()+"CidadeUsuario:"+this.getCidadeUsuario()+ '}';
    }
    
    
        
}

