package test;

public class Main extends Thread {
		

	public static void main(String[] args) {
		
		Puffer p1 = new Puffer(0);
		Puffer p2 = new Puffer(0);
		
		

		ThreadA A1 = new ThreadA(p1,0);
		ThreadA A2 = new ThreadA(p1,0);
		ThreadA A3 = new ThreadA(p1,0);
		ThreadA A4 = new ThreadA(p1,0);
		ThreadA A5 = new ThreadA(p1,0);
		ThreadA A6 = new ThreadA(p1,0);
		ThreadA A7 = new ThreadA(p1,0);
		ThreadA A8 = new ThreadA(p1,0);
		ThreadA A9 = new ThreadA(p1,0);
		ThreadA A10 = new ThreadA(p1,0);
		ThreadA A11 = new ThreadA(p1,0);
		ThreadA A12 = new ThreadA(p1,0);
		ThreadA A13 = new ThreadA(p1,0);
		ThreadA A14 = new ThreadA(p1,0);
		ThreadA A15 = new ThreadA(p1,0);
		ThreadA A16 = new ThreadA(p1,0);
		ThreadA A17 = new ThreadA(p1,0);
		ThreadA A18 = new ThreadA(p1,0);
		
		
		ThreadB B1 = new ThreadB(p2,0);
		ThreadB B2 = new ThreadB(p2,0);
		ThreadB B3 = new ThreadB(p2,0);
		ThreadB B4 = new ThreadB(p2,0);
		ThreadB B5 = new ThreadB(p2,0);
		ThreadB B6 = new ThreadB(p2,0);
		ThreadB B7 = new ThreadB(p2,0);
		ThreadB B8 = new ThreadB(p2,0);
		ThreadB B9 = new ThreadB(p2,0);
		ThreadB B10 = new ThreadB(p2,0);
		ThreadB B11= new ThreadB(p2,0);
		ThreadB B12 = new ThreadB(p2,0);
		ThreadB B13 = new ThreadB(p2,0);
		ThreadB B14 = new ThreadB(p2,0);
		ThreadB B15 = new ThreadB(p2,0);
		ThreadB B16 = new ThreadB(p2,0);
		ThreadB B17 = new ThreadB(p2,0);
		ThreadB B18 = new ThreadB(p2,0);

		
		ThreadA[] ta = {A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18};
				
 		
		
 		ThreadB[] tb = { B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18};

 		

	
// 			tb[0].start();
// 			tb[1].start();
// 			tb[2].start();
// 			tb[3].start();
// 			tb[4].start();
// 			tb[5].start();
// 			tb[6].start();
// 			tb[7].start();
// 			tb[8].start();
// 			tb[9].start();
// 			tb[10].start();
// 			tb[11].start();
// 			tb[12].start();
// 			tb[13].start();
// 			tb[14].start();
// 			tb[15].start();
// 			tb[16].start();
// 			tb[17].start();
// 	
// 	
// 			
// 			ta[0].start();
// 			ta[1].start();
// 			ta[2].start();
// 			ta[3].start();
// 			ta[4].start();
// 			ta[5].start();
// 			ta[6].start();
// 			ta[7].start();
// 			ta[8].start();
// 			ta[9].start();
// 			ta[10].start();
// 			ta[11].start();
// 			ta[12].start();
// 			ta[13].start();
// 			ta[14].start();
// 			ta[15].start();
// 			ta[16].start();
// 			ta[17].start();
 		
 	
 		
 		

		System.out.println(p1.getPuffer() + " ThreadA mit MIN_PRIO");
		System.out.println(p2.getPuffer() + " ThreadB mit MAX_PRIO");
		
		
	}

}
