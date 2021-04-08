
/**
 * class describing address
 */

public class Address {
    private String country;
    private String city;
    private String street;
    private Integer house;
    private Integer flat;

    /**
     * constructor without parameters
     */
    public Address(){}

    /**
     * constructor with parameters
     */
    public Address(String country, String city, String street, Integer house, Integer flat){
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public boolean equals(Address address){
        if (this.country.equals(address.getCountry()) &&
            this.city.equals(address.getCity()) &&
            this.street.equals(address.getStreet()) &&
            this.house.equals(address.getHouse()) &&
            this.flat.equals(address.flat)){
            return true;
        }
        else return false;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getHouse() {
        return house;
    }

    public Integer getFlat() {
        return flat;
    }

    public String toString (){
        return country + ", " + city + ", " + street + ", " + house + ", " + flat;
    }
}

