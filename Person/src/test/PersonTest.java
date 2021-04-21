
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class PersonTest {
    private static final String GOOD[] = {
            "Ivanov Petr Nikolaevich"
    };
    private static final String BAD[] = {
            "Polov", //no name and patronymic
            "Polov Nikolay", //no patronymic
    };

    @Test
    public void getInitials0(){
        String text = GOOD[0];
        Person person = new Person(text);
        Assert.assertEquals("getFullName() failed with this text:\n"+text+"\n",
                "Ivanov P.N.", person.getInitials());
    }

    @Test(expected = NoSuchElementException.class)
    public void personExceptionNoNamePatronymic(){
        Person person = new Person(BAD[0]);
    }

    @Test(expected = NoSuchElementException.class)
    public void personExceptionNoName(){
        Person person = new Person(BAD[1]);
    }
}
