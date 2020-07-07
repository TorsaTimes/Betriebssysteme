import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.security.SecureRandom;

/*
I.)     Thread A schreibt alle Bytes in die Pipe und beendet danach das Programm
II.)    Thread A schreibt die ersten 1024 Bytes in die Pipe und verklemmt danach, da Thread B keine Bytes aus der Pipe nehmen kann (Größe byteArray = 1024)
III.)   Nein, es gehen keine Werte verloren. Wenn die Pipe voll ist, wartet PipedOutputStream bis wieder Platz frei ist (siehe Skript: 'blockiert, wenn Pipe voll')
IV.)    Thread B liest den ersten Wert aus der Pipe und beendet sich danach (Pipe bleibt offen). PipedOutputStream besitzt die Methode checkStateForReceive. 
        Diese wirft eine Exception sobald sich Thread B beendet hat (https://en.it1352.com/article/d536186a0ef4412691cf5b3239b64073.html)
        Mit dem Wert 1025 für inhaltGroesse wird das Programm ausgeführt, da Thread A die Pipe mit 1025 Bytes voll schreibt und Thread B danach ein Byte heraus liest.
*/

/*
I.)     blocked bedeutet: Thread wartet auf synchronized Methode und bei Interrupt wird keine InterruptedException geworfen
        Da Thread im zustand Blocked ist wird keine InterruptException geworfen, hinzu kommt das der Thread im Waiting Status (Waiting pool) ist und somit ohne das aufrufen von notify (notifyAll) nicht mehr geweckt werden kann!

*/

public class Main {
    public static void main(String[] args) throws IOException {

        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream(in);

        int inhaltGroesse = 1024;
        byte[] byteArray = new byte[inhaltGroesse];

        Thread a = new Thread(new Runnable() {
            public void run() {
                try {
                    // füllt byteArray mit random Bytes
                    SecureRandom.getInstanceStrong().nextBytes(byteArray);
                    // schreibt alle erzeugten Bytes gleichzeitig in die Pipe, da Thread B 100 ms warten muss
                    out.write(byteArray, 0, inhaltGroesse);
                } catch (Exception e) {
                    System.out.println(e);
                } 
            }
        });

        Thread b = new Thread(new Runnable() {
            public void run() {
                try {
                	  //Für aufgabe a IV.
//                    int data = in.read();
//                    System.out.println("Thread B: " + data); 
                   
                	  //für Aufgabe a I. II. III.
                    while (true) {
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {}
                        // liest genau ein Byte aus der Pipe und schließt Verbindung danach wieder
                        int data = in.read();
                        System.out.println("Thread B: " + data);
                    }
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        a.start();
        b.start();

        System.out.println(byteArray.length);

    }
}