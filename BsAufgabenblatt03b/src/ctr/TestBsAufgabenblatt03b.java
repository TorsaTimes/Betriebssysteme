package ctr;

class TestBsAufgabenblatt03b {
	
	public static void main(String[] argv) {

		if (argv.length >= 0) {
			Drucker d = new Drucker();
			Benutzer haensel = new Benutzer(d, argv[0], 5);
			Thread t1 = new Thread(haensel);
			t1.start();
			
			Benutzer gretel = new Benutzer(d, argv[1], 5);
			Thread t2 = new Thread(gretel);
			t2.start();
		} else {
			System.out.println("Bitte zwei Dateinamen als Argumente uebergeben!");
		}
	}
}
