/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.vaga;
import findjobs.Categoria;
import findjobs.ErroInternoException;
import findjobs.Estado;
import findjobs.usuario.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



@Stateless
public class RepositorioVagaJPA implements RepositorioVaga{

    @PersistenceContext
    private EntityManager em;
    
    public RepositorioVagaJPA(){
        this.em = Persistence.createEntityManagerFactory("FindJobsUP").createEntityManager();
    }

    @Override
    public void adicionar(Vaga vaga) throws ErroInternoException {
        
        try{
            
        this.em.persist(vaga);
        
        }catch(Exception ex){
            
        throw new ErroInternoException(ex);
    }
    }

    
    public void remover(long codigoVaga) throws VagaInexistenteException, ErroInternoException {
        
        
            Vaga e = buscar (codigoVaga);
            try{
               this.em.remove(e); 
            }catch(Exception ex){
                throw new ErroInternoException(ex); 
            }
            
    }

    @Override
    public void atualizar(Vaga vaga) throws VagaInexistenteException, ErroInternoException {
        buscar (vaga.getCodigoVaga());
        try{
            
            this.em.merge(vaga);
            
        }catch(Exception ex){
            throw new ErroInternoException(ex);
        }
    }

    @Override
    public Vaga buscar(long codigoVaga) throws VagaInexistenteException, ErroInternoException {
              
           try{
            Vaga v = this.em.find(Vaga.class, codigoVaga);
            if(v==null){
                throw new VagaInexistenteException();
            }
            
            return v;
            
        }        
        catch(IllegalArgumentException ex){
            throw new ErroInternoException(ex);
            
        }
    }

    @Override
    public List<Vaga> buscarPorRemuneracao(double remuneracaoVaga) throws ErroInternoException, VagaInexistenteException {
        try{
            TypedQuery <Vaga> buscarRemuneracao = this.em.createQuery("select vaga from Vaga vaga where vaga.remuneracaoVaga=:remuneracaoVaga", Vaga.class);
            buscarRemuneracao.setParameter("remuneracaoVaga", remuneracaoVaga);
            return buscarRemuneracao.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new VagaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
    
    public List<Vaga> buscarPorCategoria(Categoria categoriaVaga) throws ErroInternoException, VagaInexistenteException{
        try{
            TypedQuery <Vaga> buscarPorCategoria = this.em.createQuery("select vaga from Vaga vaga where vaga.categoriaVaga=:categoriaVaga", Vaga.class);
            buscarPorCategoria.setParameter("categoriaVaga", categoriaVaga);
            return buscarPorCategoria.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new VagaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
    
    public List<Vaga> buscarPorNome(String nomeVaga) throws ErroInternoException, VagaInexistenteException{
        try{
            TypedQuery <Vaga> buscarPorNome = this.em.createQuery("select vaga from Vaga vaga where vaga.nomeVaga=:nomeVaga", Vaga.class);
            buscarPorNome.setParameter("nomeVaga", nomeVaga);
            return buscarPorNome.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new VagaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
    
    public List<Vaga> buscarPorEstado(Estado estado) throws ErroInternoException, VagaInexistenteException{
        try{
            TypedQuery <Vaga> buscarPorEstado = this.em.createQuery("select vaga from Vaga vaga where vaga.estado=:estado", Vaga.class);
            buscarPorEstado.setParameter("estado", estado);
            return buscarPorEstado.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new VagaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
    
    public List<Vaga> buscarPorCidade(String cidade) throws ErroInternoException, VagaInexistenteException{
        try{
            TypedQuery <Vaga> buscarPorCidade = this.em.createQuery("select vaga from Vaga vaga where vaga.cidade=:cidade", Vaga.class);
            buscarPorCidade.setParameter("cidade", cidade);
            return buscarPorCidade.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new VagaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
    
    public List<Vaga> buscarPorCargoEstado(String nomeVaga , Estado estado) throws ErroInternoException, VagaInexistenteException{
       try{
            TypedQuery <Vaga> buscarPorCargoEstado = this.em.createQuery("select vaga from Vaga vaga where vaga.nomeVaga=:nomeVaga and vaga.estado=:estado", Vaga.class);
            buscarPorCargoEstado.setParameter("nomeVaga", nomeVaga);
            buscarPorCargoEstado.setParameter("estado", estado);

            return buscarPorCargoEstado.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new VagaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        } 
        
    }
     public List<Vaga> ListarTodasVagas()throws ErroInternoException{
    try {
            TypedQuery<Vaga> consulta = this.em.createQuery("select vaga from Vaga vaga", Vaga.class);
            return consulta.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e);
          }
    }

}

