/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.usuario;
import findjobs.ErroInternoException;
import findjobs.perfil.Perfil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class RepositorioUsuarioJPA implements RepositorioUsuario{

    @PersistenceContext
    private EntityManager em;
    
    public RepositorioUsuarioJPA(){
        this.em = Persistence.createEntityManagerFactory("FindJobsUP").createEntityManager();
    }

    @Override
    public void adicionar(Usuario usuario) throws ErroInternoException {
        
        try{
            
        this.em.persist(usuario);
        
        }catch(Exception ex){
            
        throw new ErroInternoException(ex);
        }
    }
    public void remover(long codigoUsuario) throws UsuarioInexistenteException, ErroInternoException {
            Usuario e = buscar (codigoUsuario);
            try{
               this.em.remove(e); 
            }catch(Exception ex){
                throw new ErroInternoException(ex); 
            }
    }

    @Override
    public void atualizar(Usuario usuario) throws UsuarioInexistenteException, ErroInternoException {
        buscar (usuario.getCodigoUsuario());
        try{
            
            this.em.merge(usuario);
            
        }catch(Exception ex){
            throw new ErroInternoException(ex);
        }
    }

    @Override
    public Usuario buscar(long codigoUsuario) throws UsuarioInexistenteException, ErroInternoException {
        try{
            Usuario c = this.em.find(Usuario.class, codigoUsuario);
            if(c==null){
                throw new UsuarioInexistenteException();
            }
            
            return c;
            
        }        
        catch(IllegalArgumentException ex){
            throw new ErroInternoException(ex);
            
        }
    }

    @Override
    public Usuario buscarPorCpf(String cpf) throws ErroInternoException, UsuarioInexistenteException {
        try{
            TypedQuery <Usuario> buscarCpf = this.em.createQuery("select usuario from Usuario usuario where usuario.cpf=:cpf", Usuario.class);
            buscarCpf.setParameter("cpf", cpf);
            return buscarCpf.getSingleResult(); 
        }
        catch(NoResultException nre) {
               throw new UsuarioInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }

    @Override
    public List<Usuario> buscarPorNome(String nomeUsuario) throws ErroInternoException, UsuarioInexistenteException {
        try{
            TypedQuery <Usuario> buscarNomeUsuario = this.em.createQuery("select usuario from Usuario usuario where usuario.nomeUsuario=:nomeUsuario", Usuario.class);
            buscarNomeUsuario.setParameter("nomeUsuario", nomeUsuario);
            return buscarNomeUsuario.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new UsuarioInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
    
        public List<Usuario> buscarPerfil(Perfil perfil) throws ErroInternoException{
            try{
            TypedQuery <Usuario> buscarPerfil = this.em.createQuery("select usuario from Usuario usuario where usuario.perfil=:perfil", Usuario.class);
            buscarPerfil.setParameter("perfil", perfil);
            return buscarPerfil.getResultList(); 
            
        }
        
        catch(Exception e){
        throw new ErroInternoException(e);
        }
        }
        public List<Usuario> ListarTodosUsuarios()throws ErroInternoException{
        try {
            TypedQuery<Usuario> consulta = this.em.createQuery("select usuario from Usuario usuario", Usuario.class);
            return consulta.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e);
          }
    }
    
}
