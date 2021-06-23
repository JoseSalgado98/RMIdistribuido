package app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Monitor {

    public static boolean fin = false;

    public static void main(String[] args) {
        int intervalo;
        String carga;
        String s;

        System.out.println("Monitor en ejecucion");
        String ip = JOptionPane.showInputDialog("Ip del servidor");

        try {
            Registry registry = LocateRegistry.getRegistry(ip, 1099);
            interfaceCoordinador i = (interfaceCoordinador) registry.lookup("miCoordinador");

            intervalo = i.iniMonitor("hola");

            leerArchivo l = new leerArchivo(intervalo, i);

            l.start();

            System.out.print("Presione s para finalizar: ");
            Scanner leer = new Scanner(System.in);
            s = leer.nextLine();

            if (s.equals("s")) {
                intervalo = i.iniMonitor("bye");
                fin = true;
                System.out.println("Finalizando...");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
