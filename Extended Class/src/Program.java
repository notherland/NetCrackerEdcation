public class Program {
    public static void main (String[] argv){
        ExtendedClass ec1 = new ExtendedClass();
        ExtendedClass ec2 = new ExtendedClass();

        ec1.setB((byte) 1);
        ec1.setD(7.999);
        ec1.setI(3243);
        ec1.setS("Cat");

        ec1.setB((byte) 44);
        ec1.setD(7.999);
        ec1.setI(3243);
        ec1.setS("Cat");


        System.out.println(ec1);
        System.out.println(ec2);
        System.out.println(ec1.hashCode());
        System.out.println(ec2.hashCode());
        System.out.println(ec1.equals(ec2));

    }
}
