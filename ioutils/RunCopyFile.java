
public class RunCopyFile {
	public static void main(String[] args) throws Exception {
		System.out.println(System.getProperty("user.dir"));
		CopyFile cf = new CopyFile();
		cf.copiar();
		System.out.println("File copied");
	}
}
