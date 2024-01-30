public class FilterManager {
    private FilterChain filterChain;

    public FilterManager(Target target) {
        this.filterChain = new FilterChain();
        this.filterChain.setTarget(target);
    }

    public void setFilter(IFilter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(int choice, String request) {
        filterChain.execute(choice, request);
    }

}
