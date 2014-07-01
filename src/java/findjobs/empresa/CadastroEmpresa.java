/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.empresa;

import findjobs.ErroInternoException;
import findjobs.Estado;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Stateless

public class CadastroEmpresa {
    
    @EJB
    private RepositorioEmpresa empresas;
        

    public CadastroEmpresa(){
        
        
    }
    
    public void adicionar(Empresa empresa) throws ErroInternoException, EmpresaExistenteException{
        
        try{
            Empresa c2 = this.empresas.buscar(empresa.getCodigoEmpresa());
            throw new EmpresaExistenteException();
            
        }catch(EmpresaInexistenteException cie){
            this.empresas.adicionar(empresa);
        }
    }
    public Empresa buscar(long codigoEmpresa) throws ErroInternoException, EmpresaInexistenteException{
        return this.empresas.buscar(codigoEmpresa);
    }
    public void atualizar(Empresa empresa) throws EmpresaInexistenteException, ErroInternoException{
        this.empresas.atualizar(empresa);
    }
    public void remover(long codigoEmpresa) throws EmpresaInexistenteException, ErroInternoException{
        this.empresas.remover(codigoEmpresa);
    }
    public Empresa buscarPorCnpj(String cnpj) throws ErroInternoException, EmpresaInexistenteException{
        return this.empresas.buscarPorCnpj(cnpj);
    }
    public Empresa buscarPorNome(String nomeEmpresa) throws ErroInternoException, EmpresaInexistenteException{
        return this.empresas.buscarPorNome(nomeEmpresa);
    }
    public List<Empresa> buscarPorVaga(String vaga) throws ErroInternoException, EmpresaInexistenteException{
        return this.empresas.buscarPorVaga(vaga);
    }
    public List<Empresa> ListarTodasEmpresas() throws ErroInternoException{
        try{
        return this.empresas.ListarTodasEmpresas();
        }catch (ErroInternoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
            return null;
        }
    }
    /*public List<Empresa> buscarPorEstado (Estado estadoEmpresa) throws ErroInternoException, EmpresaInexistenteException{
        return this.empresas.buscarPorEstado(estadoEmpresa);
    }*/
    public List<Empresa> buscarPorCidade(String cidadeEmpresa) throws ErroInternoException, EmpresaInexistenteException {
        return this.empresas.buscarPorCidade(cidadeEmpresa);
    }
    
}

