/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.empresa;

import findjobs.ErroInternoException;
import findjobs.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Stateless
public class RepositorioEmpresaJPA implements RepositorioEmpresa{

    @PersistenceContext
    private EntityManager em;
    
    public RepositorioEmpresaJPA(){
        this.em = Persistence.createEntityManagerFactory("FindJobsUP").createEntityManager();
    }

    @Override
    public void adicionar(Empresa empresa) throws ErroInternoException {
        try{
            this.em.persist(empresa);
        }
        catch(Exception ex){
            throw new ErroInternoException(ex);
        }
    }
    public void remover(long codigoEmpresa) throws EmpresaInexistenteException, ErroInternoException {
        Empresa e = buscar (codigoEmpresa);
        try{
            this.em.remove(e); 
        }
        catch(Exception ex){
            throw new ErroInternoException(ex); 
        }
    }

    @Override
    public void atualizar(Empresa empresa) throws EmpresaInexistenteException, ErroInternoException {
        buscarPorCnpj(empresa.getCnpj());
        try{
            this.em.merge(empresa);
        }
        catch(Exception ex){
            throw new ErroInternoException(ex);
        }
    }

    @Override
    public Empresa buscar(long codigoEmpresa) throws EmpresaInexistenteException, ErroInternoException {
               
        try{
            Empresa e = this.em.find(Empresa.class, codigoEmpresa);
            if(e==null){
                throw new EmpresaInexistenteException();
            }
            
            return e;
            
        }        
        catch(IllegalArgumentException ex){
            throw new ErroInternoException(ex);
            
        }
    }
    
    public Empresa buscarPorCnpj(String cnpj) throws ErroInternoException, EmpresaInexistenteException{
        try{
            TypedQuery <Empresa> buscarCnpj = this.em.createQuery("SELECT empresa FROM Empresa empresa WHERE empresa.cnpj=:cnpj", Empresa.class);
            buscarCnpj.setParameter("cnpj", cnpj);
            return buscarCnpj.getSingleResult(); //retorna apenas um valor
        }
        catch(NoResultException nre) {
               throw new EmpresaInexistenteException();
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    }
    public Empresa buscarPorNome(String nomeEmpresa) throws ErroInternoException, EmpresaInexistenteException{
        try{
            TypedQuery <Empresa> buscarPorNome = this.em.createQuery("select empresa from Empresa empresa where empresa.nomeEmpresa=:nomeEmpresa", Empresa.class);
            buscarPorNome.setParameter("nomeEmpresa", nomeEmpresa);
            return buscarPorNome.getSingleResult(); //retorna apenas um valor
        }
        catch(NoResultException nre) {
               throw new EmpresaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
    
    public List<Empresa> buscarPorVaga(String cargoOfertado) throws ErroInternoException, EmpresaInexistenteException{
        try{
            TypedQuery <Empresa> buscarPorVaga = this.em.createQuery("select empresa from Empresa empresa where empresa.cargoOfertado=:cargoOfertado", Empresa.class);
            buscarPorVaga.setParameter("cargoOfertado", cargoOfertado);
            return buscarPorVaga.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new EmpresaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
    public List<Empresa> ListarTodasEmpresas()throws ErroInternoException{
        try {
            TypedQuery<Empresa> consulta = this.em.createQuery("select empresa from Empresa empresa", Empresa.class);
            return consulta.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e);
          }
    }

   /* @Override
    public List<Empresa> buscarPorEstado(Estado estadoEmpresa) throws ErroInternoException, EmpresaInexistenteException {
        try{
            TypedQuery <Empresa> buscarPorEstado = this.em.createQuery("select empresa from Empresa empresa where empresa.estadoEmpresa=:estadoEmpresa", Empresa.class);
            buscarPorEstado.setParameter("estadoEmpresa", estadoEmpresa);
            return buscarPorEstado.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new EmpresaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }*/

    @Override
    public List<Empresa> buscarPorCidade(String cidadeEmpresa) throws ErroInternoException, EmpresaInexistenteException {
        try{
            TypedQuery <Empresa> buscarPorCidade = this.em.createQuery("select empresa from Empresa empresa where empresa.cidadeEmpresa=:cidadeEmpresa", Empresa.class);
            buscarPorCidade.setParameter("cidadeEmpresa", cidadeEmpresa);
            return buscarPorCidade.getResultList(); 
        }
        catch(NoResultException nre) {
               throw new EmpresaInexistenteException();
        }
        catch(Exception e){
        throw new ErroInternoException(e);
        }
    }
}


