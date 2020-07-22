package test360;

import java.util.concurrent.Semaphore;

public class passiveKlasse {

	Semaphore s = new Semaphore(1);
	Object o = new Object();
	
	
	public void rennen(String name) {
		
		try {
			s.acquire();
			synchronized (o) {
				
			
			System.out.println(name);
			s.release();
			Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
