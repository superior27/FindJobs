/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.usuario;

/**
 *
 * @author Saara Lima
 */
public class UsuarioInexistenteException extends Exception {
    
    public UsuarioInexistenteException(){
        super("O usuario nao existe !");
    }
}

