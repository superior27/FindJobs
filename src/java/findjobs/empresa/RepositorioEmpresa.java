/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.empresa;

import findjobs.ErroInternoException;
import findjobs.Estado;
import java.util.List;
import javax.ejb.Local;


@Local
public interface RepositorioEmpresa {
    
    public void adicionar(Empresa empresa) throws ErroInternoException;
    public void remover(long codigoEmpresa) throws ErroInternoException, EmpresaInexistenteException;
    public Empresa buscar(long codigoEmpresa) throws ErroInternoException, EmpresaInexistenteException;
    public void atualizar(Empresa empresa) throws ErroInternoException, EmpresaInexistenteException;
    public Empresa buscarPorCnpj(String cnpj) throws ErroInternoException, EmpresaInexistenteException;
    public Empresa buscarPorNome(String nomeEmpresa) throws ErroInternoException, EmpresaInexistenteException;
    public List<Empresa> buscarPorVaga(String cargoOfertado) throws ErroInternoException, EmpresaInexistenteException;
   // public List<Empresa> buscarPorEstado (Estado estadoEmpresa) throws ErroInternoException, EmpresaInexistenteException;
    public List<Empresa> buscarPorCidade (String cidadeEmpresa) throws ErroInternoException, EmpresaInexistenteException;
    public List<Empresa> ListarTodasEmpresas()throws ErroInternoException;
    
    
}
