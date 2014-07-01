/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.perfil;

/**
 *
 * @author Saara Lima
 */
public class PerfilInexistenteException extends Exception{
    
    public PerfilInexistenteException(){
        super("O perfil nao existe !");
    }
}