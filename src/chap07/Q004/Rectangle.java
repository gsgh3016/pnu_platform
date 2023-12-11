package chap07.Q004;

public class Rectangle implements AreaComputable, MyComparable {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public float getArea() {
        return (float) width * height;
    }

    public int compareTo(Object other) {
        Rectangle otherRectangle = (Rectangle) other;
        if (width * height < otherRectangle.width * otherRectangle.height) {
            return -1;
        } else if (width * height == otherRectangle.width * otherRectangle.height) {
            return 0;
        } else if (width * height > otherRectangle.width * otherRectangle.height) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        return String.format("Rectangle{Width: %d, Height: %d}", width, height);
    }

    public boolean equal(Object other) {
        if (!(other instanceof Rectangle)) return false;
        Rectangle otherRectangle = (Rectangle) other;
        return otherRectangle.height == height && otherRectangle.width == width;
    }
}
