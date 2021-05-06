import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeMyClassToBePersisted {
    static public void main(String[] argv){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt")))
        {
            MyClassToBePersisted p=(MyClassToBePersisted) ois.readObject();
            System.out.printf("Profile: %s \t Group: %s \n", p.getProfile(), p.getGroup());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
