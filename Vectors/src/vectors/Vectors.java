package vectors;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Scanner;
import java.util.Vector;

import static java.io.StreamTokenizer.TT_EOF;

public class Vectors {
    static public Vector mult(Vector v, int scalar) {
        for (int i = 1; i < v.size(); i++)
            v.set(i, (Double) v.get(i) * scalar);
        return v;
    }

    static public Vector sum(Vector v1, Vector v2) {
        if (v1.size() != v2.size()) throw new IllegalArgumentException();
        Vector sum = new Vector();
        sum.add(v1.size());     //set the first element as dimension
        for (int i = 1; i < v1.size(); i++)
            sum.add((Double) v1.get(i) + (Double) v2.get(i));
        return sum;
    }

    static public int scalarMult(Vector v1, Vector v2) {
        if (v1.size() != v2.size()) throw new IllegalArgumentException();

        int scalarMult = 0;
        for (int i = 1; i < v1.size(); i++)
            scalarMult += (Double) v1.get(i) * (Double) v2.get(i);
        return scalarMult;
    }

    static public void outputVector(Vector v, OutputStream out) {
        String vector = v.toString();
        byte[] buffer = vector.getBytes();
        try{
            out.write(buffer);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    static public Vector inputVector(InputStream in) throws IOException {
        return readVector(new InputStreamReader(in));
    }

    static public void writeVector(Vector v, Writer out) {
        String buffer = "";
        for (int i = 0; i < v.size(); i++)
            buffer += v.get(i).toString() + " ";
        System.out.println(buffer);
        try {
           out.write(buffer.toCharArray(), 0, buffer.toCharArray().length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public Vector readVector(Reader in) throws IOException {
        Vector vector = new Vector();
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.parseNumbers();
        while (tokenizer.nextToken() != TT_EOF){
            vector.add(tokenizer.nval);
        }
        return vector;
    }
}
