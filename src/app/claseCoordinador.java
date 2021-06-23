package app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class claseCoordinador extends UnicastRemoteObject implements interfaceCoordinador {

    String valor;

    public claseCoordinador() throws RemoteException {
        super();
    }

    @Override
    public int iniMonitor(String m) throws RemoteException {
        if (m.equals("bye")) {
            Servidor.monitores--;
            System.out.println("Un monitor ha salido");
        } else {
            Servidor.monitores++;
            System.out.println("Un monitor ha entrado");
        }

        return Servidor.intervalo;
    }

    @Override
    public void loadMonitor(String valor) throws RemoteException {
        //INSERTAR VALOR
        this.valor = valor;
    }

    @Override
    public int iniClient() throws RemoteException {
        //DEVOLVER CANTIDAD DE MONITORES
        return Servidor.monitores;
    }

    @Override
    public String getLoadAvg() throws RemoteException {
        //DEVOLVER EL VALOR DE LOADAVG
        return valor;
    }

}
