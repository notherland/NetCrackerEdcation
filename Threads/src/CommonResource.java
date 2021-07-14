public class CommonResource {
    private int value = 0;
    boolean mutex = false;

    synchronized int get() throws InterruptedException {
        while(mutex)
            wait();

        mutex = true;
        notify();
        return value;
    }

    synchronized void put(int _value) throws InterruptedException {
        while (!mutex)
            wait();

        value = _value;
        mutex = false;
    }
}
