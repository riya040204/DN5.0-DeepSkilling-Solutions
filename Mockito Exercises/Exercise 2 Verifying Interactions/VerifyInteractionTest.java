import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

public class VerifyInteractionTest {

    private ExternalApi mockApi;
    private MyService service;

    @Before
    public void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
        System.out.println("Mock created for verification tests!");
    }

    @Test
    public void testVerifyInteraction() {
        // ARRANGE
        when(mockApi.getData()).thenReturn("Mock Data");

        // ACT
        service.fetchData();

        // ASSERT - verify getData() was called exactly once
        verify(mockApi).getData();
        System.out.println("testVerifyInteraction passed: getData() was called!");
    }

    @Test
    public void testVerifyCalledTimes() {
        // ARRANGE
        when(mockApi.getData()).thenReturn("Mock Data");

        // ACT - call fetchData 3 times
        service.fetchData();
        service.fetchData();
        service.fetchData();

        // ASSERT - verify called exactly 3 times
        verify(mockApi, times(3)).getData();
        System.out.println("testVerifyCalledTimes passed: getData() called 3 times!");
    }

    @Test
    public void testVerifyNeverCalled() {
        // ACT - dont call fetchData at all

        // ASSERT - verify getData was never called
        verify(mockApi, never()).getData();
        System.out.println("testVerifyNeverCalled passed: getData() never called!");
    }

    @Test
    public void testVerifyWithArguments() {
        // ARRANGE
        when(mockApi.postData("Hello")).thenReturn("Success");

        // ACT
        service.sendData("Hello");

        // ASSERT - verify postData called with exact argument
        verify(mockApi).postData("Hello");
        verify(mockApi, never()).postData("Wrong");
        System.out.println("testVerifyWithArguments passed: postData called with Hello!");
    }

    @Test
    public void testVerifyAtLeast() {
        // ARRANGE
        when(mockApi.getData()).thenReturn("Data");

        // ACT
        service.fetchData();
        service.fetchData();

        // ASSERT - verify called at least once
        verify(mockApi, atLeastOnce()).getData();

        // verify called at least 2 times
        verify(mockApi, atLeast(2)).getData();
        System.out.println("testVerifyAtLeast passed!");
    }

    @Test
    public void testVerifyNoMoreInteractions() {
        // ARRANGE
        when(mockApi.getData()).thenReturn("Data");

        // ACT
        service.fetchData();

        // ASSERT
        verify(mockApi).getData();

        // verify no other methods were called
        verifyNoMoreInteractions(mockApi);
        System.out.println("testVerifyNoMoreInteractions passed!");
    }
}
