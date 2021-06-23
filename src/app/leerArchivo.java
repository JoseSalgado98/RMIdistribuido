/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author lubuntu
 */
public class leerArchivo extends Thread {
    
    String carga;
    int intervalo;
    interfaceCoordinador i;
    
    leerArchivo(int intervalo, interfaceCoordinador i) {
        this.intervalo = intervalo;
        this.i = i;
    }
    
    public void run(){
        
        try{

        while (true) {
                
                BufferedReader br = new BufferedReader(new FileReader(new File("/proc/loadavg")));
                carga = br.readLine();
                
                i.loadMonitor(carga);
                
                Thread.sleep(intervalo * 1000);
                
                if (Monitor.fin == true) {
                    break;
                }
            }
        
        System.out.println("Hilo terminado...");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
}
