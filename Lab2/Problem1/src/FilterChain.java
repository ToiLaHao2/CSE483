import java.util.List;
import java.util.ArrayList;

public class FilterChain {
    private List<IFilter> filters = new ArrayList<IFilter>();
    private Target target;

    public FilterChain() {

    }

    public void addFilter(IFilter filter) {
        filters.add(filter);
    }

    public void execute(int choice, String request) {
        filters.get(choice).process(request);
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
