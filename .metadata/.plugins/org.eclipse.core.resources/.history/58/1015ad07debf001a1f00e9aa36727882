package ctr;

public class Main extends UnknownError {
	

	public static void main(String[] args) {
		
	//SemaphoreGroup semaphoreGroup = new SemaphoreGroup(5);
	
		Table table = new Table();
		
		Philosoph p1 = new Philosoph(0, table);
		Philosoph p2 = new Philosoph(1, table);
		Philosoph p3 = new Philosoph(2, table);
		Philosoph p4 = new Philosoph(3, table);
		Philosoph p5 = new Philosoph(4, table);
	
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
	}

}
