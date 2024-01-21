public class Student {
    private String _studentID;
    private String _studentName;

    public Student(String studentID, String studentName) {
        this._studentID = studentID;
        this._studentName = studentName;
    }

    public String getStudentID() {
        return _studentID;
    }

    public String getStudentName() {
        return _studentName;
    }

    @Override
    public String toString() {
        return this._studentID + " " + this._studentName;
    }
}
