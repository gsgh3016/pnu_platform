package chap05.Q04;

public class Rectangle extends Shape{

    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getLength() {
        return 2 * (width + height);
    }

    @Override
    public float getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.printf("Rectangle, Area: %.2f, Length: %.2f", getArea(), getLength());
    }

    @Override
    public void setLineColor(int color) {
    }

    @Override
    public int getLineColor() {
        return 0;
    }
}
