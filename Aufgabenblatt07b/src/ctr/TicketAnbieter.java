package ctr;

public class TicketAnbieter {
	private int VerfuegbareTickets;

	TicketAnbieter(int n) {
		VerfuegbareTickets = n;
	}

	 boolean  TicketsVerfuegbar() { //synchronized
		return VerfuegbareTickets > 0;
	}

	 int  TicketVerkauf() { //synchronized
		if(TicketsVerfuegbar()) {
		int nr = VerfuegbareTickets;
		//I.)
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		VerfuegbareTickets = VerfuegbareTickets - 1;
		return nr;
		}else {
			 throw new IllegalArgumentException("Keine Tickets mehr vorhanden!");
		}
	}
}

