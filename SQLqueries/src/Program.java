import java.util.Scanner;

public class Program {
    static public void main (String[] argv){
        System.out.println("Enter GroupID");
        Scanner scanner = new Scanner(System.in);
        String group = scanner.nextLine();

        System.out.println("Enter dolgCount Value");
        int dolgValue = scanner.nextInt();

        String ps = "insert into T_GroupSelected (id_Student, firstName, lastName, id_Group)\n" +
                "select id_student, firstName, lastName, id_Group \nfrom T_Student\n" +
                "where T_Student.dolgCount > " + dolgValue + " and id_Group = " + group;

        System.out.println(ps);
    }
}
