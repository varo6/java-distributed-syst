import java.io.*;
import java.net.Socket;

public class EchoTask implements Runnable {
    // Contador de la tarea
    private static int taskId = 0;
    
    // Variables de instancia 
    protected Socket clientSocket; // Socket del cliente conectado
    
    // CONSTRUCTOR---------------------------------
    public EchoTask(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.taskId = taskId++;     // Asigna ID único incrementando el contador
    }
    
    @Override
    public void run() {
        try {
            // Obtener streams de entrada/salida
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true);
            
            String inputLine;
            // Lee datos del cliente hasta que envíe null (cierre conexión)
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Task numero " + taskId + " recibida: " + inputLine);
                // Envía de vuelta el mismo mensaje (eco)
                out.println(inputLine);
            }
            
        } catch (IOException e) {
            System.err.println("Error en la Task " + taskId + ": " + e.getMessage());
        } 
        try {
                clientSocket.close(); // Siempre cerrar el socket
            } catch (IOException e) {
                System.err.println("Error cerrando en la Task " + taskId);
            }
        }
    }
