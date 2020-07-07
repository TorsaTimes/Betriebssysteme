public class Queue {
    private String name;
    private int groesse;
    
    // übernommen aus Skript
    private int head;
    private int tail;
    private int numberOfElements;
    private int[] data;

    Queue(String name, int groesse) {
        this.name = name;
        this.groesse = groesse;

        head = 0;
        tail = 0;
        numberOfElements = 0;
        data = new int[groesse];
    }

    public int getSize() {
        return groesse;
    }

    public boolean isEmpty() {
        if (numberOfElements==0) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized int get() {
        // Merge Objekt wartet, falls InputQueue leer ist
        while (isEmpty()) {
            try {
                wait();
            } catch (Exception e) {}
        }

        int value = data[head];

        if (head<groesse) {
            head++;
        } else {
            head = 0;
        }

        numberOfElements--;

        // sonst Verklemmung möglich
        notifyAll();

        return value;
    }

    public synchronized void put(int zahl) {
        if (numberOfElements<groesse) {
            numberOfElements++;
            data[tail] = zahl;

            if (tail<groesse) {
                tail++;
            } else {
                tail = 0;
            }
            
            // sonst Verklemmung möglich
            notifyAll();

        } else {
            try {
                wait();
            } catch (Exception e) {}
        }
    }

    public void print() {
        System.out.println();
        System.out.println(name + " :");
        for (int i=0; i<groesse; i++) {
            System.out.println(data[i]);
        }
    }
}   