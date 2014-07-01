/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.ui;

import findjobs.ErroInternoException;
import findjobs.FindJobsFachada;
import findjobs.perfil.Perfil;
import findjobs.perfil.PerfilExistenteException;
import findjobs.perfil.PerfilInexistenteException;
import findjobs.usuario.Usuario;
import findjobs.vaga.Vaga;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Saara Lima
 */
@ManagedBean
@SessionScoped 
public class ManagedBeanPerfil implements Serializable{
    

    @EJB
    private FindJobsFachada fachada;
    
    private Perfil perfil;
    private long codigoPerfil;
    
    private List<Perfil> buscaPerfilVaga;
    private Vaga vaga;
    
    private List<Perfil> buscaPerfilUsuario;

    public ManagedBeanPerfil(){
        this.perfil = new Perfil();
    }

    public FindJobsFachada getFachada() {
        return fachada;
    }

    public void setFachada(FindJobsFachada fachada) {
        this.fachada = fachada;
    }

    public List<Perfil> getBuscaPerfilVaga() {
        return buscaPerfilVaga;
    }

    public void setBuscaPerfilVaga(List<Perfil> buscaPerfilVaga) {
        this.buscaPerfilVaga = buscaPerfilVaga;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    
    public long getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(long codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }
    
    

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public String cadastrarPerfil(){
        try{
            this.fachada.adicionar(this.perfil);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Perfil Cadastrado com sucesso");
            contexto.addMessage(null, msg);
            
        }
        catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(PerfilExistenteException pee){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil Existente", "Perfil já existe");
            contexto.addMessage(null, msg);         
        }
        return null;
    }
    
    
    
    
    
    
    
     public String atualizarPerfil() {
        try {
            this.fachada.atualizar(this.perfil);
            this.perfil = new Perfil();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso: ", "Perfil Atualizado.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(PerfilInexistenteException pie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil Inexistente", "Perfil não existe");
            contexto.addMessage(null, msg);         
        }

        return null;
    }

    public String removerPerfil()  {
        try{
        this.fachada.removerPerfil(this.codigoPerfil);        
          
        }catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(PerfilInexistenteException pie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil Inexistente", "Perfil não existe");
            contexto.addMessage(null, msg);         
        }
        return null;
    }
        
        public String buscarPerfil(){
        try {
         
            Perfil p = this.fachada.buscarPerfil(this.perfil.getCodigoPerfil());
            this.perfil = p; 
        } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno.", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(PerfilInexistenteException pie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Perfil Inexistente.", "Perfil não existe");
            contexto.addMessage(null, msg);         
        }      
        return null;              
    }
    
        public String buscarVagas() throws ErroInternoException{
            
            try {
         
                 this.buscaPerfilVaga=this.fachada.buscarVagas(this.vaga);
            } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        return null;
            
        }
        
        
        public String buscarUsuario() throws ErroInternoException{
            
        try{
         
            Perfil p1 = this.fachada.buscarUsuario(this.perfil.getUsuario());
            this.perfil = p1;         
        } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        return null;
            
        }
} 

    


