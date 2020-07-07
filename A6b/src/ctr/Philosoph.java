package ctr;

public class Philosoph extends Thread{

    int number;
    Table table;

    public Philosoph(int number, Table table){
        this.number = number;
        this.table = table;
    }

    public void run(){
    while (true) {
        think(number);
        System.out.println("Philosoph took Fork: " + number);
        table.takeFork(number);
        System.out.println("Philosoph eating: " + number);
        eat(number);
        System.out.println("Philosoph put Fork down: " + number);
        table.putFork(number);

         }
    }

    private void eat(int number) {
            try{
                System.out.println("Philosoph eating: " + number );
                Thread.sleep(((int) (Math.random() *  2000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private void think(int number) {
            try{
                System.out.println("Philosoph geht aufs Klo: " + number + "vermutlich kacken");
                Thread.sleep(((int) (Math.random() *  1000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }


}
