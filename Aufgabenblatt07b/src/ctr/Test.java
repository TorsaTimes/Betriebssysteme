package ctr;

public class Test {

	public static void main(String[] argv) {

		TicketAnbieter ta = new TicketAnbieter(4);

		new Reisebuero("Reiseland", ta).start();
		new Reisebuero("Happy Travel", ta).start();
	}
}
