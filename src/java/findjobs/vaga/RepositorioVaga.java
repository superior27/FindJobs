/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.vaga;
import findjobs.Categoria;
import findjobs.ErroInternoException;
import findjobs.Estado;
import java.util.List;
import javax.ejb.Local;


@Local
public interface RepositorioVaga {
    
    public void adicionar(Vaga vaga) throws ErroInternoException;
    public void remover(long codigoVaga) throws ErroInternoException, VagaInexistenteException;
    public Vaga buscar(long codigoVaga) throws ErroInternoException, VagaInexistenteException;
    public void atualizar(Vaga vaga) throws ErroInternoException, VagaInexistenteException;
    public List<Vaga> buscarPorRemuneracao(double remuneracaoVaga) throws ErroInternoException, VagaInexistenteException;
    public List<Vaga> buscarPorCategoria(Categoria categoriaVaga) throws ErroInternoException, VagaInexistenteException;
    public List<Vaga> buscarPorNome(String nomeVaga) throws ErroInternoException, VagaInexistenteException;
    public List<Vaga> buscarPorEstado(Estado estado) throws ErroInternoException, VagaInexistenteException;
    public List<Vaga> buscarPorCidade(String cidade) throws ErroInternoException, VagaInexistenteException;
    public List<Vaga> buscarPorCargoEstado(String nomeVaga , Estado estado) throws ErroInternoException, VagaInexistenteException;
    public List<Vaga> ListarTodasVagas()throws ErroInternoException;
    
}

