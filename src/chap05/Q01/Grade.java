package chap05.Q01;

public class Grade {
    public static final int FRESH = 1;
    public static final int SOPHOMORE = 1;
    public static final int JUNIOR = 1;
    public static final int SENIOR = 1;
    private int grade;

    public Grade() {
        this.grade = FRESH;
    }
    public Grade(int grade) {this.grade = grade;}
    public int getGrade() {return grade;}
    public void upGrade() {if (grade != SENIOR) grade++;}
    @Override
    public String toString() {return String.valueOf(grade);}
}
