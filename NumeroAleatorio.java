/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integradormodelosysimulacion;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author alberto
 */
public class NumeroAleatorio {
    
    public NumeroAleatorio(){
        
    }
    
    //genera numeros aleatorios
    public double crear(int p_modulo, int p_semilla, int p_paramt, int p_paramp){
//       p_paramt = nextPrime(p_paramt); 
       double a;
       a = (200 * p_paramt)+ p_paramp;
       double r;
       r = (a * p_semilla) % p_modulo;
       return r/p_modulo;
    } 
    
}
