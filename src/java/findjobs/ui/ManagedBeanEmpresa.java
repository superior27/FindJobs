/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findjobs.ui;

import findjobs.ErroInternoException;
import findjobs.FindJobsFachada;
import findjobs.empresa.Empresa;
import findjobs.empresa.EmpresaExistenteException;
import findjobs.empresa.EmpresaInexistenteException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped 
public class ManagedBeanEmpresa implements Serializable{
    

    @EJB
    private FindJobsFachada fachada;
    
    private Empresa empresa;
    //private long codigoEmpresa;
    
    
    private List<Empresa> resultadoBusca;
    private List<Empresa> resultadoBuscaNome;
    
    private String nomeVaga;
    private String nomeEmpresa;

    public ManagedBeanEmpresa(){
        this.empresa = new Empresa();
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    
    
    public List<Empresa> getResultadoBusca() {
        return resultadoBusca;
    }

    public void setResultadoBusca(List<Empresa> resultadoBusca) {
        this.resultadoBusca = resultadoBusca;
    }
    

    
    /*public FindJobsFachada getFachada() {
    return fachada;
    }
    
    public void setFachada(FindJobsFachada fachada) {
    this.fachada = fachada;
    }*/
    
    
        
    public Empresa getEmpresa(){
        return empresa;

    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
    public String buscarCodigo() {
        try {
            Empresa e = this.fachada.buscar(this.empresa.getCodigoEmpresa());
            this.empresa = e;
        }catch(EmpresaInexistenteException ei) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", ei.getMessage()));
        } catch(ErroInternoException ee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Interno", ee.getMessage()));
        }
        return "exibirEmpresa.xhtml";
    }
    
    

    /*public long getCodigoEmpresa() {
    return codigoEmpresa;
    }
    
    public void setCodigoEmpresa(long codigoEmpresa) {
    this.codigoEmpresa = codigoEmpresa;
    }*/
    
    public String login()throws EmpresaInexistenteException, ErroInternoException {
        try {
            Empresa e = fachada.buscarPorCnpj(empresa.getCnpj());
            if (e.getSenhaEmpresa().equals(empresa.getSenhaEmpresa())) {
                this.empresa = e;
                this.empresa = new Empresa();
                
                return "telaInicialEmpresa.xhtml";
              
            } else {
                this.empresa = new Empresa();
                return "index.xhtml";
            }
        } catch (EmpresaInexistenteException e) {
            throw new EmpresaInexistenteException();
        } catch (ErroInternoException ex) {
            throw new ErroInternoException(ex);
        }
    }
    
    public String cadastrarEmpresa(){
        try{
            this.fachada.adicionar(this.empresa);
            this.empresa = new Empresa();

            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Empresa Cadastrado com sucesso");
            contexto.addMessage(null, msg);
            
        }
        catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
            return "index.xhtml";
        }
        catch(EmpresaExistenteException eee){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Existente", "Empresa já existe");
            contexto.addMessage(null, msg); 
            return "index.xhtml";
        }
        return "sucessoCadastrar.xhtml";
    }
    
    
    
    
    
    
    
     public String atualizarEmpresa() {
        try {
            this.fachada.atualizar(this.empresa);
             
            this.empresa = new Empresa();

           
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok! ", "Empresa Atualizada.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
            return "telaInicialEmpresa.xhtml";
        }
        catch(EmpresaInexistenteException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg);
            return "telaInicialEmpresa.xhtml";
        }

        return "sucessoAtualizar.xhtml";
    }

    public String removerEmpresa()  {
        try{
        this.fachada.remover(this.empresa.getCodigoEmpresa());
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Empresa removida com sucesso");
            contexto.addMessage(null, msg);
          
        }catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
            return "telaInicialEmpresa.xhtml";
        }
        catch(EmpresaInexistenteException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg); 
         return "telaInicialEmpresa.xhtml";

        }
        return "sucessoRemover.xhtml";
    }
        
    /*public String buscarEmpresa(){
    try {
    
    this.fachada.buscar(this.empresa.getCodigoEmpresa());
    FacesContext contexto = FacesContext.getCurrentInstance();
    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Entrada! " );
    contexto.addMessage(null, msg);
    } catch(ErroInternoException eie){
    FacesContext contexto = FacesContext.getCurrentInstance();
    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro inesperado! " + eie.getMessage());
    contexto.addMessage(null, msg);
    }
    catch(EmpresaInexistenteException eie){
    FacesContext contexto = FacesContext.getCurrentInstance();
    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
    contexto.addMessage(null, msg);
    }
    return null;
    }*/
        
        
        
    /*public Empresa getBuscarEmpresa()throws ErroInternoException, EmpresaInexistenteException {
    try {
    
    return this.fachada.buscar(this.empresa.getCodigoEmpresa());
    } catch (ErroInternoException ex) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
    }
    return null;
    }*/
       
        public String buscarPorCnpj() {
        try {
            Empresa e2 = this.fachada.buscarPorCnpj(this.empresa.getCnpj());
            this.empresa = e2; 
          } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(EmpresaInexistenteException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg);         
        } 
        return "telaEmpresaExibirBuscarCnpj.xhtml";        
    }
        
        public String buscarPorCnpj2() {
        try {
            Empresa e4 = this.fachada.buscarPorCnpj(this.empresa.getCnpj());
            this.empresa = e4; 
          } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(EmpresaInexistenteException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg);         
        } 
        return "telaEmpresaAtualizar2.xhtml";        
    }
        
        /*public List<Empresa> buscarPorVaga() {
        try {
        return this.fachada.buscarPorVaga(this.empresa.getCargoOfertado());
        } catch (ErroInternoException ex) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(EmpresaInexistenteException eie){
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
        contexto.addMessage(null, msg);
        }
        return null;
        
        }*/
        public String buscarVaga(){
        try {
            this.resultadoBusca = this.fachada.buscarPorVaga(this.nomeVaga);
        } catch (ErroInternoException ex) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Interno", ex.getMessage()));
        } catch (EmpresaInexistenteException ex) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", ex.getMessage()));
        }
        return null;
    }
        
        
        public String buscarPorNome() {
        try {
                Empresa e3 = this.fachada.buscarPorNome(this.empresa.getNomeEmpresa());
                this.empresa = e3;         
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(EmpresaInexistenteException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
        
    }
    


    
} 

    


