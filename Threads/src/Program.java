public class Program{
    public static void main(String[] argv) throws InterruptedException {
        CommonResource cr = new CommonResource();
        Thread ThreadA = new Thread(new ThreadA(cr),"Thread A");
        Thread ThreadB = new Thread(new ThreadB(cr),"Thread B");

        ThreadB.start();
        ThreadA.start();

        System.out.println("!!!" + cr.get());
    }
}
