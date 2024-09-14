
import java.io.*;

public class CopyFile {

	public String leerporletra() throws IOException {
		FileReader fr = new FileReader("./a.txt");
		System.out.println(System.getProperty("user.dir"));
		BufferedReader br = new BufferedReader(fr);
		char letra = (char)br.read();
		String frase = "";
		while (letra != (char)-1) {
			frase = frase + letra;
			letra = (char)br.read();
		}
		br.close();
		return frase;
	}

	public void copiar() throws IOException {
		String frase = leerporletra();
		FileWriter fw = new FileWriter("./copiedfile.txt");
		fw.write(frase);
		fw.close();
	}
}

