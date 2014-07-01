/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.vaga;
import findjobs.Categoria;
import findjobs.ErroInternoException;
import findjobs.Estado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless

public class CadastroVaga {
    
    @EJB
    private RepositorioVaga vagas;
        

    public CadastroVaga(){
        
        
    }

    
    public void adicionar(Vaga vaga) throws ErroInternoException, VagaExistenteException{
        
        try{
            Vaga c2 = this.vagas.buscar(vaga.getCodigoVaga());
            throw new VagaExistenteException();
            
        }catch(VagaInexistenteException cie){
            this.vagas.adicionar(vaga);
            
        }
    }
    
    public Vaga buscar(long codigoVaga) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscar(codigoVaga);
    }
    public void atualizar(Vaga vaga) throws VagaInexistenteException, ErroInternoException{
        this.vagas.atualizar(vaga);
    }
    public void remover(long codigoVaga) throws VagaInexistenteException, ErroInternoException{   
        this.vagas.remover(codigoVaga);
    }
    public List<Vaga> buscarPorRemuneracao(double remuneracaoVaga) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscarPorRemuneracao(remuneracaoVaga);
    }
    public List<Vaga> buscarPorCategoria(Categoria categoriaVaga) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscarPorCategoria(categoriaVaga);
    }
    public List<Vaga> buscarPorNome(String nomeVaga) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscarPorNome(nomeVaga);
    }
    public List<Vaga> buscarPorEstado(Estado estado) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscarPorEstado(estado);
    }
    public List<Vaga> buscarPorCidade(String cidade) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscarPorCidade(cidade);
    }
    
    public List<Vaga> buscarPorCargoEstado(String nomeVaga , Estado estado) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscarPorCargoEstado(nomeVaga, estado);
    }
    public List<Vaga> ListarTodasVagas()throws ErroInternoException{
        return this.vagas.ListarTodasVagas();
    }

    
}


