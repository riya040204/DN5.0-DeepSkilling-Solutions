import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;

public class AAAPatternTest {

    private Calculator calculator;

    // Runs ONCE before all tests in this class
    @BeforeClass
    public static void setUpClass() {
        System.out.println("=== Test Suite Started ===");
    }

    // Runs ONCE after all tests in this class
    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== Test Suite Finished ===");
    }

    // Runs before EACH test - Setup
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("-- Setup: Calculator object created --");
    }

    // Runs after EACH test - Teardown
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("-- Teardown: Calculator object destroyed --");
    }

    @Test
    public void testAdd() {
        // ARRANGE - prepare data
        int a = 10;
        int b = 5;

        // ACT - perform action
        int result = calculator.add(a, b);

        // ASSERT - verify result
        assertEquals(15, result);
        System.out.println("testAdd passed: " + a + " + " + b + " = " + result);
    }

    @Test
    public void testSubtract() {
        // ARRANGE
        int a = 20;
        int b = 8;

        // ACT
        int result = calculator.subtract(a, b);

        // ASSERT
        assertEquals(12, result);
        System.out.println("testSubtract passed: " + a + " - " + b + " = " + result);
    }

    @Test
    public void testMultiply() {
        // ARRANGE
        int a = 4;
        int b = 6;

        // ACT
        int result = calculator.multiply(a, b);

        // ASSERT
        assertEquals(24, result);
        System.out.println("testMultiply passed: " + a + " x " + b + " = " + result);
    }

    @Test
    public void testDivide() {
        // ARRANGE
        int a = 20;
        int b = 4;

        // ACT
        int result = calculator.divide(a, b);

        // ASSERT
        assertEquals(5, result);
        System.out.println("testDivide passed: " + a + " / " + b + " = " + result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // ARRANGE
        int a = 10;
        int b = 0;

        // ACT + ASSERT - expects exception
        calculator.divide(a, b);
        System.out.println("testDivideByZero passed: Exception thrown correctly");
    }
}
