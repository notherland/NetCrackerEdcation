/**
 * Class describing shirt with id, description, color, size
 */
public class Shirt {
    String id = "no id";
    String description = "no description";
    String color = "no color";
    String size = "no size";

    /**
     * Constructot with parameter
     * @param str
     */
    public Shirt(String str){
        String[] substrs = str.split(",", 4);
        id = substrs[0];
        description = substrs[1];
        color = substrs[2];
        size = substrs[3];
    }

    /**
     * returns description and value
     * @return
     */
    public String toString(){
        return "ID: " + id +
                "; DESCRIPTION: " + description +
                "; COLOR: " + color +
                "; SIZE: " + size;
    }
}
