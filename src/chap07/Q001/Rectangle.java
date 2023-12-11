package chap07.Q001;

public class Rectangle implements MyComparable {
    private int width;
    private int height;
    private int area;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        this.area = width * height;
    }

    @Override
    public int compareTo(Object other) {
        if (!(other instanceof Rectangle))
            return -2;
        Rectangle otherRectangle = (Rectangle) other;
        int returnValue = 0;
        if (area < otherRectangle.area)
            returnValue = -1;
        if (area == otherRectangle.area)
            returnValue = 0;
        if (area > otherRectangle.area)
            returnValue = 1;
        return returnValue;
    }

    @Override
    public boolean equal(Object other) {
        if (!(other instanceof Rectangle))
            return false;
        Rectangle otherRectangle = (Rectangle) other;
        return width == otherRectangle.width &&
                height == otherRectangle.height &&
                area == otherRectangle.area;
    }

    @Override
    public String toString() {
        return String.format("Rectangle{area=%d}", area);
    }
}
