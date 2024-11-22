package main.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloRMIImplementation
    extends UnicastRemoteObject
    implements HelloRMI {

    private static final long serialVersionUID = 1L;

    public HelloRMIImplementation() throws RemoteException {
        super();
    }

    @Override
    public long getTime() throws RemoteException {
        return System.currentTimeMillis();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) throws Exception {
        HelloRMIImplementation pt = new HelloRMIImplementation();
        //Iniciar el registro
        //Registry reg = LocateRegistry.createRegistry(5670);
        Naming.rebind("rmi://localhost:5670/HelloRMI", pt);
        System.out.println("Listo para decir Hello");
    }
}
