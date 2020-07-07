package ctr;

public class Table {

    boolean[] forkUsed;

    public Table (){
        this.forkUsed = new boolean[5];
    }

    public synchronized void takeFork(int number) {
        while(forkUsed[left(number)] || forkUsed[right(number)]){
            try {
                System.out.println("Philosoph Waiting" + number);
                wait();
            }
            catch(InterruptedException e){}
        }
        System.out.println("Forks Taken: " + left(number) + right(number));
        forkUsed[left(number)] = true;
        forkUsed[right(number)] = true;
    }

    private int right(int number) {
        if((number + 1) > 4){
           return 0;
        }
        return number + 1;
    }

    private int left(int number) {
        return number;
    }

    public synchronized void putFork(int number) {
        System.out.println("Forks Available Now: " + left(number) + right(number));
        forkUsed[left(number)] = false;
        forkUsed[right(number)] = false;
        notifyAll();
    }
}