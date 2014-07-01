/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.ui;


import findjobs.ErroInternoException;
import findjobs.FindJobsFachada;
import findjobs.perfil.Perfil;
import findjobs.usuario.Usuario;
import findjobs.usuario.UsuarioExistenteException;
import findjobs.usuario.UsuarioInexistenteException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped 
public class ManagedBeanUsuario implements Serializable{
    

    @EJB
    private FindJobsFachada fachada;
    
    
    
    private Usuario usuario;
    private long codigoUsuario;
    private List<Usuario> buscaNomeUsuario;
    private String nomeUsuario;
    private List<Perfil> listaPerfil;
    private String nomeVaga;
    
    public ManagedBeanUsuario(){
        this.usuario = new Usuario();
    }

    public FindJobsFachada getFachada() {
        return fachada;
    }

    public void setFachada(FindJobsFachada fachada) {
        this.fachada = fachada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public List<Usuario> getBuscaNomeUsuario() {
        return buscaNomeUsuario;
    }

    public void setBuscaNomeUsuario(List<Usuario> buscaNomeUsuario) {
        this.buscaNomeUsuario = buscaNomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public List<Perfil> getListaPerfil() {
        return listaPerfil;
    }

    public void setListaPerfil(List<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }
    
    
    
    public String login()throws UsuarioInexistenteException, ErroInternoException {
        try {
            Usuario e = fachada.buscarPorCpf(usuario.getCpf());
            if (e.getSenhaUsuario().equals(usuario.getSenhaUsuario())) {
                this.usuario = e;
                return ("index.xhtml");
            } else {
                this.usuario = new Usuario();
                return ("index.xhtml");
            }
        } catch (UsuarioInexistenteException e) {
            throw new UsuarioInexistenteException();
        } catch (ErroInternoException ex) {
            throw new ErroInternoException(ex);
        }
    }
    
   public String cadastrarUsuario(){
        try{
            this.fachada.adicionar(this.usuario);
            
            this.usuario = new Usuario();
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Usuario Cadastrado com sucesso");
            contexto.addMessage(null, msg);
            
        }
        catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro interno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(UsuarioExistenteException eee){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Existente", "Usuario já existe");
            contexto.addMessage(null, msg);         
        }
        return null;
    }
    
    
     public String atualizarUsuario() {
        try {
            this.fachada.atualizar(this.usuario);
            this.usuario = new Usuario();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso: ", "Usuario Atualizado.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro interno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(UsuarioInexistenteException uie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Inexistente", "Usuario não existe");
            contexto.addMessage(null, msg);         
        }

        return null;
    }

    public String removerUsuario()  {
        try{
        this.fachada.removerUsuario(this.usuario.getCodigoUsuario());
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Usuario removido com sucesso");
        contexto.addMessage(null, msg);
          
        }catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro interno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(UsuarioInexistenteException uie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Inexistente", "Usuario não existe");
            contexto.addMessage(null, msg);         
        }
        return null;
    }
        
        public String buscarUsuario(){
        try {
            Usuario u = this.fachada.buscarUsuario(this.usuario.getCodigoUsuario());
            this.usuario = u;
         
          this.fachada.buscarUsuario(this.codigoUsuario);
        } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(UsuarioInexistenteException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Inexistente", "Usuario não existe");
            contexto.addMessage(null, msg);         
        }      
        return null;              
    }
        
        public String buscarPorCpf() {
        try {
            Usuario u2 = this.fachada.buscarPorCpf(this.usuario.getCpf());
            this.usuario = u2; 
            
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(UsuarioInexistenteException uie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
        
    }
    
        
        public String buscarPorNome() {
        try {
                this.buscaNomeUsuario = this.fachada.buscarUsuarioPorNome(this.nomeUsuario);
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(UsuarioInexistenteException uie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário Inexistente", "Usuário não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
        
       }
        
       /* public String buscarPorVaga(){
                try {
                    this.listaPerfil = this.fachada.buscarPerfil(this.);
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }
        return null;
                
            }*/
} 

    


