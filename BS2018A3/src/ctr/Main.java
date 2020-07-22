package ctr;

public class Main extends Thread {

	public static int n = 1;
	private static final Object monitor = new Object();

	public static void main(String[] args) {
		Main x = new Main(); // Thread a
		Main y = new Main(); // Thread b

		x.start();
		y.start();
	}

	public synchronized void run() {

		synchronized (monitor) {
			for (int i = 1; i <= 5; i++) {
				System.out.println(n); // Zeile 1
				n = n + 1;// Zeile 2

			}
		}
	}
}
