import java.io.IOException;

public class Program {
    static public void main(String[] argv) throws IOException {
        String path = System.getProperty("user.dir") + "\\src";
        System.out.println(path);
        System.out.println("Program code : ");
        NIO2Demo.printCode(path + "\\Program.java");
        System.out.println("----------------------------------------------------------------------");

        NIO2Demo.writeNumbers(path + "\\numbers.txt", 3, 4, 6, 7, 2, 5);
        NIO2Demo.readNumbers(path + "\\numbers.txt");
        System.out.println("----------------------------------------------------------------------");

        NIO2Demo.copyFileToFile(path + "\\javadoc.txt", path + "\\javadoccopy.txt");
        System.out.println("Count r : " + NIO2Demo.countSymbol(path + "\\javadoccopy.txt", 'r'));
    }

}
