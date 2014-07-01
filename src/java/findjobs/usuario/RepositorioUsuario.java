/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.usuario;

import findjobs.ErroInternoException;
import findjobs.perfil.Perfil;
import java.util.List;
import javax.ejb.Local;


@Local
public interface RepositorioUsuario {
    
    public void adicionar(Usuario usuario) throws ErroInternoException;
    public void remover(long codigoUsuario) throws ErroInternoException, UsuarioInexistenteException;
    public Usuario buscar(long codigoUsuario) throws ErroInternoException, UsuarioInexistenteException;
    public void atualizar(Usuario usuario) throws ErroInternoException, UsuarioInexistenteException;
    public Usuario buscarPorCpf(String cpf) throws ErroInternoException, UsuarioInexistenteException;
    public List<Usuario> buscarPorNome(String nomeUsuario) throws ErroInternoException, UsuarioInexistenteException;
    public List<Usuario> buscarPerfil(Perfil perfil) throws ErroInternoException;
    public List<Usuario> ListarTodosUsuarios()throws ErroInternoException;

}
