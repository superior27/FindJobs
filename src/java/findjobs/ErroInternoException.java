/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findjobs;

/**
 *
 * @author Saara Lima
 */
public class ErroInternoException extends Exception{
    
     private Exception origem;
    public ErroInternoException(Exception origem){
        super(origem.getMessage());
        this.origem = origem;
    }
    
    
    public ErroInternoException(){
        super("Erro Interno !");
    }
    
}
