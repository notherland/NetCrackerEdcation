import java.util.NoSuchElementException;

/**
 * Class describes person by surname, name, patronymic
 */
public class Person {
    private String surname;
    private String name;
    private String patronymic;

    /**
     * Constructor by input format "Surname Name Patronymic"
     * throws NoSuchElementException if format is different
     *
     * @param fullname
     */
    public Person(String fullname) {
        String[] strs = fullname.split("\\s", 3);
        switch (strs.length) {
            case 0:
                throw new NoSuchElementException("No input");
            case 1:
                throw new NoSuchElementException("No name and patronymic");
            case 2:
                throw new NoSuchElementException("No patronymic");
        }

        this.surname = strs[0];
        this.name = strs[1];
        this.patronymic = strs[2];
    }

    public String getInitials() {
        return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    /**
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }
}
