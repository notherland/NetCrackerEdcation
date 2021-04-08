import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Programm {
    public static void main(String[] argv) {
        List<Person> list = new ArrayList<>();
        Person person1 = new Person("Leonid", "Smirnov", new Date(90, 12, 13), null);
        Address address1 = new Address("Russia", "Izhevsk", "Lenina", 45, 78);
        person1.setAddress(address1);

        Person person2 = new Person("Maria", "Nikonova", new Date(87, 11, 11), null);
        Address address2 = new Address("Russia", "Izhevsk", "Lenina", 23, 123);
        person2.setAddress(address2);

        Address address3 = new Address("Italy", "Rome", "", 123, 23);
        Person person3 = new Person("Ferdinand", "Bianchi", new Date(101, 8, 31), address3);

        Address address4 = new Address("USA", "Chicago", "", 12, 3);
        Person person4 = new Person("John", "Smith", new Date(99, 1, 31), address4);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        /**
         * Searhing person by surname
         */
        System.out.print("Searching by surname\n");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a surname: ");

        String surname = in.nextLine();
        List<Person> personBySurname = new ArrayList<>();

        for (Person p : list) {
            if (p.getSurname().equals(surname)){
                personBySurname.add(p);
                break;
            }
        }

        if (personBySurname.size() > 0) {
            System.out.println(personBySurname);
        }
        else{
            System.out.println("No such person");
        }

        /**
         * Searhing person by address
         */
        System.out.print("Searching by address\n");
        System.out.print("Input an address: ");

        String country = in.nextLine();
        String city = in.nextLine();
        String street = in.nextLine();
        int house = in.nextInt();
        int flat = in.nextInt();
        Address address = new Address(country, city, street, house, flat);

        List<Person> personByAddress = new ArrayList<>();

        for (Person p : list) {
            if (p.getAddress().equals(address)){
                personByAddress.add(p);
                break;
            }
        }

        if (personByAddress.size() > 0) {
            System.out.println(personByAddress);
        }
        else{
            System.out.println("No such person");
        }


        /**
         * Sorting people by birth date
         */

        System.out.print("Sorting by birth date\n");

        BdateComparator bdaycomp = new BdateComparator();

        Collections.sort(list, bdaycomp);
        //print full info to check address
        for (Person p : list) {
            System.out.println(p.printFullInfo());
        }

        /**
         * Searching for people birthed between two dates
         */

        System.out.print("Searching for people birthed between two dates\n");
        System.out.print("Input two dates:");

        Date date1 = new Date (in.nextInt(), in.nextInt(), in.nextInt());
        Date date2 = new Date (in.nextInt(), in.nextInt(), in.nextInt());

        List<Person> personByBdate = new ArrayList<>();

        for (Person p : list) {
            if (p.getBdate().compareTo(date1) > 0 && p.getBdate().compareTo(date2) < 0)
                personByBdate.add(p);
        }

        System.out.println(personByBdate);

        /**
         * Collecting people by street
         * Here is used Stream instead of List
         */
        System.out.print("Searching for people living on the same street ");

        //Function for collecting people
        Function<Person, List<Object>> compositeKey = personrecord ->
                Arrays.<Object>asList(personrecord.getAddress().getCountry(), personrecord.getAddress().getCity(), personrecord.getAddress().getStreet());

        Map<Object, List<Person>> map =
                list.stream().collect(Collectors.groupingBy(compositeKey, Collectors.toList()));

        System.out.println(map);
}
}
