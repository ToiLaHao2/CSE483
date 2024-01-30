public class Client {
    private FilterManager filterManager;

    public Client() {

    }

    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(int choice, String request) {
        this.filterManager.filterRequest(choice, request);
    }
}
