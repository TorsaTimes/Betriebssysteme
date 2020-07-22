package test360;

import java.util.concurrent.Semaphore;

public class Test extends Thread {
	
	public String name;
	private static Semaphore mutex;
	private int anzahl;
	private passiveKlasse pk;
	
	public Test(String s, Semaphore mutex, int anzahl, passiveKlasse pk) {
		this.name = s;
		this.mutex = mutex;
		this.anzahl = anzahl;
		this.pk = pk;
	}
	
	
	public void run()
	{
			
			while(anzahl>0) {
				pk.rennen(this.name);
				anzahl--;
				
				}
	}

	
	public static void main(String[] args) {

		
		
		Semaphore sa = new Semaphore(1);
		passiveKlasse pk = new passiveKlasse();
		
		
		
		Test t = new Test("Günther",sa,100,pk);
		Test t1  = new Test("GünthersBruder",sa,100,pk);
		
		t.start();
		t1.start();

		
		
		
	}

}
