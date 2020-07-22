import java.util.concurrent.Semaphore;

public class ThreadBegin extends Thread {

	private String name;
	private Semaphore s1;
	private Semaphore s2;
	private Semaphore s3;

	public ThreadBegin(String name, Semaphore s1, Semaphore s2, Semaphore s3) {
		this.name = name;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	public void run() {
		System.out.println(this.name);
		s1.release();
		s2.release();
		s3.release();
	}

	public static void main(String[] args) {
		
		while(true) {
		Semaphore s1 = new Semaphore(0);
		Semaphore s2 = new Semaphore(0);
		Semaphore s3 = new Semaphore(0);
		Semaphore s4 = new Semaphore(0);
		Semaphore s5 = new Semaphore(0);
		Semaphore s6 = new Semaphore(0);

		ThreadBegin tc1 = new ThreadBegin("Daniel", s1, s2, s3);
		ThreadMiddle tc2 = new ThreadMiddle("Tom", s1,s4);
		ThreadMiddle tc3 = new ThreadMiddle("Saleh", s2,s5);
		ThreadMiddle tc4 = new ThreadMiddle("Harald", s3,s6);
		ThreadEnd tc5 = new ThreadEnd("Samu", s4, s5, s6);

		
		tc1.start();
		tc2.start();
		tc3.start();
		tc4.start();
		tc5.start();
		}

	}

}
