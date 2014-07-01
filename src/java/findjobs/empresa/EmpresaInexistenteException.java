/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.empresa;

/**
 *
 * @author Saara Lima
 */
public class EmpresaInexistenteException extends Exception {
    
    public EmpresaInexistenteException(){
        super("A empresa nao existe.");
    }
}
