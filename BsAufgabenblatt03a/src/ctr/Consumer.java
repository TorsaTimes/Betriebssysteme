package ctr;

public class Consumer extends Thread{

	private Buffer b1;
	private int data;
	int i = 0;
	
	Consumer(String name, Buffer b){
		super(name);
		this.b1 = b;
	}
	
	public void run() {
		while(true) {
			//System.out.println(Thread.currentThread().getName() + " Vor Get-Methode");
			b1.get();
			i++;
			}
	}
}
	
	

