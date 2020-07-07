package ctr;

public class Buffer {

	private boolean available = false;
	private int data;
	static String status = "L";
	static String p1 = "_";
	static String p2= "_";
	static String p3 = "_";
	static String c1= "_";
	static String c2 = "_";
	static String[] wP = {p1,p2,p3,status,c1,c2};
	boolean check = false;

	public synchronized void put(int x){
	while(available) {	
		if(check == true){
			if(Thread.currentThread().getName().equals("p1")){
				p1 = "_";
				check = false;
				System.out.println("			" + wP[0] + wP[1] + wP[2] + wP[3] + wP[4] + wP[5]);
			}else if(Thread.currentThread().getName().equals("p2")){
				p2 = "_";
				check = false;
				System.out.println("			" + wP[0] + wP[1] + wP[2] + wP[3] + wP[4] + wP[5]);
			}
			else if(Thread.currentThread().getName().equals("p3")) {
				p3 = "_";
			check = false;
			System.out.println("			" + wP[0] + wP[1] + wP[2] + wP[3] + wP[4] + wP[5]);
			}
			}
	//------------------------------------- Wenn ein P in Warte Pool geht	
	try {
		System.out.println(Thread.currentThread().getName()+ "Pool");
		if(Thread.currentThread().getName().equals("p1")) {
			p1 = "P";
			wP[0] = p1;
		}else if(Thread.currentThread().getName().equals("p2")){
			p2 = "P";
			wP[1] = p2;
		}else {
			p3 = "P";
			wP[2] = p3;
		}
		System.out.println("			" + wP[0] + wP[1] + wP[2] + wP[3] + wP[4] + wP[5]);
		if((wP[0].equals("P") && wP[1].equals("P") && wP[2].equals("P") && (wP[3].equals("V")||wP[3].equals("L")) && wP[4].equals("C") && wP[5].equals("C"))){
			System.out.println("*********************************************************");
		}
	wait();
	}catch(InterruptedException e){}
	}
	//-------------------------------------------------------------------------
	System.out.println(Thread.currentThread().getName()+ "Nicht Pool");
	if(status == "L") {
		status = "V";
	}
	data=x;
	notifyAll();
	available=true;
	p1 = "_";
	p2= "_";
	p3 = "_";
	c1= "_";
	c2 = "_";
	wP[3] = status;
	wP[0] = p1;
	wP[1] = p2;
	wP[2] = p3;
	wP[4] = c1;
	wP[5] = c2;
	System.out.println("			" + wP[0] + wP[1] + wP[2] + wP[3] + wP[4] + wP[5]);
	
	}	
	public synchronized int get () {
	while(!available) {	
		
		if(check == true){
			if(Thread.currentThread().getName().equals("c1")) {
				c1 = "_";
				check = false;
				System.out.println("			" + wP[0] + wP[1] + wP[2] + wP[3] + wP[4] + wP[5]);
			}else if(Thread.currentThread().getName().equals("c2")) {
				c2 = "_";
				check = false;
				System.out.println("			" + wP[0] + wP[1] + wP[2] + wP[3] + wP[4] + wP[5]);;
			}
			}
		//--------------------------------------Wenn C in warte pool geht
		try {
			System.out.println(Thread.currentThread().getName() + "Pool");
			if(Thread.currentThread().getName().equals("c1")) {
				if(!(p1 == "_")){
					p1 = "_";
					wP[0] = p1;
				}else if(!(p2 == "_")){
					p2 = "_";
					wP[1] = p2;
				}else if(!(p3 == "_")) {
					p3 = "_";
					wP[2] = p3;
				}
				c1 = "C";
				wP[4] = c1;;
			}else if(Thread.currentThread().getName().equals("c2")){
				if(!(p1 == "_")){
					p1 = "_";
					wP[0] = p1;
				}else if(!(p2 == "_")){
					p2 = "_";
					wP[1] = p2;
				}else if(!(p3 == "_")) {
					p3 = "_";
					wP[2] = p3;
				}
				c2 = "C";
				wP[5] = c2;
			}
			System.out.println("			" + wP[0] + wP[1] + wP[2] + wP[3] + wP[4] + wP[5]);
			if((wP[0].equals("P") && wP[1].equals("P") && wP[2].equals("P") && (wP[3].equals("V")||wP[3].equals("L")) && wP[4].equals("C") && wP[5].equals("C"))){
				System.out.println("*********************************************************");
			}
	wait();	
	}catch(InterruptedException e){}
	//-------------------------------------------------------------------
	}
	System.out.println(Thread.currentThread().getName()+ "Nicht Pool");
	available=false;
	if(Thread.currentThread().getName().equals("c1") || Thread.currentThread().getName().equals("c2")){
		if(status.equals("V")) {
			status = "L";
		}
		wP[3] = status;
		check = true;
	}
	notify();
	return data;
	}
}
