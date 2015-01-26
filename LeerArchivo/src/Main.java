import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		try {
/Users/andres/Android/workspace/Archivos/src/co/com/ccti/archivos
			File file = new File("archivo.txt");
			FileInputStream stream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader reader2 = new BufferedReader(reader);

			String line = reader2.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader2.readLine();
			}
			
			reader2.close();
			reader.close();
			stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
