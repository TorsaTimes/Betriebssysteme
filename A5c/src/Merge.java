public class Merge extends Thread {
    private Queue in;
    private Queue out;

    public Merge(Queue in, Queue out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            for (int i=0; i<in.getSize(); i++) {
                out.put(in.get());
            }
        } catch (Exception e) {}
    }
}