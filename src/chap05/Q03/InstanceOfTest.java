package chap05.Q03;

public class InstanceOfTest {

    public static void main(String[] args) {
        Person p1 = new Person("Brown", 19, "Busan");
        Person p2 = new Person("James", 20, "Masan");
        Student s1 = new Student("Ford", 19, "Kimhae", "PNU");
        Student s2 = new Student("Porter", 20, "Ulsan", "PNU");
        Professor pr1 = new Professor("Chae", 52, "Seoul", "PNU", "Computer Science");
        Professor pr2 = new Professor("Kim", 40, "Pusan", "PNU", "Computer Science");

        Person[] list = {p1, p2, s1, s2, pr1, pr2};


        for (Person p : list) {
            System.out.printf("%s, %d, %s%n", p.getName(), p.getAge(), p.getAddress());
            if (p instanceof Student) {
                Student s = (Student) p;
                System.out.printf(" School: %s, %s%n", s.getSchoolName(), s.getGrade());
            } else if (p instanceof Professor) {
                Professor pr = (Professor) p;
                System.out.printf(" School: %s, %s%n", pr.schoolName(), pr.major());
            }
        }

    }
}