package main.network;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ConcurrentServer implements Runnable, Serializable {

    private static final int MAX_THREADS = 10;
    private static final int PORT = 12345;
    private ServerSocket serverSocket;
    private ExecutorService pool;

    public ConcurrentServer() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
        this.pool = Executors.newFixedThreadPool(MAX_THREADS);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket clientsocket = serverSocket.accept();
                pool.execute(new ServerTask(clientsocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConcurrentServer cs = new ConcurrentServer();
        cs.run();
    }
}
