/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.usuario;
import findjobs.ErroInternoException;
import findjobs.perfil.Perfil;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless

public class CadastroUsuario {
    
    @EJB
    private RepositorioUsuario usuarios;
        

    public CadastroUsuario(){
    }
    
    public void adicionar(Usuario usuario) throws ErroInternoException, UsuarioExistenteException{
        try{
            Usuario u2 = this.usuarios.buscarPorCpf(usuario.getCpf());
            throw new UsuarioExistenteException();
            
        }catch(UsuarioInexistenteException cie){
            this.usuarios.adicionar(usuario);
        }
    }
    public Usuario buscar(long codigoUsuario) throws ErroInternoException, UsuarioInexistenteException{
        return this.usuarios.buscar(codigoUsuario);
    }
    public void atualizar(Usuario usuario) throws UsuarioInexistenteException, ErroInternoException{
        this.usuarios.atualizar(usuario);
    }
    public void remover(long codigoUsuario) throws UsuarioInexistenteException, ErroInternoException{ 
        this.usuarios.remover(codigoUsuario);
    }
    public Usuario buscarPorCpf(String cpf) throws ErroInternoException, UsuarioInexistenteException{
        return this.usuarios.buscarPorCpf(cpf);
    }
    public List<Usuario> buscarPorNome(String nomeUsuario) throws ErroInternoException, UsuarioInexistenteException{
        return this.usuarios.buscarPorNome(nomeUsuario);
    }
    
    public List<Usuario> buscarPerfil(Perfil perfil) throws ErroInternoException{
        
        return this.usuarios.buscarPerfil(perfil);
                
    }
    public List<Usuario> ListarTodosUsuarios()throws ErroInternoException{
        return this.usuarios.ListarTodosUsuarios();
    }
    
}


