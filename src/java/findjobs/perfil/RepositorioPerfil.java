/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.perfil;

import findjobs.ErroInternoException;
import findjobs.usuario.Usuario;
import findjobs.vaga.Vaga;
import java.util.List;
import javax.ejb.Local;


@Local
public interface RepositorioPerfil {
    
    public void adicionar(Perfil perfil) throws ErroInternoException;
    public void remover(long codigoPerfil) throws ErroInternoException, PerfilInexistenteException;
    public Perfil buscar(long codigoPerfil) throws ErroInternoException, PerfilInexistenteException;
    public void atualizar(Perfil perfil) throws ErroInternoException, PerfilInexistenteException;
    public List<Perfil> buscarVagas(Vaga vaga) throws ErroInternoException;
    public Perfil buscarUsuario(Usuario usuario) throws ErroInternoException;

    


    
}

