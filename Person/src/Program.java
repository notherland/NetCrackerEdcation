public class Program {
    public static void main(String[] argv){
        Person person1 = new Person("Ivanov Petr Nikolaevich");
        System.out.println(person1.getInitials());

        Person person2 = new Person("Polov Nikolay");
        System.out.println(person2.getInitials());
    }
}
