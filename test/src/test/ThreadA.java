package test;

public class ThreadA extends Thread {

private Puffer p1;
private int i;

	
	
	public ThreadA(Puffer p, int i) {
		this.p1 = p;
		this.i = i;
		this.setPriority(1);
		this.setDaemon(true);
		start();
	}
	
	
	public void run() {
		
	
		i = i + 1;
		p1.setPuffer(i);

		}
		
	
}
