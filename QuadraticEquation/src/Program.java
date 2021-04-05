import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        for (; ; ) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a factors: ");
            float a = in.nextFloat();
            float b = in.nextFloat();
            float c = in.nextFloat();

            QuadraticEquation qe = new QuadraticEquation(a, b, c);
            String x1 = qe.getFirstRoot();
            String x2 = qe.getSecondRoot();

            System.out.println(qe.toString());
            System.out.println(x1 + " " + x2);
        }
    }
}
