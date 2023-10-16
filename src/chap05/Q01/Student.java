package chap05.Q01;

public class Student extends Person{
    private String schoolName;
    private Grade grade = new Grade();

    public Student(String name, int age, String address, String schoolName) {
        super(name, age, address);
        this.schoolName = schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public Grade getGrade() {return grade;}
    public void upGrade() {grade.upGrade();}
    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s, %s",
                getName(), getAge(), getAddress(), schoolName, grade);
    }
}
