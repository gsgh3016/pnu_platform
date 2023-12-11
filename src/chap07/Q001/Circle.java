package chap07.Q001;

public class Circle implements MyComparable {
    private int x;
    private int y;
    private int radius;
    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.radius = r;
    }
    @Override
    public int compareTo(Object other) {
        if (!(other instanceof Circle)) return -2;
        Circle otherCircle = (Circle) other;
        int returnValue = 0;
        if (radius < otherCircle.radius)
            returnValue = -1;
        if (radius == otherCircle.radius)
            returnValue = 0;
        if (radius > otherCircle.radius)
            returnValue = 1;
        return returnValue;
    }

    @Override
    public boolean equal(Object other) {
        if (!(other instanceof Circle)) return false;
        Circle otherCircle = (Circle) other;
        return x == otherCircle.x &&
                y == otherCircle.y &&
                radius == otherCircle.radius;
    }

    @Override
    public String toString() {
        return String.format("Circle{x=%d, y=%d, radius=%d}", x, y, radius);
    }
}
