package chap06.Q06;

public class MidFielder extends Player{
    @Override
    protected void setSpeed() {super.speed = 100;}

    @Override
    public String toString() {return super.toString() + ", MidFielder";}
}
