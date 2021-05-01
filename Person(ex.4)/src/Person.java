import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    private Date bdate;

    public Person(Date date){
        bdate = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "bdate=" + bdate +
                '}';
    }

    public String toStringbyFormat(SimpleDateFormat format) {
        StringBuffer result = new StringBuffer();
        System.out.println(format);
        System.out.println(format.format(bdate));
        result = format.format(bdate, result, new FieldPosition(0));
        return result.toString();
    }
}
