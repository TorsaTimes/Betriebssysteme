public class Einspeiser extends Thread {
    private int kennWert;
    private Queue zielQueue;

    public Einspeiser(Queue zielQueue, int kennWert) {
        this.kennWert = kennWert;
        this.zielQueue = zielQueue;
    }

    public void run() {
        try {
            for (int i=0; i<zielQueue.getSize(); i++) {
                try {
                    zielQueue.put(kennWert);
                    // Zufällig zwischen 0 und 2 Sekunden schlafen
                    Thread.sleep((int)(Math.random()*200));
                } catch (Exception e) {}
            }
        } catch (Exception e) {}
    }
}