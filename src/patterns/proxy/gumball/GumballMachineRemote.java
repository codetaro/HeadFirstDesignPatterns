package patterns.proxy.gumball;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {
    public int getCount() throws RemoteException;

    // Each method throws RemoteException
    public String getLocation() throws RemoteException;

    // All return types need to be primitive or Serializable
    public State getState() throws RemoteException;
}
