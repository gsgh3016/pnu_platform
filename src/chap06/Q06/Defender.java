package chap06.Q06;

public class Defender extends Player{
    @Override
    protected void setSpeed() {super.speed = 90;}

    @Override
    public String toString() {return super.toString() + ", Defender";}
}
