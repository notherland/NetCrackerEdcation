import java.util.Objects;

/**
 * Class describing a phone number in +<country code><10 digits> or 8<10 digits> format
 */
public class PhoneNumber {
    private String code;
    private String number;

    /**
     * Constructor with parameners
     * @param phonenumber
     * @throws PhoneNumberException
     */
    public PhoneNumber(String phonenumber) throws PhoneNumberException {
        /**
         * Учитываем что начинается либо с + и кода страны состоящего из 1-3 цифр либо с 8
         **/
        if (!phonenumber.matches("((\\+)(\\d{1,3})|8)(\\d{10})")) throw new PhoneNumberException("Wrong number format", phonenumber);

        if (phonenumber.charAt(0) == '+'){
            parsePlusFormat(phonenumber);
        }
        else {
            parseNonPlusFormat(phonenumber);
        }
    }

    /**
     * Method for parsing + format
     * @param phonenumber
     */
    private void parsePlusFormat(String phonenumber){
        code = phonenumber.substring(1, phonenumber.length() - 10);
        number = phonenumber.substring(phonenumber.length() - 10, phonenumber.length());
    }

    /**
     * Method for parsing no + format
     * @param phonenumber
     */
    private void parseNonPlusFormat(String phonenumber){
        code = "7";
        number = phonenumber.substring(1, 10);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return code.equals(that.code) && number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number);
    }

    public String toString(){
        String np1 = number.substring(0, 2);
        String np2 = number.substring(3, 5);
        String np3 = number.substring(6, 9);

        return "+" + code + np1 + "-" + np2 + "-" + np3;
    }
}
