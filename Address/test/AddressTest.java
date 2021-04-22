import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Test class for Address class
 */
public class AddressTest {
    private static final String GOOD[] = {
            "Russia, Udmurtiya, Izhevsk, Lenina, 45, 7, 55",
            "Russia, Moscow, Moscow, Pervomayskaya, 34, 5, 424",
            "Russia, Udmurtiya- Votkinsk... , Pushkinskaya;.., 34, 99, 424"
    };
    private static final String BAD[] = {
            "Italy, Rome, 34, 43, 5"
    };

    @Test
    public void gettoString0(){
        String text = GOOD[0];
        Address address = new Address(text);
        Assert.assertEquals("Address(String address) failed with this text:\n"+text+"\n",
                "Russia, Udmurtiya, Izhevsk, Lenina, 45, 7, 55",  address.toString());
    }

    @Test
    public void gettoString1(){
        String text = GOOD[1];
        Address address = new Address(text);
        Assert.assertEquals("Address(String address) failed with this text:\n"+text+"\n",
                "Russia, Moscow, Moscow, Pervomayskaya, 34, 5, 424",  address.toString());
    }

    @Test
    public void gettoString2(){
        String text = GOOD[2];
        Address address = new Address(text, ",.;-");
        Assert.assertEquals("Address(String address) failed with this text:\n"+text+"\n",
                "Russia, Udmurtiya, Votkinsk, Pushkinskaya, 34, 99, 424",  address.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void personExceptionNoField(){
        Address address = new Address(BAD[0]);
    }
}
