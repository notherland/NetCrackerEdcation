import java.util.Comparator;

/**
 * Class comparison by bdate
 */

public class BdateComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.getBdate().compareTo(p2.getBdate());
    }
}

