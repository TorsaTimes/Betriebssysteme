package ctr;

public class Main {

	public static void main(String[] args){
		
		Buffer b1 = new Buffer();
		
		Consumer c1 = new Consumer("c1",b1);
		Consumer c2 = new Consumer("c2",b1);
		
		Producer p1 = new Producer("p1",b1,1);
		Producer p2 = new Producer("p2",b1,2);
		Producer p3 = new Producer("p3",b1,3);
		
//		System.out.println("	 MAIN		" + Buffer.wP[0] + Buffer.wP[1] + Buffer.wP[2] + Buffer.wP[3] + Buffer.wP[4] + Buffer.wP[5]);
		c2.start();
		p2.start();
		p1.start();
		p3.start();
		c1.start();
	}
}
