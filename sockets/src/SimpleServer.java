import java.net.*;
import java.io.*;
public class SimpleServer {



	public void runServer(int port) throws Exception {
		ServerSocket serverListener = new ServerSocket(port);
		String textRecieved = "";
		while (true) {
			System.out.println("Waiting for client connection...");
			Socket client = serverListener.accept();
			System.out.println("Server Connected");
			// Do something with the client socket
			// mientras que no se reciba quit sigo
			InputStream input = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			while (true){
				
				// Print the message from the client
				textRecieved = reader.readLine();
				System.out.println("Received from client: " + textRecieved);	
				if (textRecieved.equalsIgnoreCase("quit")){
					client.close();
					break;
				}
			}
			System.out.println("ClientDisconnected");

			/* Send a message to the clent: "Hello from server"
			OutputStream output = client.getOutputStream();
			(outputStreamWriter o bufferedWrite)
			PrintWriter writer = new PrintWriter(output, true);
			writer.println("Reading from server until quit is recieved");*/
		}
	//	System.out.println("Server closed.");
	}
}
