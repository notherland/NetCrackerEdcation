public class ThreadA implements Runnable {
    CommonResource res;

    public ThreadA(CommonResource res) throws InterruptedException {
        this.res = res;
    }

    @Override
    public void run() {
        int value = 0;
        int curval = 0;
        try {
            for (int i = value ; i < value + 5; i++) {
                System.out.println(Thread.currentThread().getName() + " A " + value);
                res.put(value);
            }
            res.put(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
