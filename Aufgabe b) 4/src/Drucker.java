import java.io.BufferedReader;
import java.io.FileReader;

class Drucker {

	synchronized void druckeDatei(String dateiname) {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(dateiname));
			String line = in.readLine();
			while (line != null) {
				// Zeile line auf dem Drucker ausgeben,
				// hier simuliert durch Bildschirmausgabe
				System.out.println(line);
				line = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Eine Ausnahme ist aufgetreten.");
			System.out.println(e);
		}
	}
}