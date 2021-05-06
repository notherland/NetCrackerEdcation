import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Program {
    static public void main(String[] argv) {
        ArrayVector arrayVector = new ArrayVector();
        LinkedListVector listVector = new LinkedListVector();
        arrayVector.set(1, 2, 3);
        listVector.set(1, 2, 3);
        //Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vector.dat"))) {
            oos.writeObject(arrayVector);
            oos.writeObject(listVector);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

        arrayVector.set(1, 2, 3, 4);
        listVector.set(1, 2, 3, 4);

        //Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vector.dat"))) {
            ArrayVector arrayVector1 = (ArrayVector) ois.readObject();
            LinkedListVector listVector1 = (LinkedListVector) ois.readObject();
            System.out.println(Arrays.toString(arrayVector1.get()));
            System.out.println(listVector1.get());
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
