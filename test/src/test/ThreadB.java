package test;

public class ThreadB extends Thread {

	private Puffer p1;
	private int i;

		
		
		public ThreadB(Puffer p, int i) {
			this.p1 = p;
			this.i = i;
			this.setPriority(10);
			start();
		}
		
		
		public void run() {
			
		
			i = i + 1;
			p1.setPuffer(i);
	
		}
			
	
}
