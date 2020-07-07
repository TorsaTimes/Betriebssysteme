import java.io.*;

class Drucker {
	void druckeDatei(String dateiname) {
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

class Benutzer implements Runnable { // runnable verpackt alle infos die der thread braucht
	Drucker drucker;
	String dateiname;
	int anzahl;

	Benutzer(Drucker drucker, String dateiname, int anzahl) {
		this.drucker = drucker;
		this.dateiname = dateiname;
		this.anzahl = anzahl;
	}

	public void run() {
		for (int i = 0; i < anzahl; i++) {
			drucker.druckeDatei(dateiname);
		}
	}
}

class Test {
	public static void main(String[] argv) {
		if (argv.length >= 2) {
			Drucker d = new Drucker();

			Benutzer haensel = new Benutzer(d, argv[0], 5);
			Thread haenselThread = new Thread(haensel);

			Benutzer gretel = new Benutzer(d, argv[1], 5);
			Thread gretelThread = new Thread(gretel);

			haenselThread.start();
			gretelThread.start();
		} else {
			System.out.println("Bitte zwei Dateinamen als Argumente uebergeben!");
		}
	}
}
