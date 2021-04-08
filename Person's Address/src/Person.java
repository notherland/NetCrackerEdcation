import java.util.Date;

/**
 * Class which describes person
 */
public class Person {

    private String name;
    private String surname;
    private Date bdate;
    private Address address;

    /**
     * Constructor without parameters
     */
    public Person(){}

    /**
     * Constructor with all parameters
     */
    public Person(String name, String surname, Date bdate, Address address){
        this.name = name;
        this.surname = surname;
        this.bdate = bdate;
        this.address = address;
    }

    /**
     * Prints person's surname, name
     */
    public String toString(){
        return name + " " + surname;
    }

    /**
     * Prints full info about person
     */
    public String printFullInfo(){
        return name + " " + surname + " " + bdate.toString() + " " + address.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBdate() {
        return bdate;
    }

    public Address getAddress() {
        return address;
    }

}

