class Test {
	public static void main(String[] argv) {
		if (argv.length >= 2) {

			Drucker d = new Drucker();

			Benutzer haensel = new Benutzer(d, argv[0], 5);
			Thread haenselThread = new Thread(haensel);
			haenselThread.start();

			Benutzer gretel = new Benutzer(d, argv[1], 5);
			Thread gretelThread = new Thread(gretel);
			gretelThread.start();

		} else {
			System.out
					.println("Bitte zwei Dateinamen als Argumente uebergeben!");
		}
	}
}
