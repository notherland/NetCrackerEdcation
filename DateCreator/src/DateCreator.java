
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateCreator{
    private Scanner scanner;

    public DateCreator(){
        scanner = new Scanner(System.in);
    }

    public Date createDate(){
        int Year = scanner.nextInt();
        int Month = scanner.nextInt();
        int Day = scanner.nextInt();
        int Hour = scanner.nextInt();
        int Minute = scanner.nextInt();

        return new Date(Year, Month, Day, Hour, Minute);
    }

    public GregorianCalendar createCalendar(){
        int Year = scanner.nextInt();
        int Month = scanner.nextInt();
        int Day = scanner.nextInt();
        int Hour = scanner.nextInt();
        int Minute = scanner.nextInt();

        return new GregorianCalendar(Year, Month, Day, Hour, Minute);
    }
}
