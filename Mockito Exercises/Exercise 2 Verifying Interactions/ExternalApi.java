public interface ExternalApi {
    String getData();
    String postData(String data);
    boolean isAvailable();
    void deleteData(int id);
}
