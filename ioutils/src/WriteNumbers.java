import java.io.*;

public class WriteNumbers {

	public void escribir() throws IOException {
		FileOutputStream fos = new FileOutputStream("./numbers.bin");
		DataOutputStream dos = new DataOutputStream(fos);

		for (int i=0; i<=20;i++){	
			dos.writeInt(i);
		}
		dos.close();
		fos.close();
	}

	public void escribir2() throws IOException{
		FileWriter fw = new FileWriter("./numbers.txt");
		PrintWriter pw = new PrintWriter(fw);
		for (int i=0; i<=20;i++){
			pw.print(i);
		}
		pw.close();
		fw.close();

	}

}
