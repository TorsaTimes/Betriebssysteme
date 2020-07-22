import java.util.concurrent.Semaphore;

public class ThreadEnd extends Thread {

	String name;
	Semaphore s1;
	Semaphore s2;
	Semaphore s3;

	public ThreadEnd(Semaphore s1, Semaphore s2, Semaphore s3, String string) {
		this.name = string;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;

	}

	@Override
	public void run() {

		try {
			s1.acquire();
			s2.acquire();
			s3.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(name);
		s1.release();
		s2.release();
		s3.release();
	}

}
