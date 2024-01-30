import java.util.ArrayList;
import java.util.List;

public class SalaryFilter implements IFilter {

    @Override
    public List<Employee> process(String request) {
        Company company = new Company();
        ArrayList<Employee> employees = (ArrayList<Employee>) company.getEmployees();
        ArrayList<Employee> output = new ArrayList<>();
        for (Employee e : employees) {
            if (Integer.toString(e.getSalary()).equals(request.toLowerCase()))
                output.add(e);
        }
        return output;
    }
}
