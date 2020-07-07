
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

		for (int i = 0; i < anzahl; i++) {

				drucker.druckeDatei(dateiname);	
				
				Thread.yield(); // bewirkt das der andere thread aufgerufen wird
				
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}