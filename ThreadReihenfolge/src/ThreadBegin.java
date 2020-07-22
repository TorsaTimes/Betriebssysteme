import java.util.Date;
import java.util.concurrent.Semaphore;

public class ThreadBegin extends Thread {

	Semaphore s1;
	String name;

	public ThreadBegin(Semaphore s1, String name) {

		this.s1 = s1;
		this.name = name;

	}

	@Override
	public void run() {

		System.out.println(this.name);
		s1.release();
	}

	public static void main(String[] args) {

		Semaphore s1 = new Semaphore(0);
		Semaphore s2 = new Semaphore(0);
		Semaphore s3 = new Semaphore(0);

		ThreadBegin t1 = new ThreadBegin(s1, "t1");
		ThreadBegin t2 = new ThreadBegin(s2, "t2");
		ThreadBegin t3 = new ThreadBegin(s3, "t3");

		ThreadEnd t4 = new ThreadEnd(s1, s2, s3, "t4");
		ThreadEnd t5 = new ThreadEnd(s1, s2, s3, "t5");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

}
