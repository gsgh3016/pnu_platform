package chap05.Q03;

import java.util.Objects;

public class Person{

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Person p  = (Person) obj;
        return (this.name.equals(p.name)) && (this.age == p.age) && (this.address.equals(p.address));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }
}
