/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.perfil;

import findjobs.ErroInternoException;
import findjobs.usuario.Usuario;
import findjobs.vaga.Vaga;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class RepositorioPerfilJPA implements RepositorioPerfil{
    
    @PersistenceContext
    private EntityManager em;
    
    public RepositorioPerfilJPA(){
        this.em = Persistence.createEntityManagerFactory("FindJobsUP").createEntityManager();
    }

    @Override
    public void adicionar(Perfil perfil) throws ErroInternoException {
        
        try{
            
        this.em.persist(perfil);
        
        }catch(Exception ex){
            
        throw new ErroInternoException(ex);
    }
    }

    
    public void remover(long codigoPerfil) throws PerfilInexistenteException, ErroInternoException {
        
        
            Perfil e = buscar (codigoPerfil);
            try{
               this.em.remove(e); 
            }catch(Exception ex){
                throw new ErroInternoException(ex); 
            }
            
    }

    @Override
    public void atualizar(Perfil perfil) throws PerfilInexistenteException, ErroInternoException {
        buscar (perfil.getCodigoPerfil());
        try{
            
            this.em.merge(perfil);
            
        }catch(Exception ex){
            throw new ErroInternoException(ex);
        }
    }

    @Override
    public Perfil buscar(long codigoPerfil) throws PerfilInexistenteException, ErroInternoException {
                
        try{
            Perfil p = this.em.find(Perfil.class, codigoPerfil);
            if(p==null){
                throw new PerfilInexistenteException();
            }
            
            return p;
            
        }        
        catch(IllegalArgumentException ex){
            throw new ErroInternoException(ex);
            
        }
    }
    
        public List<Perfil> buscarVagas(Vaga vaga) throws ErroInternoException{
            try{
            TypedQuery <Perfil> buscarVagas = this.em.createQuery("select perfil from Perfil perfil where perfil.vaga=:vaga", Perfil.class);
            buscarVagas.setParameter("vaga", vaga);
            return buscarVagas.getResultList(); 
        }
        
        catch(Exception e){
        throw new ErroInternoException(e);
        }
            
        }

    public Perfil buscarUsuario(Usuario usuario) throws ErroInternoException{
        try{
            TypedQuery <Perfil> buscarUsuario = this.em.createQuery("select perfil from Perfil perfil where perfil.usuario=:usuario", Perfil.class);
            buscarUsuario.setParameter("usuario", usuario);
            return buscarUsuario.getSingleResult(); 
        }
        
        catch(Exception e){
        throw new ErroInternoException(e);
        }
            
        
    }

    
    
}
