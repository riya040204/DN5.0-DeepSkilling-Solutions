import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert equals - checks if two values are equal
        assertEquals(5, 2 + 3);
        System.out.println("assertEquals passed: 2 + 3 = 5");

        // Assert true - checks if condition is true
        assertTrue(5 > 3);
        System.out.println("assertTrue passed: 5 > 3 is true");

        // Assert false - checks if condition is false
        assertFalse(5 < 3);
        System.out.println("assertFalse passed: 5 < 3 is false");

        // Assert null - checks if value is null
        assertNull(null);
        System.out.println("assertNull passed: value is null");

        // Assert not null - checks if value is not null
        assertNotNull(new Object());
        System.out.println("assertNotNull passed: Object is not null");

        // Assert array equals - checks if two arrays are equal
        int[] expected = {1, 2, 3};
        int[] actual   = {1, 2, 3};
        assertArrayEquals(expected, actual);
        System.out.println("assertArrayEquals passed: arrays are equal");

        // Assert same - checks if both point to same object
        String str = "JUnit";
        assertSame(str, str);
        System.out.println("assertSame passed: same object reference");

        System.out.println("All assertions passed successfully!");
    }
}
