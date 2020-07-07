class Benutzer implements Runnable {

	Drucker drucker;
	String dateiname;
	int anzahl;

	Benutzer(Drucker drucker, String dateiname, int anzahl) {
		this.drucker = drucker;
		this.dateiname = dateiname;
		this.anzahl = anzahl;
	}

	public void run() {

		synchronized (drucker) {
			for (int i = 0; i < anzahl; i++) {

				drucker.druckeDatei(dateiname);

			}
		}
	}
}