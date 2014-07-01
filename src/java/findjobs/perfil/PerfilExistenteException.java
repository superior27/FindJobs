/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.perfil;

/**
 *
 * @author Saara Lima
 */
public class PerfilExistenteException extends Exception {
    
    public PerfilExistenteException(){
        super("O perfil ja existe !");
    }
}