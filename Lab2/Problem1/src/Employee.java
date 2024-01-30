
public class Employee {
    private String _name;
    private String _id;
    private String _department;
    private String _role;
    private String _exprerience;
    private int _salary;
    private String _skills;

    public Employee(String name, String id, String department, String role, String experience, int salary,
            String skills) {
        this._name = name;
        this._id = id;
        this._department = department;
        this._role = role;
        this._exprerience = experience;
        this._salary = salary;
        this._skills = skills;
    }

    public void setDepartment(String department) {
        this._department = department;
    }

    public void setRole(String role) {
        this._role = role;
    }

    public void setExperience(String experience) {
        this._exprerience = experience;
    }

    public void setSalary(int salary) {
        this._salary = salary;
    }

    public void setSkill(String skill) {
        this._skills = skill;
    }

    public String getName() {
        return this._name;
    }

    public String getDepartment() {
        return this._department;
    }

    public String getRole() {
        return this._role;
    }

    public String getExperience() {
        return this._exprerience;
    }

    public int getSalary() {
        return this._salary;
    }

    public String getSkills() {
        return this._skills;
    }

    @Override
    public String toString() {
        return this._name + " " + this._id + " " + this._department + " " + this._role + " " + this._exprerience + " "
                + this._salary + " " + this._skills;
    }
}
