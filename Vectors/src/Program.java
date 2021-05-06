import vectors.Vectors;

import java.io.*;
import java.util.Vector;

public class Program {
    static public void main(String[] argv) throws IOException {
        String str1 = "2 3 4";
        String str2 = "2 3 5";


        Vector vector1 = Vectors.inputVector(new ByteArrayInputStream(str1.getBytes()));
        Vectors.outputVector(vector1, System.out);

        System.out.println();

        Vector vector2 = Vectors.readVector(new InputStreamReader(new ByteArrayInputStream(str2.getBytes())));
        Vectors.writeVector(vector2, new OutputStreamWriter(System.out));

        System.out.println("sum : " + Vectors.mult(vector1, 4));
        System.out.println("scalar : " + Vectors.sum(vector1, vector2));
        System.out.println("scalarMult : " + Vectors.scalarMult(vector1, vector2));
    }
}
