import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeMyClassToBePersisted {
    public static void main(String[] argv){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt")))
        {
            MyClassToBePersisted p = new MyClassToBePersisted("Sam", "S08-909");
            oos.writeObject(p);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
