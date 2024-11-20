package main.network;

import java.io.*;
import java.net.*;

public class ExampleClient implements Serializable {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 12345);
        } catch (Exception e) {}
    }

    private void sendUserMessage(Socket s) {
        UserMessage um = new UserMessage("John", 12345678);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject(um);
        out.flush();
    }

    private void sendHeader(Socket s) {
        Header h = new Header(1);
        int hlength = h.getHeaderLength();
        byte[] serializedHeader = h.pack();
        ObjectOutputStream out = s.getOutputStream();
        out.write(serializedHeader);
        out.flush();
    }
}
