package chap04;

import java.util.Objects;

public class Employee {
    private final String name;
    private final Double salary;
    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = (double) salary;
    }
    public String getName() {
        //Your code here
        return this.name;
    }

    public Double getSalary() {
        //Your code here
        return this.salary;
    }

    @Override
    public String toString() {
        //Your code here
        return String.format("%s %.1f", this.name, this.salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
