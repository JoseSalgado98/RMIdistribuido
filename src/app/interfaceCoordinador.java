package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaceCoordinador extends Remote {

    public int iniMonitor(String m) throws RemoteException;

    public void loadMonitor(String valor) throws RemoteException;

    public int iniClient() throws RemoteException;

    public String getLoadAvg() throws RemoteException;
}
