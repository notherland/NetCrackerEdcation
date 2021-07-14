public class ThreadB implements Runnable {
    CommonResource res;

    public ThreadB(CommonResource res) {
        this.res = res;
    }

    @Override
    public void run() {
        int val = 0;
        try {
            for (int i = 0; i < 100000; i++){
            res.put(i);
            System.out.println(Thread.currentThread().getName() + " B " + i;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
