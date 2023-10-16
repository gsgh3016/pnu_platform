package chap05.Q04;

public class Triangle extends Shape{
    private final float a;
    private final float b;
    private final float c;
    private final float p;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.p = (a + b + c) / 2;
    }

    @Override
    public float getLength() {
        return a + b + c;
    }

    @Override
    public void draw() {
        System.out.printf("Triangle, Area: %.2f, Length: %.2f", getArea(), getLength());
    }

    @Override
    public float getArea() {
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void setLineColor(int color) {

    }

    @Override
    public int getLineColor() {
        return 0;
    }
}
