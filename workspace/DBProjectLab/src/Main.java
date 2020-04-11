import java.io.File;


public class Main {
	public static void main(String[] args) {
		File file = new File("/media/cksharma/CK/Multimedia/Movies/Hindi Movies/3 idiots/3 idiots.mkv");
		System.out.println(file.exists());
		System.out.println(file.length());
	}
}
