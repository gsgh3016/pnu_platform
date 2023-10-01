package chap04;

import java.util.Scanner;

class Triangle {
    private final int base;
    private final int height;

    public Triangle(int base, int height) {
        this.base = base; this.height = height;
    }
    //Your code here (멤버 변수로 밑변과 높이를 정의)
    //Your code here (생성자, getArea(), toString() 메서드 정의)
    public Double getArea() {
        return (double) (this.base * this.height) * (.5);
    }

    public String toString() {
        return String.format("Triangle [base=%d, height=%d, area=%.2f]", this.base, this.height, this.getArea());
    }
}
public class TriangleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Triangle[] triangles = new Triangle[n];
        for(int i=0; i<n; i++) {
            String[] cmd = sc.nextLine().split(" ");
            int b = Integer.parseInt(cmd[0]), h = Integer.parseInt(cmd[1]);
            triangles[i] = new Triangle(b, h);
            System.out.println(triangles[i].toString());
        }
    }
}
