public class PhoneNumberException extends Exception{
    private String phonenumber;

    public String getPhonenumber(){
        return phonenumber;
    }

    public PhoneNumberException(String message, String phonenumber){
        super(message + ": " + phonenumber);
        this.phonenumber = phonenumber;
    }
}
