package chap05.HW004;

public class GraduateStudent extends Student {
    @NotNull(message = "Thesis title cannot be null")
    @Size(min = 5, max = 200, message = "Thesis title should be between 5 to 200 characters")
    private String thesisTitle;

    public GraduateStudent(String id, String name, String email, String thesisTitle) {
        super(id, name, email);
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        return String.format("GraduateStudent{%s}, thesisTitle='%s'", super.toString(), thesisTitle);
    }
}
