import java.io.*;

public class CopyFile {

	public String copiar() throws IOException {
		FileReader fr = new FileReader("./a.txt");
		char letra = (char)fr.read();
		String frase = "";
		FileWriter fw = new FileWriter("./copiedfile.txt");
		int letrascopiadas = 0;
		while (letra != (char)-1) {
			fw.write(letra);
			letra = (char)fr.read();
			letrascopiadas++;
		}
		fr.close();
		fw.close();
		System.out.println("Se copiaron " + letrascopiadas + " letras");
		return frase;
	}
	
}

