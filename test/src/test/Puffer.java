package test;

public class Puffer {

	int counter;
	boolean isAvailabe;
	
	public Puffer(int i) {
		this.counter = i;
	}
	
	public int getPuffer() {
		return counter;
	}
	
	public void setPuffer(int i) {
		this.counter = this.counter + i;
	}
	
}
