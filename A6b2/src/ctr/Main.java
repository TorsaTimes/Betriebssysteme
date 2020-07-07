package ctr;

public class Main {

    public static void main(String[] args){
        SemaphoreGroup sems = new SemaphoreGroup(5);

        Philosoph philosoph = new Philosoph(0, sems);
        Philosoph philosoph1 = new Philosoph(1, sems);
        Philosoph philosoph2 = new Philosoph(2, sems);
        Philosoph philosoph3 = new Philosoph(3, sems);
        Philosoph philosoph4 = new Philosoph(4, sems);

        philosoph.start();
        philosoph1.start();
        philosoph2.start();
        philosoph3.start();
        philosoph4.start();
    }

}
