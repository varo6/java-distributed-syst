import java.io.*;
import java.net.*;

class SimpleClient {

    public static void main(String[] args) throws Exception {
        SimpleClient client = new SimpleClient();
        client.runClient(1234);
    }

    public void runClient(int port) throws Exception {
        Socket con = new Socket("localhost", 1234);
        System.out.println("Connected to server");
        OutputStream out = con.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);

        while (true) {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
            );
            String s = br.readLine();
            writer.println(s);
            /*			InputStream in = con.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = reader.readLine();
			System.out.println("Server says: "+line);*/
        }
        //	con.close();
    }
}
