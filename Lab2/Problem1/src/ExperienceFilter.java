import java.util.ArrayList;
import java.util.List;

public class ExperienceFilter implements IFilter {

    @Override
    public List<Employee> process(String request) {
        Company company = new Company();
        ArrayList<Employee> employees = (ArrayList<Employee>) company.getEmployees();
        ArrayList<Employee> output = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getExperience().toLowerCase().equals(request.toLowerCase()))
                output.add(e);
        }
        printSort(output);
        return output;
    }

    private void printSort(List<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employee e : employees) {
            sb.append(e.toString() + "/n");
        }
        System.out.println(sb);
    }
}
