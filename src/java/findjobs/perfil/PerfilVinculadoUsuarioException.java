/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findjobs.perfil;

/**
 *
 * @author Halana Rebeca
 */
public class PerfilVinculadoUsuarioException extends Exception{
    
    public PerfilVinculadoUsuarioException(){
        super("Esse perfil está vinculado ao cadastro de um usuário!");
    }
    
}
