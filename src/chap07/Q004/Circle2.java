package chap07.Q004;

public class Circle2 implements AreaComputable {
    private final int x;
    private final int y;
    private final int radius;
    public Circle2(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (radius * radius * Math.PI);
    }

    @Override
    public String toString() {
        return String.format("Circle2{x=%d, y=%d, radius=%d}", x, y, radius);
    }
}
