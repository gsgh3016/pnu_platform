package chap07.Q004;

public class AreaComputableTest {
    public static void main(String[] args) {
        Circle2 c1 = new Circle2(0, 0, 15);
        Circle2 c2 = new Circle2(10, 10, 10);

        Triangle t1 = new Triangle(10, 20);
        Triangle t2 = new Triangle(20, 20);

        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(20, 20);

        AreaComputable[] list = {c1, c2, t1, t2, r1, r2};

        float totalArea = 0;
        for (AreaComputable elem : list) {
            final float area = elem.getArea();
            System.out.printf("%-40s Area: %10.2f%n", elem, area);
            totalArea += area;
        }
        System.out.printf("Total Area%n%10.2f%n", totalArea);

        MyComparable[] list2 = {r1, r2};

        for (MyComparable myComparable : list2) {
            if (list2[0].compareTo(myComparable) < 0) {
                System.out.println(list2[0] + " has smaller size than " + myComparable);
            } else if (list2[0].compareTo(myComparable) == 0) {
                System.out.println(list2[0] + " has the same size as " + myComparable);
            } else if (list2[0].compareTo(myComparable) > 0) {
                System.out.println(list2[0] + " has the larger size than " + myComparable);
            }
        }
    }

}