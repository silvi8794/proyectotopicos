/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integradormodelosysimulacion;

import java.util.ArrayList;

/**
 *
 * @author alberto del yesso
 */
public class IntegradorModelosYSimulacion {

    /**
     * @param args the command line arguments
     */
    public static DatosFinales DatosFinal;
    
    public static void main(String[] args) {
        // TODO code application logic here
        DatosFinal = new DatosFinales();
        new InterfaceMenu().setVisible(true);

    }
    

    


    
    //Probabilidades poisson
    public ArrayList<Double> cargarModeloPoisson(ArrayList<Integer> p_datos, double p_lambda){
        
        ArrayList<Double> Ppoisson = new ArrayList<Double>();
        
       for (Integer num : p_datos){
            Ppoisson.add(Math.log(1/num) / p_lambda);
        }
        return Ppoisson;
    }        
    
    
    
}
