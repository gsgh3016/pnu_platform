package chap05.Q01;

public class Professor extends Person{
    private String major;
    private String schoolName;

    public Professor(String name, int age, String address, String schoolName, String major) {
        super(name, age, address);
        this.schoolName = schoolName;
        this.major = major;
    }

    public void setMajor(String major) {this.major = major;}
    public String getMajor() {return this.major;}
    public void setSchoolName(String schoolName) {this.schoolName = schoolName;}
    public String getSchoolName() {return this.schoolName;}

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s, %s",
                getName(), getAge(), getAddress(), schoolName, major);
    }
}
