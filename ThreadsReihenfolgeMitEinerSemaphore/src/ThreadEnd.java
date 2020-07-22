import java.util.concurrent.Semaphore;

public class ThreadEnd extends Thread {

	String name;
	Semaphore s1;

	public ThreadEnd(String string, Semaphore s1) {
		this.s1 = s1;
		this.name = string;

	}

	public void run() {

		try {
			s1.acquire(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name);

	}

}
