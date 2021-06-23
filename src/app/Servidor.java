package app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Servidor {

    public static int monitores;
    public static int intervalo = 0;

    public static void main(String[] args) {
        System.out.println("Iniciando servidor");
        intervalo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el intervalo de medicion"));
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("miCoordinador", new claseCoordinador());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
