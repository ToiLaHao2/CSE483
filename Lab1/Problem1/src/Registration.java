import java.util.ArrayList;
import java.util.List;

public class Registration {
    private Student _student;
    private List<Course> _courses;

    public Registration(Student student) {
        this._student = student;
        this._courses = new ArrayList<>();
    }

    public void registingCourse(Course course) {
        this._courses.add(course);
    }

    public void unregistingCourse(Course course) {
        this._courses.remove(course);
    }

    @Override
    public String toString() {
        return this._student.toString() + "\n" + courses();
    }

    private String courses() {
        StringBuilder sb = new StringBuilder("Courses:\n");
        for (int i = 0; i < this._courses.size(); i++) {
            Course c = (Course) this._courses.get(i);
            sb.append("\t").append(i + 1).append(". ").append(c
                    .toString()).append("\n");
        }
        return sb.toString();
    }
}