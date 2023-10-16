package chap05.Q01;

public class Person {

    private String address;
    private int age;
    private String name;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getName() {return this.name;}
    public void rename(String name) {this.name = name;}
    public int getAge() {return this.age;}
    public void increaseAge() {this.age++;}
    public String getAddress() {return address;}
    public void moveTo(String address) {this.address = address;}
    @Override
    public String toString() {
        return String.format("%s, %d, %s", name, age, address);
    }
}
