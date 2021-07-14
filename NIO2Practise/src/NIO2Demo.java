import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class NIO2Demo {
    static void printCode(String folder) throws IOException {
        Path path = Paths.get(folder);
        String code = Files.readString(path);
        System.out.println(code);
    }

    static public void writeNumbers(String folder, int... numbers) throws IOException {
        Path path = Paths.get(folder);
        StringBuilder strNumbers = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            strNumbers.append(numbers[i]);
            strNumbers.append(' ');
        }
        Files.write(path, strNumbers.toString().getBytes());
    }

    static public void readNumbers(String folder) throws IOException {
        Path path = Paths.get(folder);
        String[] strNumbers = Files.readString(path).split("\s");
        byte[] byteNumbers = new byte[strNumbers.length];
        int[] intNumbers = new int[strNumbers.length];
        float[] floatNumbers = new float[strNumbers.length];

        System.out.println("Count of numbers : " + strNumbers.length);

        for (int i = 0; i < strNumbers.length; i++) {
            byteNumbers[i] = Byte.parseByte(strNumbers[i]);
            intNumbers[i] = Integer.parseInt(strNumbers[i]);
            floatNumbers[i] = Float.parseFloat(strNumbers[i]);
        }

        System.out.println("Average of full array: " + averageInt(intNumbers, intNumbers[0], 1, 0, intNumbers.length));
        System.out.println("Average of second half array: " + averageInt(intNumbers, intNumbers[0], 1, intNumbers.length / 2, intNumbers.length / 2));
        System.out.println("Average of third quarter array: " + averageInt(intNumbers, intNumbers[0], 1, (int) ((float) intNumbers.length * (2 / 3)), intNumbers.length / 4));
    }

    static private float averageInt(int[] array, float average, int count, int from, int resultCount) {
        if (count >= resultCount)
            return average;
        float nextAverage = ((average * count) + (float) array[count]) / (float) (count + 1);
        return averageInt(array, nextAverage, count + 1, from, resultCount);
    }

    static public void copyFileToFile(String src, String dst) throws IOException {
        FileReader reader = new FileReader(src);
        FileWriter writer = new FileWriter(dst);
        BufferedReader br = new BufferedReader(reader);
        StringBuilder buf = new StringBuilder();
        int c;
        int countJava = 0;
        while ((c = br.read()) > 0){
            while ((char) c != ' ') {
                buf.append((char)c);
                c = br.read();
            }

            if ("java".equals(buf))
                countJava++;
            writer.write(buf.toString());
            writer.write(" ");

            if (countJava >= 3)
                break;

            buf.setLength(0);
        }
        reader.close();
        writer.flush();
    }


    static public int countSymbol(String folder, char c) throws IOException {
        Path path = Paths.get(folder);
        BufferedReader bufferReader = Files.newBufferedReader(path);
        int count = 0;
        int curC;

        while ((curC = bufferReader.read()) > 0) {
            if ((char) curC == c)
                count++;
        }
        return count;
    }
}
