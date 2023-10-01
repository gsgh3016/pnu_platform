package chap04;

import java.util.Map;
import java.util.HashMap;
public class EmployeeRepository {
    //your code here
    private Map<String, Employee> employees = new HashMap<String, Employee>();
    private static final EmployeeRepository INSTANCE = new EmployeeRepository();
    private EmployeeRepository(){
        this.employees = new HashMap<String, Employee>();
    }

    public static EmployeeRepository getInstance() {
        //your code here
        return INSTANCE;
    }

    public void add(Employee employee) {
        employees.put(employee.getName(), employee);
    }

    public boolean contains(Employee employee) {
        return employees.containsKey(employee.getName());
    }

    public Employee get(Employee employee) {
        return employees.get(employee.getName());
    }
}
