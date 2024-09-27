import java.io.*;
public class ReadFile {

	public String leer() throws IOException {
		FileReader fr = new FileReader("./a.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		String textocompleto = "";

		while (linea != null) {
			textocompleto = textocompleto + linea + "\n";
			linea = br.readLine();
		}
		br.close();
		return textocompleto;
	}

}
