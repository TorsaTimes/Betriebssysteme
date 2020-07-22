package ctr;

class Verpackungsprozess {
   public static void main(String[] args) {
      Signale signale = new Signale();
      
      Kartonzufuhrprozess kzp = new Kartonzufuhrprozess(signale);
      
      Kartonabtransportprozess kap = new Kartonabtransportprozess(signale);
      
      Produktablageprozess pap = new Produktablageprozess(signale);
      
      
      kzp.start();
      kap.start();
      pap.start();
      
       /* die Prozesse Kartonzufuhrprozess, Produktablageprozess und 
          Kartonatransportprozess starten */
      

   }
}