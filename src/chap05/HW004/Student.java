package chap05.HW004;

public class Student {
    private String id;
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 50, message = "Name should be between 3 to 50 characters")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', email='%s'}", id, name, email);
    }
}
