import java.util.List;
import java.util.ArrayList;

public class Company {
    private List<Employee> employees;

    public Company() {
        addEmployee();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    private void addEmployee() {
        employees = new ArrayList<>();
        employees.add(new Employee("John Doe", "12345", "Engineering", "Software Engineer", "5 years", 80000,
                "Java, Python, JavaScript"));
        employees.add(new Employee("Jane Smith", "67890", "Marketing", "Marketing Manager", "10 years", 100000,
                "Marketing strategy, social media marketing, content marketing"));
        employees.add(new Employee("Bob Johnson", "11111", "Sales", "Sales Representative", "3 years", 60000,
                "Customer relationship management, sales techniques, negotiation"));
        employees.add(new Employee("Mary Williams", "22222", "Finance", "Accountant", "7 years", 75000,
                "Financial accounting, auditing, tax preparation"));
        employees.add(new Employee("David Lee", "33333", "Human Resources", "HR Generalist", "4 years", 65000,
                "Recruitment, employee relations, benefits administration"));
        employees.add(new Employee("Sarah Miller", "44444", "Operations", "Project Manager", "6 years", 85000,
                "Project management, risk management, change management"));
        employees.add(new Employee("Michael Brown", "55555", "IT", "Systems Administrator", "8 years", 90000,
                "Network administration, server administration, cloud computing"));
        employees.add(new Employee("Emily Jones", "66666", "Legal", "Paralegal", "2 years", 50000,
                "Legal research, legal writing, case management"));
        employees.add(new Employee("Kevin Nguyen", "77777", "Customer Service",
                "Customer Service Representative",
                "1 year", 45000, "Customer service, problem-solving, communication"));
        employees.add(new Employee("Sofia Rodriguez", "88888", "Product Development", "Product Manager",
                "9 years",
                95000, "Product development, market research, product marketing"));
    }
}
