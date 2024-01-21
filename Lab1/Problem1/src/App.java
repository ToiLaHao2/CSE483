public class App {
    public static void main(String[] args) throws Exception {
        CourseManagerA manager = CourseManagerA.getInstance();
        Course course = new Course("321312", "Hello");
        manager.addCourse(course);
        manager.retrievingCourses();
    }
}
