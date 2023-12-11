package chap05.Q05;

public class Customer {
    private final String name;
    private int point;
    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }
    public final int getPoint() {return point;}
    public void setPoint(int point) {this.point = point;}
    public final String getName() {return name;}
}