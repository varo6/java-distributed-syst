package main.network;

import java.io.*;
import java.net.*;

public class ServerTask implements Runnable {

    protected Socket clientSocket;

    public ServerTask(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
            //SACAMOS EL INPUTSTREAM DEL SOCKET DEL CLIENTE Y LO PASAMOS A UN OBJETO DE TIPO OBJECTINPUTSTREAM
            ObjectInputStream in = new ObjectInputStream(
                clientSocket.getInputStream()
            )
        ) {
            //LEEMOS EL OBJETO DEL INPUTSTREAM Y LO PASAMOS A UN OBJETO DE TIPO HEADER
            Header message = (Header) in.readObject();

            switch (message.getType()) {
                case Header.LOGIN:
                    UserMessage userMsg = (UserMessage) message;
                    System.out.println(
                        "El mensaje es de tipo usuario / login:"
                    );
                    handleUserMessage(userMsg);
                    break;
                case Header.TEXT:
                    TextMessage textMsg = (TextMessage) message;
                    System.out.println("El mensaje es de tipo texto");
                    handleTextMessage(textMsg);
                    break;
                case Header.CLOSE:
                    System.out.println("Mensaje de cierre recibido");
                    CloseMessage closeMsg = (CloseMessage) message;
                    handleCloseMessage(closeMsg);
                    break;
                default:
                    System.out.println("Tipo de mensaje desconocido");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(
                "Error en la comunicación con el cliente: " + e.getMessage()
            );
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println(
                    "Error al cerrar el socket: " + e.getMessage()
                );
            }
        }
    }

    public void handleUserMessage(UserMessage um) {
        System.out.println("-------------Usuario recibido-------------");
        System.out.println("Nombre:" + um.name);
        System.out.println("dni:" + um.dni);
        System.out.println("-------------------------------------------");
    }

    public void handleTextMessage(TextMessage tm) {
        System.out.println("------------Mensaje de texto recibido------------");
        System.out.println("DNI del destinatario" + tm.dni);
        System.out.println("Texto:" + tm.text);
        System.out.println("----------------------------------------------");
    }

    public void handleCloseMessage(CloseMessage cm) throws IOException {
        System.out.println(
            "------------Mensaje de cierre recibido------------"
        );
        clientSocket.close();
        System.out.println("----------------------------------------------");
    }
}
