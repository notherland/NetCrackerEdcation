public class Program {
    public static void main (String[] argv){
        ThreeNumbers tn = new ThreeNumbersImpl();
        tn.setX(5);
        tn.setY(1);
        tn.setZ(4);

        System.out.println(tn.getX() + " " + tn.getY() + " " + tn.getZ());
        tn.sort();
        System.out.println(tn.getX() + " " + tn.getY() + " " + tn.getZ());
    }
}
