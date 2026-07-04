public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String sendData(String data) {
        return externalApi.postData(data);
    }

    public void removeData(int id) {
        externalApi.deleteData(id);
    }
}
