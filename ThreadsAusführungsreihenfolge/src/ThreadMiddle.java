import java.util.concurrent.Semaphore;

public class ThreadMiddle extends Thread{
	
	private String name;
	private Semaphore s1;
	private Semaphore s2;

	
	
	public ThreadMiddle(String name, Semaphore s1, Semaphore s2) {
		this.name = name;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	
	public void run() {
		try {
			s1.acquire();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(this.name);
		s2.release();
	}
}
