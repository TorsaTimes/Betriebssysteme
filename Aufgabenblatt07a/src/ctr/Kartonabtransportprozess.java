package ctr;

class Kartonabtransportprozess extends Thread {
   private Signale signale;
   
   public Kartonabtransportprozess(Signale signale) {
      this.signale = signale;
   }

   private void fahreKartonWeg() throws InterruptedException {
	   sleep(1000);/* Wegfahren des Kartons simulieren analog zum Vorfahren des Kartons */
   }

   private void fahreKartonVonAblageposWeg() throws InterruptedException {
      /* Auf Signal warten, das signalisiert, dass Produkt
         abgelegt und damit der Karton weggefahren werden kann */
	   signale.WarteProduktAbgelegt();
      System.out.println("-3- Karton wird weggefahren");
      fahreKartonWeg();
      /* Relevante Signale (zurueck) setzen */
      signale.setAblageposFrei(true);
      signale.setProduktablageErlaubt(false);
      signale.setProduktAbgelegt(false);
   }

   public void run() {
      while (true) {
         try {
            fahreKartonVonAblageposWeg();
         } catch (InterruptedException e) {
            System.out.println("Unzulaessige Unterbrechung");
            System.exit(0);
         }
      }
   }
}