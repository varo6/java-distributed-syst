package main.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloRMIClient {

    public static void main(String[] args)
        throws RemoteException, MalformedURLException, NotBoundException {
        HelloRMI t = (HelloRMI) Naming.lookup("rmi://localhost:5670/HelloRMI");
        System.out.println(
            "Hola Server...= " +
            t.sayHello("Pepe") +
            " Hora actual=" +
            t.getTime()
        );
    }
}
