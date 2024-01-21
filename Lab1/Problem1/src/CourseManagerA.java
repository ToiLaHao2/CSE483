import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagerA {
    private static CourseManagerA instance;
    private List<Course> courses;
    private List<Student> students;
    private HashMap<String, Registration> registrations;

    private CourseManagerA() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.registrations = new HashMap<>();
    }

    public static CourseManagerA getInstance() {
        if (instance == null) {
            instance = new CourseManagerA();
        }
        return instance;
    }

    // Methods for managing courses, students, and registrations
    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeStudent(String studentID) {
        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                students.remove(s);
                System.out.println("Remove success");
                break;
            }
        }
    }

    public void removeCourse(String courseID) {
        for (Course c : courses) {
            if (c.getCourseID().equals(courseID)) {
                courses.remove(c);
                System.out.println("Remove success");
                break;
            }
        }
    }

    public void registering(Student student, Course course) {
        if (registrations.containsKey(student.getStudentID())) {
            Registration registration = registrations.get(student.getStudentID());
            registration.registingCourse(course);
            registrations.replace(student.getStudentID(), registration);
            System.out.println("Success");
        } else {
            Registration reg = new Registration(student);
            reg.registingCourse(course);
            registrations.put(student.getStudentID(), reg);
            System.out.println("Success");
        }

    }

    public void unregistering(Student student, Course course) {
        if (registrations.containsKey(student.getStudentID())) {
            Registration registration = registrations.get(student.getStudentID());
            registration.unregistingCourse(course);
            System.out.println("Success");
        } else {
            System.out.println("Wrong input");
        }
    }

    public void retrievingStudents() {
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    public void retrievingCourses() {
        for (Course c : courses) {
            System.out.println(c.toString());
        }
    }

    public void retrievingRegistration() {
        for (Map.Entry<String, Registration> entry : registrations.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
