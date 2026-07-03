import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @Before
    public void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
        System.out.println("Mock object created!");
    }

    @Test
    public void testFetchData() {
        when(mockApi.isAvailable()).thenReturn(true);
        when(mockApi.getData()).thenReturn("Mock Data");
        String result = service.fetchData();
        assertEquals("Mock Data", result);
        System.out.println("testFetchData passed: " + result);
        verify(mockApi).getData();
    }

    @Test
    public void testFetchDataWhenUnavailable() {
        when(mockApi.isAvailable()).thenReturn(false);
        String result = service.fetchData();
        assertEquals("Service Unavailable", result);
        System.out.println("testFetchDataWhenUnavailable passed: " + result);
        verify(mockApi, never()).getData();
    }

    @Test
    public void testSendData() {
        when(mockApi.postData("Hello")).thenReturn("Success");
        String result = service.sendData("Hello");
        assertEquals("Success", result);
        System.out.println("testSendData passed: " + result);
        verify(mockApi).postData("Hello");
    }
}
