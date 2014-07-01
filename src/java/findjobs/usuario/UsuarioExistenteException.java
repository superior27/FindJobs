/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.usuario;

/**
 *
 * @author Saara Lima
 */
public class UsuarioExistenteException extends Exception{
    
    public UsuarioExistenteException(){
        super("O usuario ja axiste !");
    }
    
}
