public class Course {
    private String _courseID;
    private String _courseName;

    public Course(String courseID, String courseName) {
        this._courseID = courseID;
        this._courseName = courseName;
    }

    public String getCourseID() {
        return this._courseID;
    }

    public String getCourseName() {
        return this._courseName;
    }

    @Override
    public String toString() {
        return this._courseID + " " + this._courseName;
    }
}