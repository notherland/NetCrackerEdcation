public class Program {
    static public void main(String[] argv) throws PhoneNumberException {
        PhoneNumber pn1 = new PhoneNumber("+104289652211");
        System.out.println(pn1);

        PhoneNumber pn2 = new PhoneNumber("89120210242");
        System.out.println(pn2);

        PhoneNumber pn3 = new PhoneNumber("891202102420");
        System.out.println(pn3);
    }
}
