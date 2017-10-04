/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integradormodelosysimulacion;


import java.util.ArrayList;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author alberto del yesso
 */
public class ModeloDeColas {
    //atributos
    public static int totalClientes;
    private static int NroExperimento;
    
    //Constructor
    public ModeloDeColas(int p_nroClientes, int p_nroExperimento){
        totalClientes = p_nroClientes;
        NroExperimento = p_nroExperimento;
    }
    
    //inicia el metodo de colas
    public ArrayList<Object> ejecutar(ArrayList<Double> MuestraTiempoServicio, ArrayList<Integer> MuestraTiempoEntreLlegadas, int nroExperimento){
        //Vector de tiempos de servicio.
        ArrayList<Double> servicioTime = new ArrayList<Double>();
        servicioTime = MuestraTiempoServicio;
        //Vector de tiempos entre llegadas.
        ArrayList<Integer> entreLlegadaTime = new ArrayList<Integer>();
        entreLlegadaTime = MuestraTiempoEntreLlegadas;
        //Vector de tiempos de ocio del servidor.
        ArrayList<Integer> ocioTime = new ArrayList<Integer>();
        //Vector de tiempos de llegada.
        ArrayList<Double> llegadaTime = new ArrayList<Double>();
        //Vector de tiempos de permanencia en el sistema.
        ArrayList<Double> permanenciaTime = new ArrayList<Double>();
        //Vector de tiempos de espera en la cola.
        ArrayList<Integer> esperaColaTime = new ArrayList<Integer>();
        //Vector de tiempos de salida.
        ArrayList<Double> salidaTime = new ArrayList<Double>();
        //Vector que contiene el numero de cliente en la cola.
        ArrayList<Integer> numeroClienteCola = new ArrayList<Integer>();
        

        int count;
        ////Variable empleada en el calculo del tiempo de llegada al sistema del cliente i.
        double tt = 0;
        //Variable empleada en el calculo del tiempo de permanencia en el sistema del cliente i.
        double tiempo_permanencia_sist = 0;
        
        //n es la cantidad de clientes que se ingresa por pantalla
        int n = totalClientes;
        
        //Contador de la cantidad de clientes (extensiÃ³n de la simulacion).
        for (int i = 0; i < n; i++){
            
         
         if(tiempo_permanencia_sist <= entreLlegadaTime.get(i)){
             ocioTime.add((int)(entreLlegadaTime.get(i) - tiempo_permanencia_sist));
             tiempo_permanencia_sist = servicioTime.get(i);
             permanenciaTime.add(tiempo_permanencia_sist);
         }else{
             ocioTime.add(0);
             tiempo_permanencia_sist = tiempo_permanencia_sist + servicioTime.get(i) - entreLlegadaTime.get(i);
             permanenciaTime.add(tiempo_permanencia_sist);
         }
         
         if(i == 0){
             llegadaTime.add((double)entreLlegadaTime.get(i));
         }else{
             tt = tt + entreLlegadaTime.get(i);
             llegadaTime.add(tt);
         }

        
        //NUEVO CODIGO QUE FUNCIONA SIN ERRORES
        if (i== 0) {
               esperaColaTime.add(0);
               salidaTime.add(entreLlegadaTime.get(i) + servicioTime.get(i));
           } else {
               //salidaTime.add(llegadaTime.get(i) + servicioTime.get(i) + salidaTime.get(i - 1));
               
               if (salidaTime.get(i-1) >= llegadaTime.get(i)) {
                   salidaTime.add(salidaTime.get(i - 1) + servicioTime.get(i));
                   esperaColaTime.add((int)(salidaTime.get(i - 1) - llegadaTime.get(i)));
               } else {
                   salidaTime.add(llegadaTime.get(i) + servicioTime.get(i));
                   esperaColaTime.add(0);
               }
           }
       

         //cont: variable empleada en el cÃ¡lculo del nÃºmero de clientes en la cola una
         count = 0;
         
         //--- GUARDA QUE MODIFIQUE ESTO
         if((i == 0)){
             numeroClienteCola.add(0);
         }else{
         
             for(int l1 = 0; l1 <= (i - 1);l1++){
                 if(llegadaTime.get(i) < salidaTime.get(l1)){
                     count = count +1;
                     
                 }
             }
             numeroClienteCola.add(count);
         }         
        }
        
        System.out.print("Tiempo de OCIO: ");
        for (double item : ocioTime){
            System.out.print(item + " ff ");
        }

        
        ArrayList listaColeccion = new ArrayList();
        listaColeccion.add(servicioTime);
        listaColeccion.add(entreLlegadaTime);
        listaColeccion.add(ocioTime);
        listaColeccion.add(llegadaTime);
        listaColeccion.add(permanenciaTime);
        listaColeccion.add(esperaColaTime);
        listaColeccion.add(salidaTime);
        listaColeccion.add(numeroClienteCola);
        
        //Muestra la tabla Resumen del Experimento
        this.mostrarResultados(listaColeccion, totalClientes, nroExperimento);
        
        //devuelve los valores recibidos
        return this.resguardarDatosFinales(ocioTime, llegadaTime, esperaColaTime, salidaTime, numeroClienteCola );
    }
    
    //Muestra la tabla Resumen del Experimento
    public void mostrarResultados(ArrayList listaColeccion, int p_totalClientes, int nroExperimento){
        
        //muestro tabla con grafico de resultados
        ResumenExperimento unExperimento = new ResumenExperimento(listaColeccion, p_totalClientes, nroExperimento);
        unExperimento.cargarTabla(listaColeccion, p_totalClientes);
        
    }
    
    //devuelve los valores recibidos en la tabla
    private ArrayList<Object> resguardarDatosFinales(ArrayList<Integer> ocioTime, ArrayList<Double> llegadaTime,ArrayList<Integer> esperaColaTime, ArrayList<Double> salidaTime, ArrayList<Integer> numeroClienteCola ){
        
        ArrayList<Object> res = new ArrayList<Object>();
        int tamanio = ocioTime.size();
        int acumOcio=0;
        int acumEsperaCola = 0;
        int acumNroClientesCola = 0;
        for(int i=0; i<tamanio;i++){
            acumOcio = acumOcio + ocioTime.get(i);
            acumEsperaCola = acumEsperaCola + esperaColaTime.get(i);
            acumNroClientesCola = acumNroClientesCola + numeroClienteCola.get(i);
        }
        res.add(acumOcio) ;
        res.add(llegadaTime.get(llegadaTime.size()-1));
        res.add(acumEsperaCola);
        res.add(salidaTime.get(salidaTime.size()-1));
        res.add(acumNroClientesCola);
        
        return res;
    }
    
}
