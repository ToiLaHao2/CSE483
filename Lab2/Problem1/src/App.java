import java.util.ArrayList;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        Target target = new Target();
        FilterManager filterManager = new FilterManager(target);
        Scanner sc = new Scanner(System.in);

        DepartmentFilter departmentFilter = new DepartmentFilter();
        RoleFilter roleFilter = new RoleFilter();
        ExperienceFilter experienceFilter = new ExperienceFilter();
        SalaryFilter salaryFilter = new SalaryFilter();

        filterManager.setFilter(departmentFilter);
        filterManager.setFilter(roleFilter);
        filterManager.setFilter(experienceFilter);
        filterManager.setFilter(salaryFilter);

        Client client = new Client();
        client.setFilterManager(filterManager);
        Option.showOption();
        int option = sc.nextInt();
        if (option > 3 || option < 0)
            System.out.println("Wrong input");
        else {
            System.out.println("Enter what you want to sort: ");
            String request = sc.nextLine();
            client.sendRequest(option, request);
        }

    }
}
