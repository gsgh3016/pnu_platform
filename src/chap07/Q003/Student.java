package chap07.Q003;

public class Student implements MyComparable {
    private int id;
    private String name;
    private float gpa;
    public Student(int id, String description, float gpa) {
        this.id = id;
        this.name = description;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Object other) {
        if (!(other instanceof Student)) return -2;
        Student otherStudent = (Student) other;
        int returnValue = 0;
        if (gpa < otherStudent.gpa) returnValue = -1;
        if (gpa == otherStudent.gpa) returnValue = 0;
        if (gpa > otherStudent.gpa) returnValue = 1;
        return returnValue;
    }

    @Override
    public boolean equal(Object other) {
        if (!(other instanceof Student)) return false;
        Student otherStudent = (Student) other;
        return id == otherStudent.id;
    }

    @Override
    public String toString() {
        return String.format("ID:\t%d, Name:\t%s, GPA:\t%.2f", id, name, gpa);
    }
}
