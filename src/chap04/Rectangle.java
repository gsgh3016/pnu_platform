package chap04;

public class Rectangle {
    private Point rightDown;
    private Point leftUp;
    public Rectangle(Point p1, Point p2) {
        this.rightDown = p1;
        this.leftUp = p2;
    }
    //copy constructor
    public void moveBy(int x, int y) {
        //your code here
        this.rightDown.setX(this.rightDown.getX() + x);
        this.rightDown.setY(this.rightDown.getY() + y);
        this.leftUp.setX(this.leftUp.getX() + x);
        this.leftUp.setY(this.leftUp.getY() + y);
    }

    public Rectangle(Rectangle rectangle) {
        if (rectangle.rightDown == null || rectangle.leftUp == null) {
            System.out.println("Cannot copy rectangle object");
            return;
        }
        this.rightDown = new Point(rectangle.rightDown.getX(), rectangle.rightDown.getY());
        this.leftUp = new Point(rectangle.leftUp.getX(), rectangle.leftUp.getY());
    }

    @Override
    public String toString() {
        //your code here
        return String.format("Rectangle[(%d, %d), (%d, %d)]",
                this.rightDown.getX(),
                this.rightDown.getY(),
                this.leftUp.getX(),
                this.leftUp.getY());
    }
}