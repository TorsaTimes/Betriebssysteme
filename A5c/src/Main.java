public class Main {
    public static void main(String[] args) {
        Queue q1 = new Queue("Input Q1", 5);
        Queue q2 = new Queue("Input Q2", 5);
        Queue o1 = new Queue("Merge Q1+Q2", 10);

        Einspeiser e1 = new Einspeiser(q1, 0);
        Einspeiser e2 = new Einspeiser(q2, 1);

        Merge m1 = new Merge(q1, o1);
        Merge m2 = new Merge(q2, o1);

        e1.start();
        e2.start();
        m1.start();
        m2.start();

        try {
            e1.join();
            e2.join();
            m1.join();
            m2.join();
        } catch (Exception e) {}

        try {
            e1.interrupt();
            e2.interrupt();
            m1.interrupt();
            m2.interrupt();
        } catch (Exception e) {}

        q1.print();
        q2.print();

        o1.print();

        System.out.println();

        System.exit(0);

    }
}