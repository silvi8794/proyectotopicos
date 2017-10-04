/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integradormodelosysimulacion;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alberto del yesso
 */
public class Datos {
    
    //attributes
    public static ArrayList<Double> Pexponenciales;
    public static ArrayList<Double> intervalos;
    public static ArrayList<Double> acumulada;
    
    //constructor
    public Datos(){
        intervalos = new ArrayList<Double>();
        Pexponenciales = new ArrayList<Double>();
        acumulada = new ArrayList<Double>();
    }
    

    
    //Probabilidades exponenciales
    public ArrayList<Double> cargarModeloExponencial(int cantidadClientes,int semilla, double mu){
        double valor;
        Random value = new Random();
        int random;
        NumeroAleatorio unNumero = new NumeroAleatorio();
        ArrayList<Double> arr = new ArrayList<Double>();
        for (int i=0; i < cantidadClientes; i++){
            random = value.nextInt(99);
            valor = unNumero.crear(10000, semilla, random, 23);
            arr.add(valor);
        }
        ArrayList<Double> t = new ArrayList<Double>();
        for(double item : arr){
            t.add(-(1/mu) * Math.log(item));
            
        }
        ArrayList<Double> muestra = new ArrayList<Double>();
        
//        System.out.print("Muestra Exponencial: ");
        for (int i=0; i < cantidadClientes; i++){
            valor = t.get(i);
            muestra.add(mu * (Math.exp(-mu*valor)));
//            System.out.print((mu * (Math.exp(-mu*valor)))+ " xx ");
        }
        return muestra;
    }
     
    
    //Probabilidades exponenciales
    public ArrayList<Integer> cargarModeloPoisson(int cantidadClientes, double mu){
        Random r = new Random();
        int random;
        double valor;
        NumeroAleatorio unNumero = new NumeroAleatorio();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        double L;
        int k;
        for (int i=0 ; i < cantidadClientes; i++){
            k = 0;
            L = Math.exp(-mu);
            double p = 1.0;
            do {
                p = p * r.nextDouble();
                k++;
            } while (p > L);
            valor = k - 1;
            arr.add(k);

        }
        
        return arr;
    }
    
    

       
}
