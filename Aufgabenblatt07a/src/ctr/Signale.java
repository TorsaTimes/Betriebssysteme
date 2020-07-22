package ctr;

class Signale {
   private boolean ablageposFrei = true;
   private boolean produktablageErlaubt = false;
   private boolean produktAbgelegt = false;

   // Darauf warten, dass Signa1 auf ,true, gesetzt wird
   public synchronized void WarteAblageposFrei() throws InterruptedException {
      while(!ablageposFrei) {
    	  System.out.println("Wartet auf freigabe des Übergabe Ortes #Drogendeal");
    	  wait();
      }
   }

   public synchronized void WarteProduktablageErlaubt() throws InterruptedException {
	   while(!produktablageErlaubt) {
	    	  System.out.println("Wartet auf freigabe der Produkt Abgabe #Drogendeal");
	    	  wait();
	      }
   }

   public synchronized void WarteProduktAbgelegt() throws InterruptedException {
	   while(!produktAbgelegt) {
	    	  System.out.println("Wartet auf Produkt wurde abgelegt #Drogendeal");
	    	  wait();
	      }
   }

   // Signalzustand auf ,value, setzen
   public synchronized void setAblageposFrei (boolean value) {
	   this.ablageposFrei = value;
      if(ablageposFrei == true) {
    	  notifyAll();
      }
   }

   // Signalzustand auf ,value, setzen
   public synchronized void setProduktablageErlaubt(boolean value) {
      this.produktablageErlaubt = value;
      if(produktablageErlaubt == true) {
    	  notifyAll();
      }
   }
  
   // Signalzustand auf ,value, setzen
   public synchronized void setProduktAbgelegt (boolean value) {
      this.produktAbgelegt = value;
      if(produktAbgelegt == true) {
    	  notifyAll();
      }
   }
}