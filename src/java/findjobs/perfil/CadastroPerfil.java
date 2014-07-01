/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.perfil;
import findjobs.ErroInternoException;
import findjobs.usuario.RepositorioUsuario;
import findjobs.usuario.Usuario;
import findjobs.vaga.Vaga;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class CadastroPerfil {
    
    @EJB
    private RepositorioPerfil perfis;
    
    @EJB
    private RepositorioUsuario usuarios;
        

    public CadastroPerfil(){
    }
    
    
    public void adicionar(Perfil perfil) throws ErroInternoException, PerfilExistenteException{
        
        try{
            Perfil c2 = this.perfis.buscar(perfil.getCodigoPerfil());
            throw new PerfilExistenteException();
            
        }catch(PerfilInexistenteException cie){
            this.perfis.adicionar(perfil);
        }
    }
    public Perfil buscar(long codigoPerfil) throws ErroInternoException, PerfilInexistenteException{
        return this.perfis.buscar(codigoPerfil);
    }
    public void atualizar(Perfil perfil) throws PerfilInexistenteException, ErroInternoException{
        this.perfis.atualizar(perfil);
    }
    public void remover(long codigoPerfil) throws PerfilInexistenteException, ErroInternoException{
        this.perfis.remover(codigoPerfil);
        
         Perfil perfil = this.perfis.buscar(codigoPerfil);
        List<Usuario> lista = this.usuarios.buscarPerfil(perfil);
         if(lista.isEmpty())
         {
          this.perfis.remover(codigoPerfil);
            
            }
    }
    
    public List<Perfil> buscarVagas(Vaga vaga) throws ErroInternoException{
    
        return this.perfis.buscarVagas(vaga);
    
    }
    
    public Perfil buscarUsuario(Usuario usuario) throws ErroInternoException{
        return this.perfis.buscarUsuario(usuario);

    }


    
}

