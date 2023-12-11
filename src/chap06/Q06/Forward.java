package chap06.Q06;

public class Forward extends Player{
    @Override
    protected void setSpeed() {super.speed = 110;}

    @Override
    public String toString() {return super.toString() + ", Forward";}
}
