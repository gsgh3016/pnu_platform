package chap05.HW004;

import java.util.HashMap;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository{
    private final Map<String, Student> students = new HashMap<>();

    public Student save(@Valid Student student) {
        return students.put(student.getId(), student);
    }
}