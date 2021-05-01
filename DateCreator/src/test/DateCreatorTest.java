import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.InputMismatchException;

public class DateCreatorTest {
    private static final String GOOD[] = {
            "101 2 23 12 54",
            "67 45 32 12 44",
    };
    private static final String BAD[] = {
            "1No 2data"
    };

    @Test
    public void gettoString0() {


        ByteArrayInputStream in = new ByteArrayInputStream(GOOD[0].getBytes());
        System.setIn(in);

        DateCreator dc = new DateCreator();
        Assert.assertEquals(new Date(101, 2, 23, 12, 54), dc.createDate());
    }

    @Test
    public void gettoString1() {


        ByteArrayInputStream in = new ByteArrayInputStream(GOOD[1].getBytes());
        System.setIn(in);

        DateCreator dc = new DateCreator();
        Assert.assertEquals(new Date(67, 45, 32, 12, 44), dc.createDate());
    }

    @Test
    public void gettoString2() {


        ByteArrayInputStream in = new ByteArrayInputStream(GOOD[1].getBytes());
        System.setIn(in);

        DateCreator dc = new DateCreator();
        Assert.assertEquals(new GregorianCalendar(67, 45, 32, 12, 44), dc.createCalendar());
    }

    @Test
    public void gettoString3() {


        ByteArrayInputStream in = new ByteArrayInputStream(GOOD[1].getBytes());
        System.setIn(in);

        DateCreator dc = new DateCreator();
        Assert.assertNotEquals(new GregorianCalendar(67, 45, 32, 12, 44), dc.createDate());
    }

    @Test(expected = InputMismatchException.class)
    public void personExceptionNoField(){
        ByteArrayInputStream in = new ByteArrayInputStream(BAD[0].getBytes());
        System.setIn(in);

        DateCreator dc = new DateCreator();
        dc.createDate();
    }

}