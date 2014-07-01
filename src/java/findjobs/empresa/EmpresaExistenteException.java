/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.empresa;

/**
 *
 * @author Saara Lima
 */
public class EmpresaExistenteException extends Exception {
    
    public EmpresaExistenteException(){
        super("A empresa existe.");
    }
}
