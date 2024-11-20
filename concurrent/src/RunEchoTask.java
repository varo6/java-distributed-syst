import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunEchoTask {
    // Puerto por defecto para el servidor
    private static int DEFAULT_PORT = 1234;

    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        // Crear un pool de threads usando CachedThreadPool
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Echo Server started on port " + port);
            
            // Bucle infinito para aceptar conexiones
            while (true) {
                try {
                    // Esperar y aceptar nueva conexión
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected");
                    
                    // Crear nueva tarea de eco y ejecutarla en el pool de threads
                    executor.execute(new EchoTask(clientSocket));
                    
                } catch (Exception e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
            
        } catch (Exception e) {
            System.err.println("Could not listen on port " + port);
            executor.shutdown(); // Cerrar el executor si hay error al crear el ServerSocket
        }
    }
}
