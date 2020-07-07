 import java.util.concurrent.Semaphore;

class Benutzer implements Runnable {

	Semaphore semaphore = new Semaphore(1);
	Drucker drucker;
	String dateiname;
	int anzahl;

	Benutzer(Drucker drucker, String dateiname, int anzahl) {
		this.drucker = drucker;
		this.dateiname = dateiname;
		this.anzahl = anzahl;
	}

	public void run() {

		try {

			semaphore.acquire();
			
			for (int i = 0; i < anzahl; i++) {

				drucker.druckeDatei(dateiname);

			}
			
			semaphore.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}