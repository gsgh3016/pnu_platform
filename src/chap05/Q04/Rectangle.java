package chap05.Q04;

public class Rectangle extends Shape{

    private final int a;
    private final int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public float getLength() {
        return 2 * (a + b);
    }

    @Override
    public float getArea() {
        return a * b;
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
