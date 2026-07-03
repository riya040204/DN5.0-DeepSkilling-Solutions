import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class MyClassTest {

    private MyClass myClass;

    @Before
    public void setUp() {
        myClass = new MyClass();
        System.out.println("Test started...");
    }

    @After
    public void tearDown() {
        System.out.println("Test finished.");
    }

    @Test
    public void testAdd() {
        int result = myClass.add(5, 3);
        assertEquals(8, result);
        System.out.println("testAdd passed: 5 + 3 = " + result);
    }

    @Test
    public void testSubtract() {
        int result = myClass.subtract(10, 4);
        assertEquals(6, result);
        System.out.println("testSubtract passed: 10 - 4 = " + result);
    }

    @Test
    public void testMultiply() {
        int result = myClass.multiply(3, 4);
        assertEquals(12, result);
        System.out.println("testMultiply passed: 3 x 4 = " + result);
    }

    @Test
    public void testIsEven() {
        assertTrue(myClass.isEven(4));
        assertFalse(myClass.isEven(5));
        System.out.println("testIsEven passed!");
    }
}
