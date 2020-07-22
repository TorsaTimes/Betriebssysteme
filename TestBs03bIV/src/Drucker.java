import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.Semaphore;

class Drucker {
	Semaphore s = new Semaphore(1);

	void druckeDatei(String dateiname) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(dateiname));
			String line = in.readLine();
			s.acquire();
			while (line != null) {
// Zeile line auf dem Drucker ausgeben,
// hier simuliert durch Bildschirmausgabe
				System.out.println(line);
				line = in.readLine();
			}
			s.release();
			in.close();
		} catch (Exception e) {
			System.out.println("Eine Ausnahme ist aufgetreten.");
			System.out.println(e);
		}
	}
}