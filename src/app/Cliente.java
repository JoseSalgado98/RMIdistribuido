package app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        int intervalo;
        
        intervalo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el intervalo de medicion"));
        String ip = JOptionPane.showInputDialog("Ip del servidor");
        
        try {
            Registry registry = LocateRegistry.getRegistry(ip, 1099);
            interfaceCoordinador i = (interfaceCoordinador) registry.lookup("miCoordinador");

            System.out.println("Monitores activos: " + i.iniClient());

            while (true) {
                
                System.out.println(i.getLoadAvg());
                
                Thread.sleep(intervalo * 1000);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
