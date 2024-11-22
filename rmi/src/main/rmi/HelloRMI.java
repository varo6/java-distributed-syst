package main.rmi;

import java.rmi.*;

//Obligatorio que lancen RemoteException
public interface HelloRMI extends Remote {
    String sayHello(String name) throws RemoteException;
    long getTime() throws RemoteException;
}
