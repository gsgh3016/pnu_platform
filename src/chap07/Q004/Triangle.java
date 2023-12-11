package chap07.Q004;

public class Triangle implements AreaComputable {
    private final int width;
    private final int height;

    public Triangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public float getArea() {
        return (float) (width * height * 0.5);
    }

    public String toString() {
        return String.format("Triangle{Width: %d, Height: %d", width, height);
    }
}
