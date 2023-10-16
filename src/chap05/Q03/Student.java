package chap05.Q03;

import java.util.Objects;

public class Student extends Person {
    private String schoolName;
    private Grade grade = Grade.FRESH;

    public Student(String name, int age, String address, String schoolName) {
        super(name, age, address);
        this.schoolName = schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public Grade getGrade() {return grade;}
    public void upGrade() {grade = grade.upGrade();}
    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s, %s",
                getName(), getAge(), getAddress(), schoolName, grade);
    }
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Student s = (Student) obj;
        return (this.schoolName.equals(s.schoolName)) && (this.grade == s.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getAge(), this.getAddress(), schoolName, grade);
    }

    public String getSchoolName() {return schoolName;}
}
