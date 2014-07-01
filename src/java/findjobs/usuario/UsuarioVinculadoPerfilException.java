/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package findjobs.usuario;

/**
 *
 * @author Halana Rebeca
 */
public class UsuarioVinculadoPerfilException extends Exception{
    
    public UsuarioVinculadoPerfilException(){
        super("Esse usuário está vinculado a um perfil!");
    }
    
}
