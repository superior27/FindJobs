
package findjobs.ui;



import findjobs.Categoria;
import findjobs.ErroInternoException;
import findjobs.Estado;
import findjobs.FindJobsFachada;
import findjobs.vaga.Vaga;
import findjobs.vaga.VagaExistenteException;
import findjobs.vaga.VagaInexistenteException;
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
public class ManagedBeanVaga implements Serializable{
    

    @EJB
    private FindJobsFachada fachada;
    
    
    
    private Vaga vaga;
    private long codigoVaga;
    private List<Vaga> listaVagaRemuneracao;
    private double remuneracao;
    private List<Vaga> listaVagaCategoria;
    private Categoria categoria;
    private List<Vaga> listaVagaNome;
    private String nomeVaga;
    private List<Vaga> listaVagaEstado;
    private Estado estado;
    private List<Vaga> listaVagaCidade;
    private String nomeCidade;
    private List<Vaga> listaCargoEstado;
    private String nomeCargo;
    private Estado estado1;
    
    
    public ManagedBeanVaga(){
        this.vaga = new Vaga();
    }

    public FindJobsFachada getFachada() {
        return fachada;
    }

    public void setFachada(FindJobsFachada fachada) {
        this.fachada = fachada;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public long getCodigoVaga() {
        return codigoVaga;
    }

    public void setCodigoVaga(long codigoVaga) {
        this.codigoVaga = codigoVaga;
    }

    public List<Vaga> getListaVagaRemuneracao() {
        return listaVagaRemuneracao;
    }

    public void setListaVagaRemuneracao(List<Vaga> listaVagaRemuneracao) {
        this.listaVagaRemuneracao = listaVagaRemuneracao;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public List<Vaga> getListaVagaCategoria() {
        return listaVagaCategoria;
    }

    public void setListaVagaCategoria(List<Vaga> listaVagaCategoria) {
        this.listaVagaCategoria = listaVagaCategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Vaga> getListaVagaNome() {
        return listaVagaNome;
    }

    public void setListaVagaNome(List<Vaga> listaVagaNome) {
        this.listaVagaNome = listaVagaNome;
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public List<Vaga> getListaVagaEstado() {
        return listaVagaEstado;
    }

    public void setListaVagaEstado(List<Vaga> listaVagaEstado) {
        this.listaVagaEstado = listaVagaEstado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Vaga> getListaVagaCidade() {
        return listaVagaCidade;
    }

    public void setListaVagaCidade(List<Vaga> listaVagaCidade) {
        this.listaVagaCidade = listaVagaCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public List<Vaga> getListaCargoEstado() {
        return listaCargoEstado;
    }

    public void setListaCargoEstado(List<Vaga> listaCargoEstado) {
        this.listaCargoEstado = listaCargoEstado;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Estado getEstado1() {
        return estado1;
    }

    public void setEstado1(Estado estado1) {
        this.estado1 = estado1;
    }
    
    
    
   public String cadastrarVaga(){
        try{
            this.fachada.adicionar(this.vaga);
            this.vaga = new Vaga();
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Vaga Cadastrada com sucesso");
            contexto.addMessage(null, msg);
            
        }
        catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro interno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(VagaExistenteException eee){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vaga Existente", "Vaga já existe");
            contexto.addMessage(null, msg);         
        }
        return null;
    }
    
     public String atualizarVaga() {
        try {
            this.fachada.atualizar(this.vaga);
            this.vaga = new Vaga();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso: ", "Vaga Atualizado.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vaga Inexistente", "Vaga não existe");
            contexto.addMessage(null, msg);         
        }

        return null;
    }

    public String removerVaga()  {
        try{
        this.fachada.removerVaga(this.vaga.getCodigoVaga());   
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Vaga removida com sucesso");
            contexto.addMessage(null, msg);
          
        }catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um erro interno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vaga Inexistente", "Vaga não existe");
            contexto.addMessage(null, msg);         
        }
        return null;
    }
        
        public String buscarVaga(){
        try {
          Vaga v = this.fachada.buscarVaga(this.vaga.getCodigoVaga());
            this.vaga = v;
        } catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
        }
        catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vaga Inexistente", "Vaga não existe");
            contexto.addMessage(null, msg);         
        }      
        return null;              
    }
        
        public String buscarPorRemuneracao() {
        try {
             this.listaVagaRemuneracao = this.fachada.buscarPorRemuneracao(this.remuneracao);
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vaga Inexistente", "Vaga não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
        
    }
        
        public String buscarPorCategoria() {
        try {
                this.listaVagaCategoria = this.fachada.buscarPorCategoria(this.categoria);
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vaga Inexistente", "Vaga não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
        
    }
        
        public String buscarPorNome() {
        try {
            this.listaVagaNome = this.fachada.buscarPorNomeVaga(this.nomeVaga);
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vaga Inexistente", "Vaga não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
        
    }
        
        public String buscarPorEstado() {
        try {
            this.listaVagaEstado = this.fachada.buscarPorEstado(this.estado);
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
        
    }
        
        
        public String buscarPorCidade() {
        try {
            this.listaVagaCidade = this.fachada.buscarPorCidade(this.nomeCidade);
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
        
    }
        
    public String buscarPorCargoEstado() {
            
        try {
            this.listaCargoEstado = this.fachada.buscarPorCargoEstado(this.nomeVaga, this.estado);
        } catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
        }catch(VagaInexistenteException vie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Inexistente", "Empresa não existe");
            contexto.addMessage(null, msg);         
        } 
            return null;
            }

    
} 

    






    


