import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Test class for Address class
 */
public class PersonTest {
    private static final String GOOD[] = {
            "yyyy-MM-dd",
            "EEE, MMM d, ''yy",
            "hh 'o''clock' a, zzzz"

    };
    private static final String BAD[] = {
            "Italy, Rome, 34, 43, 5"
    };

    @Test
    public void gettoString0() {
        String text = GOOD[0];
        Person person = new Person(new Date(101, 2, 23, 12, 54));
        Assert.assertEquals("Person failed with this text:\n" + text + "\n",
                "2001-03-23", person.toStringbyFormat(new SimpleDateFormat(text)));
    }

    @Test
    public void gettoString1() {
        String text = GOOD[1];
        Person person = new Person(new Date(101, 2, 23, 12, 54));
        Assert.assertEquals("Person failed with this text:\n" + text + "\n",
                "пт, мар. 23, '01", person.toStringbyFormat(new SimpleDateFormat(text)));
    }

    @Test
    public void gettoString2() {
        String text = GOOD[2];
        Person person = new Person(new Date(101, 2, 23, 12, 54));
        Assert.assertEquals("Person failed with this text:\n" + text + "\n",
                "12 o'clock PM, Москва, стандартное время", person.toStringbyFormat(new SimpleDateFormat(text)));
    }
}