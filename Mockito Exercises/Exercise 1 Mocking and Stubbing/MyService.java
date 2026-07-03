public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        if (externalApi.isAvailable()) {
            return externalApi.getData();
        }
        return "Service Unavailable";
    }

    public String sendData(String data) {
        return externalApi.postData(data);
    }
}
