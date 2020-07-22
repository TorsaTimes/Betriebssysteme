import java.util.concurrent.Semaphore;

public class ThreadEnd extends Thread {
	
	private String name;
	private Semaphore s1;
	private Semaphore s2;
	private Semaphore s3;
	
	
	public ThreadEnd(String name, Semaphore s1 , Semaphore s2, Semaphore s3) {
		this.name = name;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	
	
	public void run() {
		try {
			s1.acquire();
			s2.acquire();
			s3.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(this.name);
	}
}
