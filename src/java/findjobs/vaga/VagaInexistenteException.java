/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs.vaga;


public class VagaInexistenteException extends Exception{
    
    public VagaInexistenteException(){
        super("A vaga nao existe");
    }
}
