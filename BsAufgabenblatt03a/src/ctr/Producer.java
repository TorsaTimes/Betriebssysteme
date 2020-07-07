package ctr;

public class Producer extends Thread{

	private Buffer b1;
	private int data;
	int i = 0;
	Producer(String name,Buffer b1, int data){
		super(name);
		this.b1 = b1;
		this.data = data;
	}
	
	public void run() {
		while(true) {
			b1.put(data);
			i++;
			}
	}
}
	
