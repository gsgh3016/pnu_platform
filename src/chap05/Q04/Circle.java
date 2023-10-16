package chap05.Q04;

public class Circle extends Shape{
    private final int radius;
    public Circle(int radius) {this.radius = radius;}

    @Override
    public float getLength() {
        return 2 * this.radius * (float) Math.PI;
    }

    @Override
    public float getArea() {
        return this.radius * this.radius * (float) Math.PI;
    }

    @Override
    public void draw() {
        System.out.printf("Circle, Area: %.2f, Length: %.2f\n", this.getArea(), this.getLength());
    }

    @Override
    public void setLineColor(int color) {

    }

    @Override
    public int getLineColor() {
        return 0;
    }
}
