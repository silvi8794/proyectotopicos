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
public class DatosFinales {
    
    //Atributos
    public ArrayList<Integer> FinalNroExperimento;
    public ArrayList<Integer> FinalNroClientes;
    public ArrayList<Integer> FinalMediaServicios;
    public ArrayList<Integer> FinalMediaLlegada;
    public ArrayList<Integer> FinalCantServidores;

    public ArrayList<Integer> FinalocioTime;
    public ArrayList<Double> FinalLlegadaTime;
    public ArrayList<Integer> FinalEsperaColaTime;
    public ArrayList<Double> FinalSalidaTime;
    public ArrayList<Integer> FinalNumeroClienteCola;
    public ArrayList<Double> ocioPromedio;
    public ArrayList<Double> esperaColaPromedio;

    //Constructor
    public DatosFinales(){
        FinalNroExperimento = new ArrayList<Integer>();
            FinalNroClientes = new ArrayList<Integer>();
            FinalMediaServicios = new ArrayList<Integer>();
            FinalMediaLlegada = new ArrayList<Integer>();
            FinalCantServidores = new ArrayList<Integer>();

            FinalocioTime = new ArrayList<Integer>();
            FinalLlegadaTime = new ArrayList<Double>();
            FinalEsperaColaTime = new ArrayList<Integer>();
            FinalSalidaTime = new ArrayList<Double>();
            FinalNumeroClienteCola = new ArrayList<Integer>();
            ocioPromedio = new ArrayList<Double>();
            esperaColaPromedio = new ArrayList<Double>();
    }

}
