import java.util.concurrent.Semaphore;

public class ThreadBegin extends Thread {

	String name;
	Semaphore s1;
	int x;
	static int y;

	public ThreadBegin(String string, Semaphore s1, int x) {
		this.name = string;
		this.s1 = s1;
		this.x = x;
	}

	public void run() {

		try {
			s1.acquire(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name);
		y = y + x;
		System.out.println(y + " Y");
		s1.release(y);

	}

	public static void main(String[] args) {

		Semaphore s1 = new Semaphore(0);

		ThreadBegin tb1 = new ThreadBegin("Daniel", s1, 1);
		ThreadBegin tb2 = new ThreadBegin("Saleh", s1, 1);
		ThreadBegin tb3 = new ThreadBegin("Tom", s1, 1);

		ThreadEnd tb4 = new ThreadEnd("Harald", s1);
		ThreadEnd tb5 = new ThreadEnd("Samu", s1);

		tb1.start();
		tb2.start();
		tb3.start();
		tb4.start();
		tb5.start();

	}

}
