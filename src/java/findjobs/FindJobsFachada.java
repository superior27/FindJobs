/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findjobs;

import findjobs.ErroInternoException;
import findjobs.empresa.CadastroEmpresa;
import findjobs.empresa.Empresa;
import findjobs.empresa.EmpresaExistenteException;
import findjobs.empresa.EmpresaInexistenteException;
import findjobs.perfil.CadastroPerfil;
import findjobs.perfil.Perfil;
import findjobs.perfil.PerfilExistenteException;
import findjobs.perfil.PerfilInexistenteException;
import findjobs.usuario.CadastroUsuario;
import findjobs.usuario.Usuario;
import findjobs.usuario.UsuarioExistenteException;
import findjobs.usuario.UsuarioInexistenteException;
import findjobs.vaga.CadastroVaga;
import findjobs.vaga.Vaga;
import findjobs.vaga.VagaExistenteException;
import findjobs.vaga.VagaInexistenteException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class FindJobsFachada {
    
    @EJB
    private CadastroEmpresa empresas;
    
    @EJB
    private CadastroPerfil perfis;
    
    @EJB
    private CadastroUsuario usuarios;
    
    @EJB
    private CadastroVaga vagas;
    
    


   
    
    public FindJobsFachada(){
}
    
    
//EMPRESA
    public void adicionar(Empresa empresa) throws ErroInternoException, EmpresaExistenteException{
        this.empresas.adicionar(empresa);
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
    public List<Empresa> ListarTodasEmpresas()throws ErroInternoException{
        return this.empresas.ListarTodasEmpresas();
    }
    
//EMPRESA
    
    
//PERFIL   
    public void adicionar(Perfil perfil) throws ErroInternoException, PerfilExistenteException{
        this.perfis.adicionar(perfil);
    }
    public void atualizar(Perfil perfil) throws PerfilInexistenteException, ErroInternoException {
        this.perfis.atualizar(perfil);
    }
    public Perfil buscarPerfil(long codigoPerfil) throws PerfilInexistenteException, ErroInternoException {
        return this.perfis.buscar(codigoPerfil);
    }
    public void removerPerfil(long codigoPerfil) throws PerfilInexistenteException, ErroInternoException{
        this.perfis.remover(codigoPerfil);
    }
    public List<Perfil> buscarVagas(Vaga vaga) throws ErroInternoException{
    
        return this.perfis.buscarVagas(vaga);
    
    }
    public Perfil buscarUsuario(Usuario usuario) throws ErroInternoException{
        return this.perfis.buscarUsuario(usuario);
    }
    
//PERFIL
    
    
//USUARIO  
    public void adicionar(Usuario usuario) throws ErroInternoException, UsuarioExistenteException{
        this.usuarios.adicionar(usuario);
    }
    public Usuario buscarUsuario(long codigoUsuario) throws ErroInternoException, UsuarioInexistenteException{
        return this.usuarios.buscar(codigoUsuario);
    }
    
    public void atualizar(Usuario usuario) throws UsuarioInexistenteException, ErroInternoException{
        this.usuarios.atualizar(usuario);
    }
    public void removerUsuario(long codigoUsuario) throws UsuarioInexistenteException, ErroInternoException{
        this.usuarios.remover(codigoUsuario);
    }
    public Usuario buscarPorCpf(String cpf) throws ErroInternoException, UsuarioInexistenteException{
        return this.usuarios.buscarPorCpf(cpf);
    }
    public List<Usuario> buscarUsuarioPorNome(String nomeUsuario) throws ErroInternoException, UsuarioInexistenteException{
        return this.usuarios.buscarPorNome(nomeUsuario);
    }
    
    public List<Usuario> buscarPerfil(Perfil perfil) throws ErroInternoException{
        
        return this.usuarios.buscarPerfil(perfil);       
    }
    public List<Usuario> ListarTodosUsuarios()throws ErroInternoException{
        return this.usuarios.ListarTodosUsuarios();
    }
//USUARIO
    
    
//VAGA   
    public void adicionar(Vaga vaga) throws ErroInternoException, VagaExistenteException{
        this.vagas.adicionar(vaga);
    }
    public void atualizar(Vaga vaga) throws VagaInexistenteException, ErroInternoException{
        this.vagas.atualizar(vaga);
    }
    public void removerVaga(long codigoVaga) throws VagaInexistenteException, ErroInternoException{ 
        this.vagas.remover(codigoVaga);
    }
    public Vaga buscarVaga(long codigoVaga) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscar(codigoVaga);
    }
    public List<Vaga> buscarPorRemuneracao(double remuneracaoVaga) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscarPorRemuneracao(remuneracaoVaga);
    }
    public List<Vaga> buscarPorCategoria(Categoria categoriaVaga) throws ErroInternoException, VagaInexistenteException{
        return this.vagas.buscarPorCategoria(categoriaVaga);
    }
    public List<Vaga> buscarPorNomeVaga(String nomeVaga) throws ErroInternoException, VagaInexistenteException{
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

//VAGA    
      
    
    
}


