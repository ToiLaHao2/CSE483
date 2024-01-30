import java.util.List;
import java.util.ArrayList;

public class RoleFilter implements IFilter {

    @Override
    public List<Employee> process(String request) {
        Company company = new Company();
        ArrayList<Employee> employees = (ArrayList<Employee>) company.getEmployees();
        ArrayList<Employee> output = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getRole().toLowerCase().equals(request.toLowerCase()))
            output.add(e);
        }
        return output;
    }
}
